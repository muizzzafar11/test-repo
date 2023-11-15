package seg3102.hms.contracts.testStubs.repositories

import seg3102.hms.domain.division.entities.Division
import seg3102.hms.domain.division.repositories.DivisionRepository
import java.util.*

class DivisionRepositoryStub: DivisionRepository {
    override fun find(chargeNurseID: UUID): Division {
        TODO("Not yet implemented")
    }

    override fun getDivision(divisionId: UUID): Division {
        TODO("Not yet implemented")
    }

    override fun save(division: Division): Division {
        TODO("Not yet implemented")
    }
}