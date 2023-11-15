package seg3102.hms.contracts.testStubs.factories

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole
import seg3102.hms.domain.userManagement.factories.StaffFactory
import java.util.*

class StaffFactoryStub: StaffFactory {
    private val staff: MutableMap<UUID, Staff> = HashMap()
    override fun createRole(staffInfo: StaffCreateDTO): StaffRole {
        TODO("Not yet implemented")
    }

    override fun createStaff(staffInfo: StaffCreateDTO, staffRole: StaffRole): Staff {
        return Staff(staffInfo.employeeNumber,
                staffInfo.loginPassword,
                staffInfo.firstName,
                staffInfo.lastName,
                staffInfo.emailAddress,
                staffRole,
                staffInfo.divisionID)
    }
}