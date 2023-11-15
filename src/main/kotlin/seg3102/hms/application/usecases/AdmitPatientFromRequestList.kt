package seg3102.hms.application.usecases

import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

interface AdmitPatientFromRequestList {
    fun admitFromRequest(admissionRequest: AdmissionRequest, patientID: UUID): UUID?
}