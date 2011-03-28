package com.asolutions.lightning;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

public class HelpCustomizationTest {
	private static final String HELP_PLUGIN = "org.eclipse.help.base/";
	private static final String HELP_HOME = "help_home";
	private static final String TOPIC_CSS = "topic_css";
	private Map<String, String> properties;

	@Before
	public void loadProperties() throws IOException {
		Bundle bundle = Platform.getBundle("com.asolutions.lightning");
		URL resource = bundle.getResource("plugin_customization.ini");
		InputStream inputStream = resource.openStream();
		List<?> contents = IOUtils.readLines(inputStream);
		IOUtils.closeQuietly(inputStream);

		properties = new HashMap<String, String>();
		for (Object lineObject : contents) {
			String line = (String) lineObject;
			String[] split = line.split("=");
			properties.put(split[0], split[1]);
		}
	}

	@Test
	public void pluginCustomizationPointsToAnExistingHelpPage() throws IOException {
		assertResourceExists(HELP_HOME);
	}

	@Test
	public void allHelpTopicPagesHaveCorrectCss() throws IOException {
		assertResourceExists(TOPIC_CSS);
	}

	private void assertResourceExists(String property) {
		String value = properties.get(HELP_PLUGIN + property);
		assertTrue(value.startsWith("/"));
		String helpPageBundle = value.split("/")[1]; // value of the form /bundleid/path/to/resource
		String resourcePath = value.substring(helpPageBundle.length() + 1);
		Bundle bundle = Platform.getBundle(helpPageBundle);
		URL helpPage = FileLocator.find(bundle, new Path(resourcePath), null);
		assertNotNull("Could not find " + resourcePath + " in " + helpPageBundle, helpPage);
	}
}
