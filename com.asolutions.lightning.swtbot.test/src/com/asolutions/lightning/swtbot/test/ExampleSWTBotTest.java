package com.asolutions.lightning.swtbot.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ExampleSWTBotTest {
	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
	}

	@Test
	public void validateHelpMenuStartsEnabled() {
		assertTrue(bot.menu("Help").isEnabled());
	}

	@Test
	public void exampleViewPartIsShownByDefault() {
		SWTBotView activeView = bot.activeView();
		
		assertEquals("Example View", activeView.getTitle());
	}
}