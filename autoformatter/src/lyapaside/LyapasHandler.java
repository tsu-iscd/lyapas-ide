package lyapaside;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.*;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.text.IDocument;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class LyapasHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public LyapasHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IEditorPart part = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (!(part instanceof AbstractTextEditor) || !part.getTitle().endsWith(".lyapas")) return null;
		
		ITextEditor editor = (ITextEditor)part;
		IDocumentProvider dp = editor.getDocumentProvider();
		IDocument doc = dp.getDocument(editor.getEditorInput());
		
		int offset = 0;
		int length = doc.getLength();
		String text;
		String message;
		try {
			text = doc.get(offset, length);
			message = Autoformatter.Format(text);
			doc.set(message);
		} catch(Exception e){
			return null;
		}

		ILog log = Activator.getDefault().getLog();
		IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID, message);
		log.log(status);
		return null;
	}
}
