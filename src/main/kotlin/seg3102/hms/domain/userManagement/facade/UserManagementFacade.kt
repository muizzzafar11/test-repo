package seg3102.hms.domain.userManagement.facade

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import seg3102.hms.domain.userManagement.entities.StaffRole
import java.util.*

interface UserManagementFacade {
    fun getStaff(staffInfo: StaffCreateDTO): UUID
    fun checkValidStaffInfo(staffInfo: StaffCreateDTO, employeeID: UUID?): Boolean
    fun addStaffRole(staffInfo: StaffCreateDTO): StaffRole
    fun registerStaff(staffInfo: StaffCreateDTO, staffRole: StaffRole): UUID
    fun getCurrentStaff(): UUID
    fun getStaffRole(staffID: UUID): StaffRole
    fun getStaffDivision(staffID: UUID): UUID
}