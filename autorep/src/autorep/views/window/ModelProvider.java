package autorep.views.window;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
        INSTANCE;

        private List<LSymbol> LSymbols;

        private ModelProvider() {
        	LSymbols = new ArrayList<LSymbol>();
                // Image here some fancy database access to read the persons and to
                // put them into the model
        	LSymbols.add(new LSymbol("⇒", "The value transfer of the argument or element", "=>", "Unicode:  U+21d2\nExample: 12 ⇒ x, now x got “12” value ( x:=12 )\nDescription: assign value to the argument or element"));
        	LSymbols.add(new LSymbol("⇔", "Exchanging values", "<=>", "Unicode:  U+21d4\nExample: a ⇔ b, now a got value from b, and b got value from a ( a:= b, b:=a )\nDescription: change values"));
        	LSymbols.add(new LSymbol("¬", "Inversion", "-|","Unicode: U+00ac\nExample: if vector a:= 101, then vector ¬a:=010\nDescription: invert value"));
        	LSymbols.add(new LSymbol("∨", "Disjunction", "V", "Unicode: U+2228\nExample:  if vector a:= 100 and vector b:=011,then (a ∨ b):=111\nDescription: disjunction"));
        	LSymbols.add(new LSymbol("⊕", "Disjunction with the expression", "+0", "Unicode: U+2295\nExample: if vector a:= 1 and vector b:=0,then (a ⊕ b):=1\nDescription: disjunction  with the expression"));     	
        	LSymbols.add(new LSymbol("≪", "Left circular shift", "<2", "Unicode:U+226A\nExample: ≪ x(a,b)\nDescription: the part of boolean vector t with components, which have numbers on the interval (a,b), repeatedly on x bit ( left ) "));
            LSymbols.add(new LSymbol("≫", "Right circular shift", ">2", "Unicode: U+226B\nExample: ≫ x(a,b)\nDescription: the part of boolean vector t with components, which have numbers on the interval (a,b), repeatedly on x bit ( right ) "));
        	LSymbols.add(new LSymbol("∇", "Decrement", "V-", "Unicode:U+2207\nExample: ∇ a (a:= a-1)\nDescription: decrement"));
        	LSymbols.add(new LSymbol("∆", "Increment", "^-", "Unicode: U+2206\nExample:  ∆ a (a:= a+1)\nDescription: increment"));
        	LSymbols.add(new LSymbol("§", "Label", "$", "Unicode:U+a7\nExample: §F\nDescription: place named mark somewhere in program. You’ll return here, when make right jump operation."));
        	LSymbols.add(new LSymbol("↑", "Conditional jump", "|^", "Unicode:U+2191\nExample: ↑ (a = b)F\nDescription: jump to the label F, if a = b (≠ or ≥ or ≤ or > or <)"));
        	LSymbols.add(new LSymbol("→", "Unconditional jump", "->", "U+2192\nExample: → F\nDescription: jump to the label F without condition."));
        	LSymbols.add(new LSymbol("↪", "Jump by zero", "0", "Unicode:U+21AA\nExample: a↪ F\nDescription: jump to the label F, if a = 0"));
        	LSymbols.add(new LSymbol("↦", "Jump by not-zero", "1", "Unicode:U+21A6\nExample: a ↦ F\nDescription: jump to the label F, if a = 1"));
        	LSymbols.add(new LSymbol("⇕", "Transposition", "^V", "Unicode:  U+21d5\nExample: ⇕L\nDescription: transposition"));        	
        	LSymbols.add(new LSymbol("⇻", "Jump to par with return", "|>", "Unicode: U+21fb\nExample: ⇻F\nDescription: jump F with return"));       	
        	LSymbols.add(new LSymbol("⇑", "Insert", "|^|", "Unicode: U+21d1\nExample:  ⇑x V(a,b)\nDescription: the part of boolean vector V, which have numbers on the interval (a,b), insert before component with number x"));      	
        	LSymbols.add(new LSymbol("⇓", "Reduction", "|V|", "Unicode:U+21d3\nExample: ⇓x V(a,b)\nDescription: the part of boolean vector delete  from the vector"));       	
        	LSymbols.add(new LSymbol("≥", "Max element", ">=", "Unicode:U+2265\nDescription: grade or equal"));
        	LSymbols.add(new LSymbol("≤", "Min element", "<=", "Unicode: U+2264\nDescription: low or equal"));
        	LSymbols.add(new LSymbol("≠", "Not equal", "!=", "Unicode: U+2260\nDescription: not equal"));
        	LSymbols.add(new LSymbol("⁻", "Inversion", "~", "Unicode: U+227b\nExample: ⁻a ( a:= 11...1 )\nDescription: make max value"));
        	LSymbols.add(new LSymbol("⇞", "Return to the point", "|=^", "Unicode: U+21A2\nExample: ⇞F\nDescription: return to the point F"));
        }

        public List<LSymbol> getLSymbols() {
                return LSymbols;
        }

}
