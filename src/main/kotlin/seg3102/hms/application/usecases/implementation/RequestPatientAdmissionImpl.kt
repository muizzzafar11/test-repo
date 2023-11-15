package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.AdmissionRequestCreateDTO
import seg3102.hms.application.usecases.RequestPatientAdmission
import seg3102.hms.domain.division.facade.DivisionFacade
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class RequestPatientAdmissionImpl (private var patientRegistrationFacade: PatientRegistrationFacade, private var userManagementFacade: UserManagementFacade, private var divisionFacade: DivisionFacade, private var logFacade: LogFacade): RequestPatientAdmission {
    override fun requestAdmission(patientID: UUID, divisionID: UUID): UUID? {

        val patient = patientRegistrationFacade.getPatient(patientID);

        val staffID = userManagementFacade.getCurrentStaff();

        val chargeNurseID = divisionFacade.getChargeNurseID(divisionID);

        if (chargeNurseID == staffID && patient != null) {
            val admissionRequest = patientRegistrationFacade.createAdmissionRequest(patientID, divisionID);

            divisionFacade.addPatientToRequestList(patientID, admissionRequest, chargeNurseID);

            val logID = logFacade.createLog(staffID, patientID);
        }

        return null;
    }
}