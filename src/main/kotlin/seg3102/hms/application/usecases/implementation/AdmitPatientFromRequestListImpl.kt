package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.application.dtos.queries.AdmissionRequestCreateDTO
import seg3102.hms.application.usecases.AdmitPatientFromRequestList
import seg3102.hms.domain.division.facade.DivisionFacade
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class AdmitPatientFromRequestListImpl(private var patientRegistrationFacade: PatientRegistrationFacade, private var userManagementFacade: UserManagementFacade, private var divisionFacade: DivisionFacade): AdmitPatientFromRequestList {
    override fun admitFromRequest(admissionRequest: AdmissionRequest, patientID: UUID): UUID? {

        val staffID = userManagementFacade.getCurrentStaff();

        val divisionID = userManagementFacade.getStaffDivision(staffID);

        val chargeNurseID = divisionFacade.getChargeNurseID(divisionID);

        val inRequest = divisionFacade.patientInRequestList(patientID, chargeNurseID);

        if (inRequest && chargeNurseID == staffID) {
            val admission:AdmissionCreateDTO = patientRegistrationFacade.admissionFromRequest(admissionRequest);

            divisionFacade.removePatientFromRequestList(admission, patientID)

            patientRegistrationFacade.admitPatient(admission, patientID);
        }
        return null;
    }
}