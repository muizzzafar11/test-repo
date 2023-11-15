package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.log.entities.Log
import seg3102.hms.domain.log.repositories.LogRepository

class LogRepositoryStub: LogRepository {
    override fun save(log: Log): Log {
        TODO("Not yet implemented")
    }
}