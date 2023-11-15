package seg3102.hms.domain.patientRegistration.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import java.util.*

class NewAdmission(val admission: Admission, val date: Date): DomainEvent {
}