package com.asolutions.lightning;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class ExampleViewPart extends ViewPart {
	public static final String ID = "com.asolutions.lightning.view";

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.swtDefaults().applyTo(parent);
		Label label = new Label(parent, SWT.NONE);
		label.setText("This view can be found at "
				+ getClass().getCanonicalName());
		GridDataFactory.fillDefaults().applyTo(label);
	}

	@Override
	public void setFocus() {
	}
}
