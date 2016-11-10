package autorep.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class LyapasEditor extends TextEditor {

	private ColorManager colorManager;

	public LyapasEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
