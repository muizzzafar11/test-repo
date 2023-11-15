package seg3102.hms.domain.log.repositories

import seg3102.hms.domain.log.entities.Log

interface LogRepository {
    fun save(log: Log): Log
}