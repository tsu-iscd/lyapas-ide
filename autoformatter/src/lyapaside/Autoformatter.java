package lyapaside;

import java.util.*;
import lyapaside.Formatter;

public class Autoformatter {
	public static String Format(String str)
	{
		List<Formatter> formatters = new ArrayList<Formatter>();
		String result = str;
		
		formatters.add(new FormatterExample()); // так добавляются форматеры в автоформатер
		
		for(Formatter formatter: formatters)
			result = formatter.Format(result);
		
		return result;
	}
}
