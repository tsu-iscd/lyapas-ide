package autorep.antlr;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import autorep.Activator;

public class FinalLyapasParser extends lyapasParser {

	public FinalLyapasParser(TokenStream input) {
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException e) {
		ILog log = Activator.getDefault().getLog();
		IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID, msg);
		log.log(status);
	}
}
