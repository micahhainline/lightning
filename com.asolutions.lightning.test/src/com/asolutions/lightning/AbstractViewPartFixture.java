package com.asolutions.lightning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

public class AbstractViewPartFixture {

	protected void assertViewIsPresent(Class<?> viewClass, String id, String viewName) throws Exception {
		boolean foundIt = false;

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = extensionRegistry.getConfigurationElementsFor("org.eclipse.ui.views");
		for (IConfigurationElement element : elements) {
			String emptyViewClass = element.getAttribute("class");
			if (viewClass.getName().equals(emptyViewClass)) {
				String bundleId = element.getContributor().getName();
				Bundle bundle = Platform.getBundle(bundleId);
				Class<?> clazz = bundle.loadClass(emptyViewClass);
				Object view = clazz.newInstance();
				assertTrue(view instanceof ViewPart);
				assertTrue(viewClass.isAssignableFrom(view.getClass()));
				assertEquals(id, element.getAttribute("id"));
				assertEquals(viewName, element.getAttribute("name"));
				foundIt = true;
				break;
			}
		}

		assertTrue(foundIt);
	}

}
