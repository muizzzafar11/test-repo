package seg3102.hms.domain.patientTracking.repositories

import seg3102.hms.domain.patientTracking.entities.Prescription

interface PrescriptionRepository {
    fun save(prescription: Prescription): Prescription

}