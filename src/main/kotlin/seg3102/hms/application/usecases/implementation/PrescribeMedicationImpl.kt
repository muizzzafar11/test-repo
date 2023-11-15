package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import seg3102.hms.application.usecases.PrescribeMedication
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.patientTracking.facade.PatientTrackingFacade
import seg3102.hms.domain.userManagement.entities.StaffRole
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class PrescribeMedicationImpl(private var patientTrackingFacade: PatientTrackingFacade,
                              private var userManagementFacade: UserManagementFacade, private var logFacade: LogFacade):
        PrescribeMedication {
    override fun prescribeMedication(prescription: PrescriptionCreateDTO, patientID: UUID): UUID? {

        val employeeID = userManagementFacade.getCurrentStaff();

        val doctor = userManagementFacade.getStaffRole(employeeID);

        val prescriptionValid = patientTrackingFacade.checkValidPrescription(prescription, patientID);

        if (doctor == StaffRole.DOCTOR && prescriptionValid) {
            val prescribe = patientTrackingFacade.prescribeMedication(prescription, patientID);
            val logID = logFacade.createLog(employeeID, patientID);
        }
        return null;
    }
}