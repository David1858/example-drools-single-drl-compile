package org.example;

import static org.junit.Assert.assertTrue;

import org.example.model.Claim;
import org.example.model.PolicyType;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleTest {
	private final Logger log = LoggerFactory.getLogger(getClass());

	KieServices kieServices = KieServices.Factory.get();
	KieContainer kContainer = kieServices.getKieClasspathContainer();
	KieBase kieBase = kContainer.getKieBase();

	@Test
	public void test() {
		KieSession session = kieBase.newKieSession();
		Claim claim = Claim.builder().policyType(PolicyType.GOLD).icdCode("A000").build();
		session.insert(claim);
		session.fireAllRules();
		assertTrue(claim.getIcdCodeCoveredByPolicyType());
	}
}