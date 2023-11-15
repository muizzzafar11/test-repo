package seg3102.hms.application.usecases

import java.util.*

interface DischargePatient {
    fun dischargePatient(patientID: UUID): UUID?
}
