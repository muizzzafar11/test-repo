package seg3102.hms.domain.patientRegistration.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

class NewAdmissionRequest(val admissionRequest: AdmissionRequest, val date: Date): DomainEvent {
}