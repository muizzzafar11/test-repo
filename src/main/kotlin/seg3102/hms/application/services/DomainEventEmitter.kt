package seg3102.hms.application.services

import seg3102.hms.domain.common.DomainEvent

interface DomainEventEmitter {
    fun emit(event: DomainEvent)
}