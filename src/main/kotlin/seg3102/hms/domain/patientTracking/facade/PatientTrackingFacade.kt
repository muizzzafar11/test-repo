package seg3102.hms.domain.patientTracking.facade

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import seg3102.hms.domain.patientTracking.entities.Prescription
import java.util.*

interface PatientTrackingFacade {
    fun checkValidPrescription(prescription: PrescriptionCreateDTO, patientID: UUID): Boolean
    fun prescribeMedication(prescription: PrescriptionCreateDTO, patientID: UUID): Prescription
}