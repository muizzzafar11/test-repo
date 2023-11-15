package seg3102.hms.contracts.testStubs.factories

import seg3102.hms.domain.log.entities.Log
import seg3102.hms.domain.log.factories.LogFactory
import seg3102.hms.domain.userManagement.entities.Staff
import java.util.*

class LogFactoryStub: LogFactory {

    private val logsList = mutableListOf<Log>()
    override fun createLog(staffID: UUID, patientID: UUID): Log {
        val logObject = Log(staffID, patientID, Date())
        logsList.add(logObject)
        return logObject
    }
}