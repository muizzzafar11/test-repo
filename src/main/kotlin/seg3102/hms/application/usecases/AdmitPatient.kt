package seg3102.hms.application.usecases

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import java.util.*

interface AdmitPatient {
    fun admitPatient(admission: AdmissionCreateDTO, patientID: UUID): UUID?
}