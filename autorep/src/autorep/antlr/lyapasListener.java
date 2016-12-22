// Generated from lyapas.g by ANTLR 4.5.3
package autorep.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lyapasParser}.
 */
public interface lyapasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lyapasParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(lyapasParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link lyapasParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(lyapasParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link lyapasParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(lyapasParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link lyapasParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(lyapasParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link lyapasParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(lyapasParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link lyapasParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(lyapasParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link lyapasParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(lyapasParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link lyapasParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(lyapasParser.EndContext ctx);
}