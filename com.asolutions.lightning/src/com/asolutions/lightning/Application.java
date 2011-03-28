package com.asolutions.lightning;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Application implements IApplication {
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		Integer returnCode;
		try {
			int workbenchReturnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			returnCode = workbenchReturnCode == PlatformUI.RETURN_RESTART ? IApplication.EXIT_RESTART
					: IApplication.EXIT_OK;
		} catch (Exception e) {
			returnCode = Integer.valueOf(1);
		} finally {
			display.dispose();
		}
		return returnCode;
	}

	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
