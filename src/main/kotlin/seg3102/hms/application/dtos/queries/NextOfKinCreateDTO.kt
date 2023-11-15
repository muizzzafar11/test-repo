package seg3102.hms.application.dtos.queries

data class NextOfKinCreateDTO(
        val fullName: String,
        val relationshipToPatient: String,
        val address: String,
        val telephoneNumber: String
)