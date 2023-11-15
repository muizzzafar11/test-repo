package seg3102.hms.domain.patientRegistration.repositories

import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

interface AdmissionRepository {
    fun save(admission: Admission): Admission
    fun saveAdmissionRequest(admissionRequest: AdmissionRequest): AdmissionRequest
    fun getAdmissionDoctorUUID(): UUID
    fun find(patientId: UUID): Admission
}