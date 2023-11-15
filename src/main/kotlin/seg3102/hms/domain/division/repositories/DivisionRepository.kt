package seg3102.hms.domain.division.repositories

import seg3102.hms.domain.division.entities.Division
import java.util.UUID

interface DivisionRepository {

    fun getDivision(divisionId: UUID): Division
    fun find(chargeNurseID: UUID): Division
    fun save(division: Division): Division
}