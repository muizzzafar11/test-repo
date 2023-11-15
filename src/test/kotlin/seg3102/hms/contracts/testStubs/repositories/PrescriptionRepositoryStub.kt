package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.patientTracking.entities.Prescription
import seg3102.hms.domain.patientTracking.repositories.PrescriptionRepository

class PrescriptionRepositoryStub: PrescriptionRepository {
    override fun save(prescription: Prescription): Prescription {
        TODO()
    }
}