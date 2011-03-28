package com.asolutions.lightning;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction contentsHelpAction;
	private IWorkbenchAction dynamicHelpAction;
	private IWorkbenchAction searchHelpAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(final IWorkbenchWindow window) {
		contentsHelpAction = ActionFactory.HELP_CONTENTS.create(window);
		register(contentsHelpAction);

		dynamicHelpAction = ActionFactory.DYNAMIC_HELP.create(window);
		register(dynamicHelpAction);

		searchHelpAction = ActionFactory.HELP_SEARCH.create(window);
		register(searchHelpAction);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
	}

	protected void fillMenuBar(IMenuManager menuBar) {
	}
}
