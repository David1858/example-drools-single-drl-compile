package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Claim {
	private PolicyType policyType;
	private String icdCode;
	private Boolean icdCodeCoveredByPolicyType;
	private boolean icdCodeUnknown;
}
