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
        }

        public List<LSymbol> getLSymbols() {
                return LSymbols;
        }

}
