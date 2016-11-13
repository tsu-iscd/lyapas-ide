package autorep.views.window;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LSymbol {

	 private String Symbol;
    private String Name;
    private String HotKey;
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public LSymbol() {
    }

    public LSymbol(String Symbol, String Name, String HotKey) {
            super();
            this.Symbol = Symbol;
            this.Name = Name;
            this.HotKey = HotKey;
    }

    public void addPropertyChangeListener(String propertyName,
                    PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public String getSymbol() {
            return Symbol;
    }

    public String getHotKey() {
            return HotKey;
    }

    public String getName() {
            return Name;
    }


    public void setSynmbol(String Symbol) {
            propertyChangeSupport.firePropertyChange("Symbol", this.Symbol,
                            this.Symbol = Symbol);
    }

    public void setHotKey(String HotKey) {
            propertyChangeSupport.firePropertyChange("HotKey", this.HotKey,
                            this.HotKey = HotKey);
    }

    public void setName(String Name) {
            propertyChangeSupport.firePropertyChange("Name", this.Name,
                            this.Name = Name);
    }

  
    @Override
    public String toString() {
            return Symbol + " " + Name;
    }


}
