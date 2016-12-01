package lyapaside;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class PerspectiveFactory1 implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.67f, layout.getEditorArea());

		bottom.addView("org.eclipse.pde.runtime.LogView");

		ILog log = Activator.getDefault().getLog();
		IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID,
				"Lyapas Perspective is chosen");
		log.log(status);
	}

}
