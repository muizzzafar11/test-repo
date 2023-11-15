package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.repositories.AdmissionRepository
import java.util.*

class AdmissionRepositoryStub: AdmissionRepository {
    override fun getAdmissionDoctorUUID(): UUID {
        TODO("Not yet implemented")
    }

    override fun find(patientId: UUID): Admission {
        TODO("Not yet implemented")
    }

    override fun save(admission: Admission): Admission {
        TODO("Not yet implemented")
    }

    override fun saveAdmissionRequest(admissionRequest: AdmissionRequest): AdmissionRequest {
        TODO("Not yet implemented")
    }
}