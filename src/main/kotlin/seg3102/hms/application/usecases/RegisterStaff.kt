package seg3102.hms.application.usecases

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import java.util.*

interface RegisterStaff {
    fun registerStaff(staffInfo: StaffCreateDTO): UUID?
}
