package seg3102.hms.application.usecases

import seg3102.hms.application.dtos.queries.AdmissionRequestCreateDTO
import java.util.*
interface RequestPatientAdmission {
    fun requestAdmission(patientID: UUID, divisionID: UUID): UUID?
}