package seg3102.hms.domain.patientRegistration.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import java.util.*

class PatientUpdated(val patientID: UUID, val date: Date): DomainEvent {

}