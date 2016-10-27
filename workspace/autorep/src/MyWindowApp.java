
import javax.swing.JFrame;

public class MyWindowApp extends JFrame { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MyWindowApp(){
    super("My First Window"); 
    setBounds(100, 100, 200, 200); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }

  public static void main(String[] args) { 
	  
    MyWindowApp myEdit = new MyWindowApp(); 
    myEdit.setVisible(true); 
    MyWindowApp myLog = new MyWindowApp(); 
    myLog.setVisible(true); 
    MyWindowApp winda = new MyWindowApp(); 
    winda.setVisible(true); 
  }
}