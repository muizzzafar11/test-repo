package seg3102.hms.application.usecases

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import java.util.*

interface PrescribeMedication {
    fun prescribeMedication(prescription: PrescriptionCreateDTO, patientID: UUID): UUID?
}
