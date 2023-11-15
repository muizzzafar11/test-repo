package seg3102.hms.application.dtos.queries

import java.util.UUID

data class StaffCreateDTO(
        val employeeNumber: UUID,
        val loginPassword: String,
        val firstName: String,
        val lastName: String,
        val emailAddress: String,
        val staffRole: String,
        val divisionID: UUID
)