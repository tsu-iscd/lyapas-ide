package autorep.editor;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;

public class LyapasEditor extends TextEditor {

public static final String ID = "autorep.editor.LyapasEditor";
	
	public LyapasEditor() {
		super();
		setSourceViewerConfiguration(new TaskSourceViewerConfiguration());
	}
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {

	    super.init(site, input);
//	    System.out.print(input.getName());
//	    throw new RuntimeException(input.getName());

	      // TODO log the IFile
	}

}
