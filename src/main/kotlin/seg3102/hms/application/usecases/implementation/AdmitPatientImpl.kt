package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.application.usecases.AdmitPatient
import seg3102.hms.domain.division.facade.DivisionFacade
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class AdmitPatientImpl (private var userManagementFacade: UserManagementFacade, private var patientRegistrationFacade: PatientRegistrationFacade, private var divisionFacade: DivisionFacade, private var logFacade: LogFacade): AdmitPatient {
    override fun admitPatient(admission: AdmissionCreateDTO, patientID: UUID): UUID? {
        val staffID = userManagementFacade.getCurrentStaff();

        val chargeNurseID = divisionFacade.getChargeNurseID(admission.divisionID);

        val admissionValid = divisionFacade.getValidAdmission(admission);

        if (chargeNurseID == staffID && admissionValid) {

            divisionFacade.updateAvailableRooms(admission);
            divisionFacade.updateAvailableBeds(admission);

            patientRegistrationFacade.admitPatient(admission, patientID);

            val logID = logFacade.createLog(staffID, patientID);
        }

        // not a charge nurse or invalid admission
        return null;
    }
}