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
        	LSymbols.add(new LSymbol("⇒", "The value transfer of the argument or element", "=>"));
        	LSymbols.add(new LSymbol("⇔", "Exchanging values", "<=>"));
        	LSymbols.add(new LSymbol("¬", "Inversion", "-|"));
        	LSymbols.add(new LSymbol("∨", "Disjunction", "V"));
        	LSymbols.add(new LSymbol("⊕", "Disjunction with the expression", "+0"));     	
        	LSymbols.add(new LSymbol("≪", "Left circular shift", "<<"));
        	LSymbols.add(new LSymbol("≫", "Right circular shift", ">>"));
        	LSymbols.add(new LSymbol("∇", "Decrement", "\\-/"));
        	LSymbols.add(new LSymbol("∆", "Increment", "/-\\"));
        	LSymbols.add(new LSymbol("§", "Label", "$$"));
        	LSymbols.add(new LSymbol("↑", "Conditional jump", "|^"));
        	LSymbols.add(new LSymbol("→", "Unconditional jump", "->"));
        	LSymbols.add(new LSymbol("↪", "Jump by zero", "0->"));
        	LSymbols.add(new LSymbol("↦", "Jump by not-zero", "1->"));
        	LSymbols.add(new LSymbol("↢", "Return to the point", "<-<"));
        	LSymbols.add(new LSymbol("⇻", "Jump to par with return", "-||>"));       	
        	LSymbols.add(new LSymbol("⇑", "Insert", "|/\\|"));      	
        	LSymbols.add(new LSymbol("⇓", "Reduction", "|\\/|"));       	
        	LSymbols.add(new LSymbol("≥", "Max element", ">="));
        	LSymbols.add(new LSymbol("≤", "Min element", "<="));
        	LSymbols.add(new LSymbol("≠", "Not equal", "!="));
        	LSymbols.add(new LSymbol("⁻", "Inversion", "~"));
        	LSymbols.add(new LSymbol("⇞", "Unknown", "|=^"));
        	LSymbols.add(new LSymbol("⇅", "Unknown", "^\\/"));
        }

        public List<LSymbol> getLSymbols() {
                return LSymbols;
        }

}
