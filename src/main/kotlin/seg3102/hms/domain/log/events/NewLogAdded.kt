package seg3102.hms.domain.log.events

import seg3102.hms.domain.common.DomainEvent
import java.util.*

class NewLogAdded(val staffID: UUID, val patientID: UUID, val date: Date):DomainEvent {

}