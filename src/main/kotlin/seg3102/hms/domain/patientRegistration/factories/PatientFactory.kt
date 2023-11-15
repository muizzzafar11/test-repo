package seg3102.hms.domain.patientRegistration.factories

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.domain.patientRegistration.entities.patient.Patient

interface PatientFactory {
    fun createPatient(patientInfo: PatientCreateDTO): Patient
}