package seg3102.hms.domain.userManagement.factories

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole

interface StaffFactory {
    fun createStaff(staffInfo: StaffCreateDTO, staffRole: StaffRole): Staff
    fun createRole(staffInfo: StaffCreateDTO): StaffRole
}