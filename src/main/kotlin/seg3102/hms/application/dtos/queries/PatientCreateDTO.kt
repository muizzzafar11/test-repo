package seg3102.hms.application.dtos.queries

import java.util.*

data class PatientCreateDTO(
    val governmentInsuranceNumber: String, // validate that it's unique
    val firstName: String,
    val lastName: String,
    val address: String,
    val telephoneNumber: String,
    val dateOfBirth: Date,
    val gender: String,
    val maritalStatus: String,
    val externalDoctor: String, // identifier of the external doctor
    val nextOfKin: NextOfKinCreateDTO,
        val localDoctor: UUID
)
