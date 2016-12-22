package lyapaside;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AllOurPatterns {
	
	static private String[] str_simple = {
			"^[a-zA-Z]\\w*[ ]*[(][\\w/, ]*[)]",
			"^[*][\\w ]+[(][\\w/, ]*[)]",
			"^⇔[ ]*[(][^)][)]",										
			"^↑[ ]*[(][^)][)][ ]*\\d+",																						
			"^[→↣][ ]*\\d+",
			"^@[ ]*[+][ ]*[LFK][ ]*\\d+[ ]*[(][^)]*[)]",
			"^@[ ]*[-%O][ ]*[LFK][ ]*\\d+",
			"^@[ ]*['][^']*['][ ]*[>][ ]*[LFK][ ]*\\d+",
			"^@[ ]*[#][ ]*[LFK][ ]*\\d+[ ]*[LFK][ ]*\\d+[ ]*[(][^)]*[)]",
			"^↢",
			"^[/][ ]*[LFK][\\d ]+[<>][ ]*C",
			"^[/][ ]*'[^']*'[ ]*>[ ]*C",
			"^[*]{2}",
			"^§[ ]*\\d+"
	};
	
	static private String str_var = "^([a-z]|[LFK]\\d+[ ]*([a-z]|[.][ ]*\\d+)|@|Q[ ]*\\d+)";
	static private String str_bin = "^[+-:/;&*∨><⊕]";
	static private String str_un_sle = "^[O∆∇⁻]";
	static private String str_un_spr = "^[¬%!]";
	static private String str_usl_per = "^[↪↦][ ]*\\d+";
	static private String str_per_ed = "^↑[ ]*X[ ]*\\d+";
	static private String str_elm_lfk = "^@[ ]*[<>][ ]*[LFK][ ]*\\d+";
	
	static public List<Pattern> ptrn_simple()
	{
		List<Pattern> result = new ArrayList<Pattern>();
		for(String str: str_simple)
			result.add(Pattern.compile(str));
		return result;
	}
	
	static public Pattern ptrn_var() { return Pattern.compile(str_var); }
	static public Pattern ptrn_bin() { return Pattern.compile(str_bin); }
	static public Pattern ptrn_un_sle() { return Pattern.compile(str_un_sle); }
	static public Pattern ptrn_un_spr() { return Pattern.compile(str_un_spr); }
	static public Pattern ptrn_usl_per() { return Pattern.compile(str_usl_per); }
	static public Pattern ptrn_per_ed() { return Pattern.compile(str_per_ed); }
	static public Pattern ptrn_elm_lfk() { return Pattern.compile(str_elm_lfk); }
}
