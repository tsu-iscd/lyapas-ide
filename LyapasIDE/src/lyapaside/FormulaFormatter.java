package lyapaside;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class FormulaFormatter implements Formatter {

	@Override
	public String Format(String str) {
		
		String[] lines = str.replaceAll("\n\\s+", "\n").split("\n");
		String result = "";
		
		List<Pattern> ptrn_simple = AllOurPatterns.ptrn_simple();	//+
		Pattern ptrn_var = AllOurPatterns.ptrn_var();
		Pattern ptrn_bin = AllOurPatterns.ptrn_bin();
		Pattern ptrn_un_sle = AllOurPatterns.ptrn_un_sle();
		Pattern ptrn_un_spr = AllOurPatterns.ptrn_un_spr();
		Pattern ptrn_usl_per = AllOurPatterns.ptrn_usl_per();
		Pattern ptrn_per_ed = AllOurPatterns.ptrn_per_ed();			//+
		Pattern ptrn_elm_lfk = AllOurPatterns.ptrn_elm_lfk();
		
		for(String line: lines)
		{
			Pattern comment_pattern = Pattern.compile("[*]{3}.*");
			Matcher comment_matcher = comment_pattern.matcher(line);
			String comment = "";
			
			if(comment_matcher.find())
				comment = '\n' + comment_matcher.group(1);
			
			line.replaceAll("[*]{3}.*", "");
			
			while(!line.isEmpty())
			{
				boolean flag1 = false;
				for (Pattern ptrn: ptrn_simple)
				{
					Matcher m = ptrn.matcher(line);
					if (m.find())
					{
						result += m.group() + '\n';
						line = line.replaceAll(ptrn.pattern(), "").replaceAll("^\\s+", "");
						flag1 = true;
						break;
					}
				}
				
				if(flag1)
					continue;
				
				Matcher m = ptrn_per_ed.matcher(line);
				if (m.find())
				{
					result += m.group();
					line = line.replaceAll(ptrn_per_ed.pattern(), "").replaceAll("^\\s+", "");
					for (int i = 0; i < 2; ++i)
					{
						m = ptrn_var.matcher(line);
						if (m.find())
						{
							result += m.group();
							line = line.replaceAll(ptrn_var.pattern(), "").replaceAll("^\\s+", "");
						}
					}
					result += '\n';
					continue;
				}
				
				
				// TODO
			}
				
			result += comment + '\n';
		}
		
		return result;
	}

}
