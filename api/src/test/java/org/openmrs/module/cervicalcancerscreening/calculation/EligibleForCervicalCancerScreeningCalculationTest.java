/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.cervicalcancerscreening.calculation;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationService;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.cervicalcancerscreening.metadata.ModuleMetadata;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Tests for {@link EligibleForCervicalCancerScreeningCalculation}
 */
public class EligibleForCervicalCancerScreeningCalculationTest extends BaseModuleContextSensitiveTest {

	@Autowired
	private ModuleMetadata moduleMetadata;

//	@Autowired
//	private CommonMetadata commonMetadata;
//	@Autowired
//	private HivMetadata hivMetadata;
	
	@Before
	public void setup() throws Exception {
		executeDataSet("dataset/test-concepts.xml");
		moduleMetadata.install();
//		commonMetadata.install();
//		hivMetadata.install();
	}

	@Test
	public void evaluate() {
	//	Patient patient1 = TestUtils.getPatient(1);
		List<Integer> ptIds = Arrays.asList(2, 6, 7);
		CalculationResultMap resultMap = Context.getService(PatientCalculationService.class).evaluate(ptIds, new EligibleForCervicalCancerScreeningCalculation());
		Assert.assertTrue((Boolean) resultMap.get(2).getValue());
		Assert.assertTrue((Boolean) resultMap.get(6).getValue());
		Assert.assertTrue((Boolean) resultMap.get(7).getValue());
	}
}