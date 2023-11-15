package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.application.usecases.UpdatePatientFile
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class UpdatePatientFileImpl(private var patientRegistrationFacade: PatientRegistrationFacade, private var userManagementFacade: UserManagementFacade, private var logFacade: LogFacade): UpdatePatientFile {
    override fun updatePatientFile(patientID: UUID, patientInfo: PatientCreateDTO): UUID? {

        val patient = patientRegistrationFacade.getPatient(patientID);
        val staffID = userManagementFacade.getCurrentStaff();

        if (patient != null) {
            patientRegistrationFacade.updatePatientFile(patientID, patientInfo);

            val logID = logFacade.createLog(staffID, patientID);
        }

        // patient doesn't exist
        return null;
    }
}