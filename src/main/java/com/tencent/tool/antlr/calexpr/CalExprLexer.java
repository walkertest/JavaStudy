// Generated from F:/javatask/github/JavaStudy/src/main/resources/java/antlr\CalExpr.g4 by ANTLR 4.10.1
package com.tencent.tool.antlr.calexpr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, CLEANMEM=4, FAC=5, POW=6, MUL=7, DIV=8, ADD=9, 
		SUB=10, DOT=11, ID=12, NUMBER=13, NEWLINE=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "CLEANMEM", "FAC", "POW", "MUL", "DIV", "ADD", 
			"SUB", "DOT", "ID", "NUMBER", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'CLEANMEM'", "'!'", "'^'", "'*'", "'/'", 
			"'+'", "'-'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "CLEANMEM", "FAC", "POW", "MUL", "DIV", "ADD", 
			"SUB", "DOT", "ID", "NUMBER", "NEWLINE", "WS"
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


	public CalExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000f[\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0004\u000b>\b\u000b\u000b"+
		"\u000b\f\u000b?\u0001\f\u0004\fC\b\f\u000b\f\f\fD\u0001\f\u0003\fH\b\f"+
		"\u0001\f\u0005\fK\b\f\n\f\f\fN\t\f\u0001\r\u0003\rQ\b\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0004\u000eV\b\u000e\u000b\u000e\f\u000eW\u0001\u000e\u0001"+
		"\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0003\u0002\u0000AZaz\u0001"+
		"\u000009\u0002\u0000\t\t  `\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001"+
		"\u0000\u0000\u0000\u0003!\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000"+
		"\u0000\u0007%\u0001\u0000\u0000\u0000\t.\u0001\u0000\u0000\u0000\u000b"+
		"0\u0001\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f4\u0001\u0000"+
		"\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u00138\u0001\u0000\u0000\u0000"+
		"\u0015:\u0001\u0000\u0000\u0000\u0017=\u0001\u0000\u0000\u0000\u0019B"+
		"\u0001\u0000\u0000\u0000\u001bP\u0001\u0000\u0000\u0000\u001dU\u0001\u0000"+
		"\u0000\u0000\u001f \u0005=\u0000\u0000 \u0002\u0001\u0000\u0000\u0000"+
		"!\"\u0005(\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005)\u0000"+
		"\u0000$\u0006\u0001\u0000\u0000\u0000%&\u0005C\u0000\u0000&\'\u0005L\u0000"+
		"\u0000\'(\u0005E\u0000\u0000()\u0005A\u0000\u0000)*\u0005N\u0000\u0000"+
		"*+\u0005M\u0000\u0000+,\u0005E\u0000\u0000,-\u0005M\u0000\u0000-\b\u0001"+
		"\u0000\u0000\u0000./\u0005!\u0000\u0000/\n\u0001\u0000\u0000\u000001\u0005"+
		"^\u0000\u00001\f\u0001\u0000\u0000\u000023\u0005*\u0000\u00003\u000e\u0001"+
		"\u0000\u0000\u000045\u0005/\u0000\u00005\u0010\u0001\u0000\u0000\u0000"+
		"67\u0005+\u0000\u00007\u0012\u0001\u0000\u0000\u000089\u0005-\u0000\u0000"+
		"9\u0014\u0001\u0000\u0000\u0000:;\u0005.\u0000\u0000;\u0016\u0001\u0000"+
		"\u0000\u0000<>\u0007\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@\u0018\u0001\u0000\u0000\u0000AC\u0007\u0001\u0000\u0000BA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FH\u0003\u0015\n\u0000GF\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HL\u0001\u0000\u0000\u0000"+
		"IK\u0007\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u001a\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OQ\u0005\r\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0005\n\u0000\u0000S\u001c\u0001\u0000\u0000\u0000TV\u0007\u0002\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006"+
		"\u000e\u0000\u0000Z\u001e\u0001\u0000\u0000\u0000\u0007\u0000?DGLPW\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}