package seg3102.hms.application.dtos.queries

data class AdministrationTimeCreateDTO(
    val timeOfDay: String, /// can be a string for a general time of the day or converted to Date format if specific time
    val unitsAdministered: Int
)
