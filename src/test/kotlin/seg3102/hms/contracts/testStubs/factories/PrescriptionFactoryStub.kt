package seg3102.hms.contracts.testStubs.factories

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import seg3102.hms.domain.patientTracking.entities.Prescription
import seg3102.hms.domain.patientTracking.factories.PrescriptionFactory
import java.util.*

class PrescriptionFactoryStub: PrescriptionFactory {
    override fun createPrescription(prescription: PrescriptionCreateDTO, patientID: UUID): Prescription {
        TODO("Not yet implemented")
    }
}