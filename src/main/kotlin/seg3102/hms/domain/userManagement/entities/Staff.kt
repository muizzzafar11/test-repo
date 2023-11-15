package seg3102.hms.domain.userManagement.entities

import java.util.UUID

class Staff (val employeeNumber: UUID,
             val loginPassword: String,
             val firstName: String,
             val lastName: String,
             val emailAddress: String,
             val role: StaffRole,
             val divisionID: UUID) {
}