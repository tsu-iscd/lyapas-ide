import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.ANTLRInputStream;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			// В качестве входного потока символов устанавливаем консольный ввод
			ANTLRInputStream input = new ANTLRInputStream(System.in);
			// Настраиваем лексер на этот поток
			example1Lexer lexer = new example1Lexer(input);
			// Создаем поток токенов на основе лексера
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// Создаем парсер
			example1Parser parser = new example1Parser(tokens);
			// И запускаем первое правило грамматики!!!
			parser.equation();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
