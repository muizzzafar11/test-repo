package seg3102.hms.domain.log.facade.implementation

import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.domain.log.entities.Log
import seg3102.hms.domain.log.events.NewLogAdded
import seg3102.hms.domain.log.facade.LogFacade
import seg3102.hms.domain.log.factories.LogFactory
import seg3102.hms.domain.log.repositories.LogRepository
import java.util.*

class LogFacadeImpl(private var logFactory: LogFactory,
                    private var logRepository: LogRepository,
                    private var domainEventEmitter: DomainEventEmitter):
        LogFacade {
    override fun createLog(staffID: UUID, patientID: UUID): Log {
        val log = logFactory.createLog(staffID, patientID)
        logRepository.save(log)
        domainEventEmitter.emit(NewLogAdded(staffID, patientID, Date()))
        return log
    }
}