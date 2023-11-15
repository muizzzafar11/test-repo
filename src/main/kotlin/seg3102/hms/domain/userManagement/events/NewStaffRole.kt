package seg3102.hms.domain.userManagement.events

import seg3102.hms.domain.common.DomainEvent
import seg3102.hms.domain.userManagement.entities.StaffRole
import java.util.*

class NewStaffRole(val role: StaffRole, val date: Date):DomainEvent {

}