package seg3102.hms.domain.log.factories

import seg3102.hms.domain.log.entities.Log
import java.util.UUID

interface LogFactory {
    fun createLog(staffID: UUID, patientID: UUID): Log
}