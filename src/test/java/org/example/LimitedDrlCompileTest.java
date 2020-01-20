package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.internal.io.ResourceFactory;

/**
 * Used to compile a limited number of drl when project is taking too long to
 * compile all rules.
 * 
 */
public class LimitedDrlCompileTest {

	// Add the drl file(s) to compile
	private String[] drlFiles = new String[] { "src/main/resources/org/example/rules/rules.drl" };

	@Test
	public void testProgrammaticallyCreatingForCompile() throws Exception {
		final KieServices kServices = KieServices.Factory.get();
		final KieFileSystem kFileSystem = kServices.newKieFileSystem();

		for (String drlFile : drlFiles)
			kFileSystem.write(ResourceFactory.newFileResource(drlFile));

		final KieBuilder kBuilder = kServices.newKieBuilder(kFileSystem);
		kBuilder.buildAll();

		assertEquals(0, kBuilder.getResults().getMessages(Message.Level.ERROR).size());
	}
}
