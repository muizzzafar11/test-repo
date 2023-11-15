package seg3102.hms.application.dtos.queries

data class AdmissionRequestCreateDTO(
        val rationaleForRequest: String,
        val priorityAssessment: Int,
        val localDoctor: String
)
