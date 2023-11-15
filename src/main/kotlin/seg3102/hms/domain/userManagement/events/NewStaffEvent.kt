package seg3102.hms.domain.userManagement.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.userManagement.entities.Staff
import java.util.*

class NewStaffEvent(val staff: Staff, val date: Date):DomainEvent {

}