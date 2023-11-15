package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.usecases.DischargePatient
import seg3102.hms.domain.division.facade.DivisionFacade
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class DischargePatientImpl(private var patientRegistrationFacade: PatientRegistrationFacade,
                           private var userManagementFacade: UserManagementFacade,
                           private var divisionFacade: DivisionFacade,
                           private var logFacade: LogFacade):
        DischargePatient {
    override fun dischargePatient(patientID: UUID): UUID? {

        val patient = patientRegistrationFacade.getPatient(patientID);
        val employeeID = userManagementFacade.getCurrentStaff();

        if (patient != null) {
            patientRegistrationFacade.removePatientFromFile(patientID);

            divisionFacade.removeBed(patientID);

            divisionFacade.removeRoom(patientID);

            val logID = logFacade.createLog(employeeID, patientID);
        }

        // if patient or employee is not valid
        return null;

    }
}