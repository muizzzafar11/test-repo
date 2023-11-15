package seg3102.hms.domain.patientRegistration.facade

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.application.dtos.queries.AdmissionRequestCreateDTO
import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import java.util.*

interface PatientRegistrationFacade {
    fun getPatient(patientID: UUID): Patient?
    fun updatePatientFile(patientID: UUID, patientInfo: PatientCreateDTO)
    fun removePatientFromFile(patientID: UUID)
    fun checkValidPatientInfo(patientInfo: PatientCreateDTO): Boolean
    fun registerPatient(patientInfo: PatientCreateDTO): UUID
    fun admissionFromRequest(admissionRequest: AdmissionRequest): AdmissionCreateDTO
    fun admitPatient(admission: AdmissionCreateDTO, patientID: UUID): Admission
    fun createAdmissionRequest(patientID: UUID, divisionID: UUID): AdmissionRequest
    fun getPatientLocalDoctor(patientID: UUID): UUID
}