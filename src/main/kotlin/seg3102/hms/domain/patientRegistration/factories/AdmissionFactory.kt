package seg3102.hms.domain.patientRegistration.factories

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

interface AdmissionFactory {
    fun createAdmission(admissionCreateDTO: AdmissionCreateDTO, patientID: UUID): Admission

    fun createAdmissionRequest(patientID: UUID, divisionID: UUID): AdmissionRequest

    fun createAdmissionFromRequest(admissionRequest: AdmissionRequest): AdmissionCreateDTO
}