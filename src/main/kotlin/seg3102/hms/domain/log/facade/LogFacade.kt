package seg3102.hms.domain.log.facade

import seg3102.hms.domain.log.entities.Log
import java.util.UUID

interface LogFacade {
    fun createLog(staffID: UUID, patientID: UUID): Log

}