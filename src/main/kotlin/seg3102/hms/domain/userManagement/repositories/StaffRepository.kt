package seg3102.hms.domain.userManagement.repositories

import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole
import java.util.*

interface StaffRepository {
    fun find(staffID: UUID): Staff
    fun save(staff: Staff): Staff
    fun save(role: StaffRole): StaffRole
}