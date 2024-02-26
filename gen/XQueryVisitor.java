// Generated from /Users/zhq/ucsd_cse232b/src/main/antlr4/XQuery.g4 by ANTLR 4.13.1

    package com.cse232b.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFLWR(XQueryParser.FLWRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleSlashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashXQ(XQueryParser.SingleSlashXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXQ(XQueryParser.TagXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXQ(XQueryParser.ApXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXQ(XQueryParser.LetXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaXQ(XQueryParser.CommaXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXQ(XQueryParser.VarXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScXQ(XQueryParser.ScXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braceXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceXQ(XQueryParser.BraceXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinXQ(XQueryParser.JoinXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleSlashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashXQ(XQueryParser.DoubleSlashXQContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinClause(XQueryParser.JoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braceCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceCond(XQueryParser.BraceCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code satisfyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatisfyCond(XQueryParser.SatisfyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCond(XQueryParser.IsCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCond(XQueryParser.EqCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(XQueryParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleAP}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAP(XQueryParser.SingleAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleAP}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleAP(XQueryParser.DoubleAPContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XQueryParser.DocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrRP(XQueryParser.AttrRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleSlashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashRP(XQueryParser.DoubleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRP(XQueryParser.TextRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRP(XQueryParser.ParentRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRP(XQueryParser.SelfRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildrenRP(XQueryParser.ChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagRP(XQueryParser.TagRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRP(XQueryParser.BracketRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleSlashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashRP(XQueryParser.SingleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFilter(XQueryParser.BracketFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFilter(XQueryParser.StringFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(XQueryParser.AttrNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XQueryParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#eq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(XQueryParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryParser.FileNameContext ctx);
}