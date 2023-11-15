package seg3102.hms.contracts.testStubs.factories

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.factories.AdmissionFactory
import java.util.*

class AdmissionFactoryStub: AdmissionFactory {
    override fun createAdmission(admissionCreateDTO: AdmissionCreateDTO, patientID: UUID): Admission {
        TODO("Not yet implemented")
    }

    override fun createAdmissionFromRequest(admissionRequest: AdmissionRequest): AdmissionCreateDTO {
        TODO("Not yet implemented")
    }

    override fun createAdmissionRequest(patientID: UUID, divisionID: UUID): AdmissionRequest {
        TODO("Not yet implemented")
    }
}