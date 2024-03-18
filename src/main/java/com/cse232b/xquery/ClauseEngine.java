package com.cse232b.xquery;

import com.cse232b.antlr4.XQueryBaseVisitor;
import com.cse232b.antlr4.XQueryParser;
import org.w3c.dom.Node;

import java.util.*;

/**
  * @author Peng Chen, Hanqing Zhao
  * @version 1.0
  * @date 02/23/2024
  * @description
  */

public class ClauseEngine extends XQueryBaseVisitor<List<Node>>{
	private final XQueryEngine xqueryEngine;
    private final List<Node> DEFAULT_COND_TRUE_LIST = new ArrayList<>(0);
    private List<Map<String, List<Node>>> forClausePerStates = new ArrayList<>();
	public ClauseEngine(XQueryEngine xqueryEngine_) {
		this.xqueryEngine = xqueryEngine_;
	}

    public void dfsForVarState(XQueryParser.ForClauseContext ctx,
                               int curIndex,
                               Map<String, List<Node>> curMap,
                               List<Map<String,List<Node>>> perStates) {
        List<Node> res;

        if(ctx.var().size() == curIndex) {
            perStates.add(curMap);
            return;
        }
        String var = ctx.var(curIndex).ID().getText();
        XQueryParser.XqContext xq = ctx.xq(curIndex);
        this.xqueryEngine.setContextMap(curMap);
        res = this.xqueryEngine.visit(xq);
        for (Node node : res) {
            Map<String, List<Node>> nextMap = new HashMap<>(curMap);
            LinkedList<Node> curNodeList = new LinkedList<>();
            curNodeList.add(node);
            nextMap.put(var, curNodeList);   // results in a deeper context map extended on the basis of the current context map

            dfsForVarState(ctx, curIndex + 1, nextMap, perStates);
        }

    }

    @Override
    public List<Node> visitForClause(XQueryParser.ForClauseContext ctx) {
        // for should generate all permutation state maps and then set perStates in this class for FLWR
        Map<String,List<Node>> currentContext = this.xqueryEngine.getContextMap();
        List<Map<String, List<Node>>> targetPerStates = new ArrayList<>();
        // set for FLWR
       dfsForVarState(ctx, 0,currentContext,targetPerStates);
       this.forClausePerStates = targetPerStates;
       return null;
    }

    @Override
    public List<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        Map<String, List<Node>> currentContext = this.xqueryEngine.getContextMap();
        List<XQueryParser.VarContext> vars = ctx.var();
        int varCnt = vars.size();
        List<XQueryParser.XqContext> xqs = ctx.xq();
        for (int i = 0; i < varCnt; i++) {
            String varName = vars.get(i).ID().getText();
            this.xqueryEngine.setContextMap(currentContext);
            List<Node> xqResult = this.xqueryEngine.visit(xqs.get(i));
            currentContext.put(varName, xqResult);
        }
        this.xqueryEngine.setContextMap(currentContext);
        return null;
    }

    @Override
    public List<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        // with given context, return the boolean result of cond
		CondEngine condEngine = new CondEngine(this.xqueryEngine);
        return condEngine.visit(ctx.cond()) ? DEFAULT_COND_TRUE_LIST : null;
    }

    @Override
    public List<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        // with given context, evaluate xq. should use the same context with where clause.
        return this.xqueryEngine.visit(ctx.xq());
    }

    @Override
    public List<Node> visitFLWR(XQueryParser.FLWRContext ctx) {
        List<Map<String, List<Node>>> oldStatesInForClause = this.forClausePerStates;
        visit(ctx.forClause()); //after this, varsInForClause is set. return is null
        List<Map<String, List<Node>>> currentCheckStates = this.forClausePerStates;
        // do not use current context, it is meaningless
        // update every per state with let
        XQueryParser.LetClauseContext letClauseCtx = ctx.letClause();
        if (letClauseCtx != null) {
            for (int i = 0; i < currentCheckStates.size(); i++) {
                Map<String, List<Node>> toUpdateContext = currentCheckStates.get(i);
                this.xqueryEngine.setContextMap(toUpdateContext);
                visit(ctx.letClause());
                currentCheckStates.set(i,this.xqueryEngine.getContextMap());
            }
        }
        List<Node> res = new LinkedList<>();
        for(Map<String, List<Node>> state : currentCheckStates) {
            this.xqueryEngine.setContextMap(state);
            // if no where clause, then where clause returns always true.
            XQueryParser.WhereClauseContext whereCtx = ctx.whereClause();
            List<Node> nullIfFalseList = whereCtx != null ? visit(ctx.whereClause()) : new LinkedList<>();
            if (nullIfFalseList != null) {
                // where return true
                this.xqueryEngine.setContextMap(state);
                List<Node> onePermRes = visit(ctx.returnClause());
                res.addAll(onePermRes);
            }
        }
        this.forClausePerStates = oldStatesInForClause;
        return res;
    }
}
