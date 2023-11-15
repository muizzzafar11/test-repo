package seg3102.hms.application.usecases

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import java.util.*

interface RegisterPatient {
    fun registerPatient(patientInfo: PatientCreateDTO): UUID?
}
