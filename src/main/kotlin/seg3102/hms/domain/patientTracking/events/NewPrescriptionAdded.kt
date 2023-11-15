package seg3102.hms.domain.patientTracking.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.patientTracking.entities.Prescription
import java.util.*

class NewPrescriptionAdded(val prescription: Prescription, val date: Date): DomainEvent {
}