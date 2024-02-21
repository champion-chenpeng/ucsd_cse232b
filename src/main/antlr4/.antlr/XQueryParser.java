// Generated from /Users/champion/Library/CloudStorage/OneDrive-UCSanDiego/UCSD/Course/wi24/cse232b/XQueryEvaluator/src/main/antlr4/XQuery.g4 by ANTLR 4.13.1

    package com.cse232b.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, StringConstant=37, IS=38, 
		ID=39, FILENAME=40, WHITESPACE=41;
	public static final int
		RULE_xq = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_joinClause = 5, RULE_cond = 6, RULE_startTag = 7, 
		RULE_endTag = 8, RULE_var = 9, RULE_idList = 10, RULE_ap = 11, RULE_doc = 12, 
		RULE_rp = 13, RULE_f = 14, RULE_tagName = 15, RULE_attrName = 16, RULE_stringConstant = 17, 
		RULE_eq = 18, RULE_fileName = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "forClause", "letClause", "whereClause", "returnClause", "joinClause", 
			"cond", "startTag", "endTag", "var", "idList", "ap", "doc", "rp", "f", 
			"tagName", "attrName", "stringConstant", "eq", "fileName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'{'", "'}'", "'for'", "'in'", 
			"'let'", "':='", "'where'", "'return'", "'join'", "'empty'", "'some'", 
			"'satisfies'", "'and'", "'or'", "'not'", "'<'", "'>'", "'$'", "'['", 
			"']'", "'doc(\"'", "'document(\"'", "'\")'", "'*'", "'.'", "'..'", "'text()'", 
			"'@'", "'='", "'\"'", "'eq'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "StringConstant", "IS", "ID", "FILENAME", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FLWRContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public FLWRContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleSlashXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleSlashXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagXQContext extends XqContext {
		public StartTagContext startTag() {
			return getRuleContext(StartTagContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
		}
		public TagXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApXQContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public ApXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetXQContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LetXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommaXQContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CommaXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarXQContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScXQContext extends XqContext {
		public TerminalNode StringConstant() { return getToken(XQueryParser.StringConstant, 0); }
		public ScXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BraceXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public BraceXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JoinXQContext extends XqContext {
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public JoinXQContext(XqContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleSlashXQContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DoubleSlashXQContext(XqContext ctx) { copyFrom(ctx); }
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				{
				_localctx = new VarXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(41);
				var();
				}
				break;
			case StringConstant:
				{
				_localctx = new ScXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(StringConstant);
				}
				break;
			case T__25:
			case T__26:
				{
				_localctx = new ApXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				ap();
				}
				break;
			case T__0:
				{
				_localctx = new BraceXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(T__0);
				setState(45);
				xq(0);
				setState(46);
				match(T__1);
				}
				break;
			case T__20:
				{
				_localctx = new TagXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				startTag();
				setState(49);
				match(T__5);
				setState(50);
				xq(0);
				setState(51);
				match(T__6);
				setState(52);
				endTag();
				}
				break;
			case T__7:
				{
				_localctx = new FLWRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				forClause();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(55);
					letClause();
					}
				}

				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(58);
					whereClause();
					}
				}

				setState(61);
				returnClause();
				}
				break;
			case T__9:
				{
				_localctx = new LetXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				letClause();
				setState(64);
				xq(2);
				}
				break;
			case T__13:
				{
				_localctx = new JoinXQContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				joinClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(78);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new CommaXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(69);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(70);
						match(T__2);
						setState(71);
						xq(8);
						}
						break;
					case 2:
						{
						_localctx = new SingleSlashXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(72);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(73);
						match(T__3);
						setState(74);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new DoubleSlashXQContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(75);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(76);
						match(T__4);
						setState(77);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__7);
			setState(84);
			var();
			setState(85);
			match(T__8);
			setState(86);
			xq(0);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(87);
				match(T__2);
				setState(88);
				var();
				setState(89);
				match(T__8);
				setState(90);
				xq(0);
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__9);
			setState(98);
			var();
			setState(99);
			match(T__10);
			setState(100);
			xq(0);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(101);
				match(T__2);
				setState(102);
				var();
				setState(103);
				match(T__10);
				setState(104);
				xq(0);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__11);
			setState(112);
			cond(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__12);
			setState(115);
			xq(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinClauseContext extends ParserRuleContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<IdListContext> idList() {
			return getRuleContexts(IdListContext.class);
		}
		public IdListContext idList(int i) {
			return getRuleContext(IdListContext.class,i);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__13);
			setState(118);
			match(T__0);
			setState(119);
			xq(0);
			setState(120);
			match(T__2);
			setState(121);
			xq(0);
			setState(122);
			match(T__2);
			setState(123);
			idList();
			setState(124);
			match(T__2);
			setState(125);
			idList();
			setState(126);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BraceCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public BraceCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public OrCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SatisfyCondContext extends CondContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public SatisfyCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyCondContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public EmptyCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndCondContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public AndCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public IsCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqCondContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public EqContext eq() {
			return getRuleContext(EqContext.class,0);
		}
		public EqCondContext(CondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotCondContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public NotCondContext(CondContext ctx) { copyFrom(ctx); }
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new EqCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				xq(0);
				setState(130);
				eq();
				setState(131);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new IsCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				xq(0);
				setState(134);
				match(IS);
				setState(135);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new EmptyCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__14);
				setState(138);
				match(T__0);
				setState(139);
				xq(0);
				setState(140);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new SatisfyCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__15);
				setState(143);
				var();
				setState(144);
				match(T__8);
				setState(145);
				xq(0);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(146);
					match(T__2);
					setState(147);
					var();
					setState(148);
					match(T__8);
					setState(149);
					xq(0);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(T__16);
				setState(157);
				cond(5);
				}
				break;
			case 5:
				{
				_localctx = new BraceCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__0);
				setState(160);
				cond(0);
				setState(161);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new NotCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(T__19);
				setState(164);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(173);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AndCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(167);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(168);
						match(T__17);
						setState(169);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new OrCondContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(170);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(171);
						match(T__18);
						setState(172);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartTagContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public StartTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTag; }
	}

	public final StartTagContext startTag() throws RecognitionException {
		StartTagContext _localctx = new StartTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_startTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__20);
			setState(179);
			tagName();
			setState(180);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndTagContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public EndTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endTag; }
	}

	public final EndTagContext endTag() throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_endTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__20);
			setState(183);
			match(T__3);
			setState(184);
			tagName();
			setState(185);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQueryParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__22);
			setState(188);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(XQueryParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(XQueryParser.ID, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_idList);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(T__23);
				setState(191);
				match(ID);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(192);
					match(T__2);
					setState(193);
					match(ID);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199);
				match(T__24);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__23);
				setState(201);
				match(T__24);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleAPContext extends ApContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DoubleAPContext(ApContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleAPContext extends ApContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleAPContext(ApContext ctx) { copyFrom(ctx); }
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ap);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new SingleAPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				doc();
				setState(205);
				match(T__3);
				setState(206);
				rp(0);
				}
				break;
			case 2:
				_localctx = new DoubleAPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				doc();
				setState(209);
				match(T__4);
				setState(210);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocContext extends ParserRuleContext {
		public FileNameContext fileName() {
			return getRuleContext(FileNameContext.class,0);
		}
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_doc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(215);
			fileName();
			setState(216);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrRPContext extends RpContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public AttrRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleSlashRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DoubleSlashRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextRPContext extends RpContext {
		public TextRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentRPContext extends RpContext {
		public ParentRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfRPContext extends RpContext {
		public SelfRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilterRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommaRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public CommaRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChildrenRPContext extends RpContext {
		public ChildrenRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagRPContext extends RpContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TagRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public BracketRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleSlashRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public SingleSlashRPContext(RpContext ctx) { copyFrom(ctx); }
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new TagRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(219);
				tagName();
				}
				break;
			case T__28:
				{
				_localctx = new ChildrenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(T__28);
				}
				break;
			case T__29:
				{
				_localctx = new SelfRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(T__29);
				}
				break;
			case T__30:
				{
				_localctx = new ParentRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(T__30);
				}
				break;
			case T__31:
				{
				_localctx = new TextRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(T__31);
				}
				break;
			case T__32:
				{
				_localctx = new AttrRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(T__32);
				setState(225);
				attrName();
				}
				break;
			case T__0:
				{
				_localctx = new BracketRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(T__0);
				setState(227);
				rp(0);
				setState(228);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new SingleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(232);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(233);
						match(T__3);
						setState(234);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new DoubleSlashRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(235);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(236);
						match(T__4);
						setState(237);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new CommaRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(238);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(239);
						match(T__2);
						setState(240);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(241);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(242);
						match(T__23);
						setState(243);
						f(0);
						setState(244);
						match(T__24);
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public EqContext eq() {
			return getRuleContext(EqContext.class,0);
		}
		public EqFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public BracketFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsFilterContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public IsFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RpFilterContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFilterContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public StringFilterContext(FContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrFilterContext(FContext ctx) { copyFrom(ctx); }
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new RpFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(252);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new EqFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				rp(0);
				setState(254);
				eq();
				setState(255);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new IsFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				rp(0);
				setState(258);
				match(IS);
				setState(259);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new StringFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				rp(0);
				setState(262);
				match(T__33);
				setState(263);
				match(T__34);
				setState(264);
				stringConstant();
				setState(265);
				match(T__34);
				}
				break;
			case 5:
				{
				_localctx = new BracketFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(T__0);
				setState(268);
				f(0);
				setState(269);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(T__19);
				setState(272);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(281);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(275);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(276);
						match(T__17);
						setState(277);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(278);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(279);
						match(T__18);
						setState(280);
						f(3);
						}
						break;
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQueryParser.ID, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQueryParser.ID, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQueryParser.ID, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends ParserRuleContext {
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !(_la==T__33 || _la==T__35) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileNameContext extends ParserRuleContext {
		public TerminalNode FILENAME() { return getToken(XQueryParser.FILENAME, 0); }
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fileName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(FILENAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 6:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 13:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 14:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00009\b\u0000\u0001\u0000\u0003\u0000<\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000D\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000O\b\u0000\n\u0000"+
		"\f\u0000R\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001]\b"+
		"\u0001\n\u0001\f\u0001`\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002k\b\u0002\n\u0002\f\u0002n\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u0098\b\u0006\n\u0006\f\u0006\u009b\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a6\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u00ae\b\u0006\n\u0006\f\u0006\u00b1\t\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00c3\b\n\n\n\f\n\u00c6"+
		"\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u00cb\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00d5\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00e7\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00f7\b\r\n\r\f\r\u00fa\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u0112\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u011a\b\u000e\n\u000e\f\u000e"+
		"\u011d\t\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0000\u0004\u0000\f\u001a\u001c\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0002\u0001"+
		"\u0000\u001a\u001b\u0002\u0000\"\"$$\u013e\u0000C\u0001\u0000\u0000\u0000"+
		"\u0002S\u0001\u0000\u0000\u0000\u0004a\u0001\u0000\u0000\u0000\u0006o"+
		"\u0001\u0000\u0000\u0000\br\u0001\u0000\u0000\u0000\nu\u0001\u0000\u0000"+
		"\u0000\f\u00a5\u0001\u0000\u0000\u0000\u000e\u00b2\u0001\u0000\u0000\u0000"+
		"\u0010\u00b6\u0001\u0000\u0000\u0000\u0012\u00bb\u0001\u0000\u0000\u0000"+
		"\u0014\u00ca\u0001\u0000\u0000\u0000\u0016\u00d4\u0001\u0000\u0000\u0000"+
		"\u0018\u00d6\u0001\u0000\u0000\u0000\u001a\u00e6\u0001\u0000\u0000\u0000"+
		"\u001c\u0111\u0001\u0000\u0000\u0000\u001e\u011e\u0001\u0000\u0000\u0000"+
		" \u0120\u0001\u0000\u0000\u0000\"\u0122\u0001\u0000\u0000\u0000$\u0124"+
		"\u0001\u0000\u0000\u0000&\u0126\u0001\u0000\u0000\u0000()\u0006\u0000"+
		"\uffff\uffff\u0000)D\u0003\u0012\t\u0000*D\u0005%\u0000\u0000+D\u0003"+
		"\u0016\u000b\u0000,-\u0005\u0001\u0000\u0000-.\u0003\u0000\u0000\u0000"+
		"./\u0005\u0002\u0000\u0000/D\u0001\u0000\u0000\u000001\u0003\u000e\u0007"+
		"\u000012\u0005\u0006\u0000\u000023\u0003\u0000\u0000\u000034\u0005\u0007"+
		"\u0000\u000045\u0003\u0010\b\u00005D\u0001\u0000\u0000\u000068\u0003\u0002"+
		"\u0001\u000079\u0003\u0004\u0002\u000087\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:<\u0003\u0006\u0003\u0000"+
		";:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=>\u0003\b\u0004\u0000>D\u0001\u0000\u0000\u0000?@\u0003\u0004\u0002"+
		"\u0000@A\u0003\u0000\u0000\u0002AD\u0001\u0000\u0000\u0000BD\u0003\n\u0005"+
		"\u0000C(\u0001\u0000\u0000\u0000C*\u0001\u0000\u0000\u0000C+\u0001\u0000"+
		"\u0000\u0000C,\u0001\u0000\u0000\u0000C0\u0001\u0000\u0000\u0000C6\u0001"+
		"\u0000\u0000\u0000C?\u0001\u0000\u0000\u0000CB\u0001\u0000\u0000\u0000"+
		"DP\u0001\u0000\u0000\u0000EF\n\u0007\u0000\u0000FG\u0005\u0003\u0000\u0000"+
		"GO\u0003\u0000\u0000\bHI\n\u0006\u0000\u0000IJ\u0005\u0004\u0000\u0000"+
		"JO\u0003\u001a\r\u0000KL\n\u0005\u0000\u0000LM\u0005\u0005\u0000\u0000"+
		"MO\u0003\u001a\r\u0000NE\u0001\u0000\u0000\u0000NH\u0001\u0000\u0000\u0000"+
		"NK\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000Q\u0001\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000ST\u0005\b\u0000\u0000TU\u0003\u0012\t\u0000UV\u0005"+
		"\t\u0000\u0000V^\u0003\u0000\u0000\u0000WX\u0005\u0003\u0000\u0000XY\u0003"+
		"\u0012\t\u0000YZ\u0005\t\u0000\u0000Z[\u0003\u0000\u0000\u0000[]\u0001"+
		"\u0000\u0000\u0000\\W\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0003\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005\n\u0000\u0000bc\u0003\u0012"+
		"\t\u0000cd\u0005\u000b\u0000\u0000dl\u0003\u0000\u0000\u0000ef\u0005\u0003"+
		"\u0000\u0000fg\u0003\u0012\t\u0000gh\u0005\u000b\u0000\u0000hi\u0003\u0000"+
		"\u0000\u0000ik\u0001\u0000\u0000\u0000je\u0001\u0000\u0000\u0000kn\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"m\u0005\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\f\u0000"+
		"\u0000pq\u0003\f\u0006\u0000q\u0007\u0001\u0000\u0000\u0000rs\u0005\r"+
		"\u0000\u0000st\u0003\u0000\u0000\u0000t\t\u0001\u0000\u0000\u0000uv\u0005"+
		"\u000e\u0000\u0000vw\u0005\u0001\u0000\u0000wx\u0003\u0000\u0000\u0000"+
		"xy\u0005\u0003\u0000\u0000yz\u0003\u0000\u0000\u0000z{\u0005\u0003\u0000"+
		"\u0000{|\u0003\u0014\n\u0000|}\u0005\u0003\u0000\u0000}~\u0003\u0014\n"+
		"\u0000~\u007f\u0005\u0002\u0000\u0000\u007f\u000b\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0006\u0006\uffff\uffff\u0000\u0081\u0082\u0003\u0000\u0000"+
		"\u0000\u0082\u0083\u0003$\u0012\u0000\u0083\u0084\u0003\u0000\u0000\u0000"+
		"\u0084\u00a6\u0001\u0000\u0000\u0000\u0085\u0086\u0003\u0000\u0000\u0000"+
		"\u0086\u0087\u0005&\u0000\u0000\u0087\u0088\u0003\u0000\u0000\u0000\u0088"+
		"\u00a6\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u000f\u0000\u0000\u008a"+
		"\u008b\u0005\u0001\u0000\u0000\u008b\u008c\u0003\u0000\u0000\u0000\u008c"+
		"\u008d\u0005\u0002\u0000\u0000\u008d\u00a6\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0005\u0010\u0000\u0000\u008f\u0090\u0003\u0012\t\u0000\u0090\u0091"+
		"\u0005\t\u0000\u0000\u0091\u0099\u0003\u0000\u0000\u0000\u0092\u0093\u0005"+
		"\u0003\u0000\u0000\u0093\u0094\u0003\u0012\t\u0000\u0094\u0095\u0005\t"+
		"\u0000\u0000\u0095\u0096\u0003\u0000\u0000\u0000\u0096\u0098\u0001\u0000"+
		"\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0005\u0011\u0000\u0000\u009d\u009e\u0003\f\u0006"+
		"\u0005\u009e\u00a6\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0001\u0000"+
		"\u0000\u00a0\u00a1\u0003\f\u0006\u0000\u00a1\u00a2\u0005\u0002\u0000\u0000"+
		"\u00a2\u00a6\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0014\u0000\u0000"+
		"\u00a4\u00a6\u0003\f\u0006\u0001\u00a5\u0080\u0001\u0000\u0000\u0000\u00a5"+
		"\u0085\u0001\u0000\u0000\u0000\u00a5\u0089\u0001\u0000\u0000\u0000\u00a5"+
		"\u008e\u0001\u0000\u0000\u0000\u00a5\u009f\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a6\u00af\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\n\u0003\u0000\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u00ae"+
		"\u0003\f\u0006\u0004\u00aa\u00ab\n\u0002\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0013\u0000\u0000\u00ac\u00ae\u0003\f\u0006\u0003\u00ad\u00a7\u0001\u0000"+
		"\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000"+
		"\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b0\r\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005\u0015\u0000\u0000\u00b3\u00b4\u0003\u001e\u000f"+
		"\u0000\u00b4\u00b5\u0005\u0016\u0000\u0000\u00b5\u000f\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0005\u0015\u0000\u0000\u00b7\u00b8\u0005\u0004\u0000"+
		"\u0000\u00b8\u00b9\u0003\u001e\u000f\u0000\u00b9\u00ba\u0005\u0016\u0000"+
		"\u0000\u00ba\u0011\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0017\u0000"+
		"\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd\u0013\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0005\u0018\u0000\u0000\u00bf\u00c4\u0005\'\u0000\u0000\u00c0"+
		"\u00c1\u0005\u0003\u0000\u0000\u00c1\u00c3\u0005\'\u0000\u0000\u00c2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00cb"+
		"\u0005\u0019\u0000\u0000\u00c8\u00c9\u0005\u0018\u0000\u0000\u00c9\u00cb"+
		"\u0005\u0019\u0000\u0000\u00ca\u00be\u0001\u0000\u0000\u0000\u00ca\u00c8"+
		"\u0001\u0000\u0000\u0000\u00cb\u0015\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0003\u0018\f\u0000\u00cd\u00ce\u0005\u0004\u0000\u0000\u00ce\u00cf\u0003"+
		"\u001a\r\u0000\u00cf\u00d5\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003\u0018"+
		"\f\u0000\u00d1\u00d2\u0005\u0005\u0000\u0000\u00d2\u00d3\u0003\u001a\r"+
		"\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d5\u0017\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0007\u0000\u0000\u0000\u00d7\u00d8\u0003&\u0013\u0000"+
		"\u00d8\u00d9\u0005\u001c\u0000\u0000\u00d9\u0019\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0006\r\uffff\uffff\u0000\u00db\u00e7\u0003\u001e\u000f\u0000"+
		"\u00dc\u00e7\u0005\u001d\u0000\u0000\u00dd\u00e7\u0005\u001e\u0000\u0000"+
		"\u00de\u00e7\u0005\u001f\u0000\u0000\u00df\u00e7\u0005 \u0000\u0000\u00e0"+
		"\u00e1\u0005!\u0000\u0000\u00e1\u00e7\u0003 \u0010\u0000\u00e2\u00e3\u0005"+
		"\u0001\u0000\u0000\u00e3\u00e4\u0003\u001a\r\u0000\u00e4\u00e5\u0005\u0002"+
		"\u0000\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00da\u0001\u0000"+
		"\u0000\u0000\u00e6\u00dc\u0001\u0000\u0000\u0000\u00e6\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e6\u00de\u0001\u0000\u0000\u0000\u00e6\u00df\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e0\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e7\u00f8\u0001\u0000\u0000\u0000\u00e8\u00e9\n\u0004\u0000"+
		"\u0000\u00e9\u00ea\u0005\u0004\u0000\u0000\u00ea\u00f7\u0003\u001a\r\u0005"+
		"\u00eb\u00ec\n\u0003\u0000\u0000\u00ec\u00ed\u0005\u0005\u0000\u0000\u00ed"+
		"\u00f7\u0003\u001a\r\u0004\u00ee\u00ef\n\u0001\u0000\u0000\u00ef\u00f0"+
		"\u0005\u0003\u0000\u0000\u00f0\u00f7\u0003\u001a\r\u0002\u00f1\u00f2\n"+
		"\u0002\u0000\u0000\u00f2\u00f3\u0005\u0018\u0000\u0000\u00f3\u00f4\u0003"+
		"\u001c\u000e\u0000\u00f4\u00f5\u0005\u0019\u0000\u0000\u00f5\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f6\u00e8\u0001\u0000\u0000\u0000\u00f6\u00eb\u0001"+
		"\u0000\u0000\u0000\u00f6\u00ee\u0001\u0000\u0000\u0000\u00f6\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u001b\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0006"+
		"\u000e\uffff\uffff\u0000\u00fc\u0112\u0003\u001a\r\u0000\u00fd\u00fe\u0003"+
		"\u001a\r\u0000\u00fe\u00ff\u0003$\u0012\u0000\u00ff\u0100\u0003\u001a"+
		"\r\u0000\u0100\u0112\u0001\u0000\u0000\u0000\u0101\u0102\u0003\u001a\r"+
		"\u0000\u0102\u0103\u0005&\u0000\u0000\u0103\u0104\u0003\u001a\r\u0000"+
		"\u0104\u0112\u0001\u0000\u0000\u0000\u0105\u0106\u0003\u001a\r\u0000\u0106"+
		"\u0107\u0005\"\u0000\u0000\u0107\u0108\u0005#\u0000\u0000\u0108\u0109"+
		"\u0003\"\u0011\u0000\u0109\u010a\u0005#\u0000\u0000\u010a\u0112\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0005\u0001\u0000\u0000\u010c\u010d\u0003"+
		"\u001c\u000e\u0000\u010d\u010e\u0005\u0002\u0000\u0000\u010e\u0112\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0005\u0014\u0000\u0000\u0110\u0112\u0003"+
		"\u001c\u000e\u0001\u0111\u00fb\u0001\u0000\u0000\u0000\u0111\u00fd\u0001"+
		"\u0000\u0000\u0000\u0111\u0101\u0001\u0000\u0000\u0000\u0111\u0105\u0001"+
		"\u0000\u0000\u0000\u0111\u010b\u0001\u0000\u0000\u0000\u0111\u010f\u0001"+
		"\u0000\u0000\u0000\u0112\u011b\u0001\u0000\u0000\u0000\u0113\u0114\n\u0003"+
		"\u0000\u0000\u0114\u0115\u0005\u0012\u0000\u0000\u0115\u011a\u0003\u001c"+
		"\u000e\u0004\u0116\u0117\n\u0002\u0000\u0000\u0117\u0118\u0005\u0013\u0000"+
		"\u0000\u0118\u011a\u0003\u001c\u000e\u0003\u0119\u0113\u0001\u0000\u0000"+
		"\u0000\u0119\u0116\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u001d\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005\'\u0000\u0000\u011f\u001f\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0005\'\u0000\u0000\u0121!\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0005\'\u0000\u0000\u0123#\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0007\u0001\u0000\u0000\u0125%\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"(\u0000\u0000\u0127\'\u0001\u0000\u0000\u0000\u00148;CNP^l\u0099\u00a5"+
		"\u00ad\u00af\u00c4\u00ca\u00d4\u00e6\u00f6\u00f8\u0111\u0119\u011b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}