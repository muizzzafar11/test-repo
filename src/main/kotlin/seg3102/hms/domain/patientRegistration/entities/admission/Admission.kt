package seg3102.hms.domain.patientRegistration.entities.admission

import java.util.*

class Admission (val patientID: UUID,
                 val doctorEmployeeId: UUID,
                 val roomNumber: Int,
                 val bedNumber: Int,
                 val privateInsuranceNumber: String? = null,
                 val admissionRequest: AdmissionRequest? = null,
                 val divisionID: UUID) {

}