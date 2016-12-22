package lyapaside;

import java.util.*;
import lyapaside.Formatter;

public class Autoformatter {
	public static String Format(String str)
	{
		List<Formatter> formatters = new ArrayList<Formatter>(); // вроде все правильно, но эклипс почему-то ругается
		String result = str;
		
		formatters.add(new FormatterExample()); // так добавляются форматеры в автоформатер
		formatters.add(new FormulaFormatter());
		
		for(Formatter formatter: formatters)
			result = formatter.Format(result);
		
		return result;
	}
}
