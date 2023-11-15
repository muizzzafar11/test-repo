package seg3102.hms.contracts.testStubs.services

import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.domain.common.DomainEvent

class DomainEventEmitterStub: DomainEventEmitter {
    private val emitted: MutableList<DomainEvent> = ArrayList()

    override fun emit(event: DomainEvent) {
        emitted.add(event)
    }

//    fun retrieveNewItemAddedEvent(): NewItemAdded {
//        return emitted.find { it is NewItemAdded} as NewItemAdded
//
//    }
//
//    fun retrieveCreditCardCreatedEvent(): CreditCardCreated {
//        return emitted.find { it is CreditCardCreated} as CreditCardCreated
//    }
}