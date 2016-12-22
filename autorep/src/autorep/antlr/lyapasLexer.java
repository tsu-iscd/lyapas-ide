// Generated from lyapas.g by ANTLR 4.5.3
package autorep.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lyapasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME_FUNC=1, FRET=2, COMMENT=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NAME_FUNC", "LETTER", "NOFLK", "VAR", "LOW_LINE", "L_PAR", "R_PAR", "FRET", 
		"COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'**'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NAME_FUNC", "FRET", "COMMENT"
	};
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


	public lyapasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lyapas.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5<\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\5\2\31\n\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\5\3(\n\3\3\4\3\4\5\4,\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\2\2\13\3\3\5\2\7\2\t\2\13\2\r\2\17\2\21\4\23\5\3"+
		"\2\4\5\2CGIKO\\\4\2\13\f\17\17:\2\3\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\3\25\3\2\2\2\5\'\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2"+
		"\2\17\63\3\2\2\2\21\65\3\2\2\2\238\3\2\2\2\25\30\5\5\3\2\26\31\5\5\3\2"+
		"\27\31\5\13\6\2\30\26\3\2\2\2\30\27\3\2\2\2\31\36\3\2\2\2\32\35\5\5\3"+
		"\2\33\35\5\13\6\2\34\32\3\2\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2"+
		"\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\5\r\7\2\"#\3\2\2\2#$\5\17"+
		"\b\2$\4\3\2\2\2%(\5\t\5\2&(\4C\\\2\'%\3\2\2\2\'&\3\2\2\2(\6\3\2\2\2),"+
		"\5\t\5\2*,\t\2\2\2+)\3\2\2\2+*\3\2\2\2,\b\3\2\2\2-.\4c|\2.\n\3\2\2\2/"+
		"\60\7a\2\2\60\f\3\2\2\2\61\62\7*\2\2\62\16\3\2\2\2\63\64\7+\2\2\64\20"+
		"\3\2\2\2\65\66\7,\2\2\66\67\7,\2\2\67\22\3\2\2\289\t\3\2\29:\3\2\2\2:"+
		";\b\n\2\2;\24\3\2\2\2\b\2\30\34\36\'+\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}