package seg3102.hms.domain.patientTracking.factories

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import seg3102.hms.domain.patientTracking.entities.Prescription
import java.util.*

interface PrescriptionFactory {
    fun createPrescription(prescription: PrescriptionCreateDTO, patientID: UUID): Prescription
}