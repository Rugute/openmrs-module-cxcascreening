/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.cervicalcancerscreening.reporting.library.patientsVisits;

import org.openmrs.module.kenyacore.report.ReportUtils;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openmrs.module.kenyaemr.reporting.EmrReportingUtils.cohortIndicator;


/**
 * Library of HIV related indicator definitions.
 */
@Component
public class PatientVisitsIndicatorLibrary {
    @Autowired
    private PatientVisitsCohortLibrary cohortLibrary;

    /**
     * Number of patients who visited and are enrolled in HIV
     * @return the indicator
     */
    public CohortIndicator patientsEnrolledInHiv() {
        return cohortIndicator("Patients enrolled in HIV", ReportUtils.map(cohortLibrary.patientsEnrolledInHiv(), ""));
    }

}
