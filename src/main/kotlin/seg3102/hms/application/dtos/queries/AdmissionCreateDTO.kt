package seg3102.hms.application.dtos.queries

import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.UUID

data class AdmissionCreateDTO(
    val localDoctor: String,
    val roomNumber: Int,
    val bedNumber: Int,
    val divisionID: UUID,
    val privateInsuranceNumber: String? = null,
    val admissionRequest: AdmissionRequest? = null
)