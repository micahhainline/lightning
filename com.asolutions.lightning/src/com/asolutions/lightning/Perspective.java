package com.asolutions.lightning;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {
	public void createInitialLayout(IPageLayout layout) {
		layout.addStandaloneView(ExampleViewPart.ID, false, IPageLayout.LEFT,
				.3F, IPageLayout.ID_EDITOR_AREA);
		layout.setEditorAreaVisible(false);
	}
}