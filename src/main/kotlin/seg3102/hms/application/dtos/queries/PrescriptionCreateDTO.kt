package seg3102.hms.application.dtos.queries

import java.util.Date

data class PrescriptionCreateDTO(
    val drugNumber: String,
    val drugName: String,
    val unitsPerDay: Int,
    val administrationsPerDay: Int,
    val administrationSchedule: List<AdministrationTimeCreateDTO>,  // List of times and units for each administration
    val methodOfAdministration: String,
    val startDate: Date,
    val finishDate: Date
)
