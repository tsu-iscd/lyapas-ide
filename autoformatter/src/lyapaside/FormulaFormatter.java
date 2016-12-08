package lyapaside;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaFormatter implements Formatter {

	@Override
	public String Format(String str) {
		
		String[] lines = str.replaceAll("\n\\s+", "\n").split("\n");
		String result = "";
		
		for(String line: lines)
		{
			Pattern comment_pattern = Pattern.compile("[*]{3}.*");
			Matcher comment_matcher = comment_pattern.matcher(line);
			String comment = "";
			
			if(comment_matcher.find())
				comment = '\n' + comment_matcher.group(1);
			
			line.replaceAll("[*]{3}.*", "");
			
			// TODO
			
			result += comment;
		}
		
		return result;
	}

}
