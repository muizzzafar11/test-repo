package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole
import seg3102.hms.domain.userManagement.repositories.StaffRepository
import java.util.*

class StaffRepositoryStub: StaffRepository {
    override fun find(staffID: UUID): Staff {
        TODO("Not yet implemented")
    }

    override fun save(role: StaffRole): StaffRole {
        TODO("Not yet implemented")
    }

    override fun save(staff: Staff): Staff {
        TODO("Not yet implemented")
    }
}