package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import seg3102.hms.domain.patientRegistration.repositories.PatientRepository
import java.util.*

class PatientRepositoryStub: PatientRepository {
    private val patients: MutableMap<UUID, Patient> = HashMap()
    override fun find(patientID: UUID): Patient {
        TODO("Not yet implemented")
    }

    override fun removePatientFromFile(patientID: UUID) {
        TODO("Not yet implemented")
    }

    override fun save(patient: Patient): Patient {
        patients[patient.patientID] = patient
        return patient
    }
}