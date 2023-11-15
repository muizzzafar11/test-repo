package seg3102.hms.domain.patientTracking.entities

import java.util.*

class Prescription (val drugNumber: String,
                    val drugName: String,
                    val unitsPerDay: Int,
                    val administrationPerDay: Int,
                    val methodOfAdministration: String,
                    val startDate: Date,
                    val finishDate: Date, ) {

    val administrationSchedule: MutableList<AdministrationSchedule> = ArrayList()
}