package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.application.usecases.RegisterPatient
import seg3102.hms.domain.log.entities.Log
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class RegisterPatientImpl(private var userManagementFacade: UserManagementFacade,
                          private var patientRegistrationFacade: PatientRegistrationFacade,
                          private var logFacade: LogFacade):
        RegisterPatient {
    override fun registerPatient(patientInfo: PatientCreateDTO): UUID? {
        val employeeID = userManagementFacade.getCurrentStaff();

        val patientValid = patientRegistrationFacade.checkValidPatientInfo(patientInfo);

        if (patientValid) {
            val patientID = patientRegistrationFacade.registerPatient(patientInfo);

            val logID = logFacade.createLog(employeeID, patientID);
        }

        return null;
    }
}