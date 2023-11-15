package seg3102.hms.domain.patientRegistration.repositories

import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import java.util.*

interface PatientRepository {
    fun save(patient: Patient): Patient
    fun find(patientID: UUID): Patient
    fun removePatientFromFile(patientID: UUID)

}