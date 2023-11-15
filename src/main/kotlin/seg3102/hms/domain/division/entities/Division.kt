package seg3102.hms.domain.division.entities

import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

class Division (val id: UUID,
                val divisionName: String,
                val chargeNurse: ChargeNurse,
                val location: String,
                val totalNumberOfBeds: Int,
                val totalNumberOfRooms: Int,
                val telephoneNumberExt: Int,
                var isComplete: Boolean,
                var requestList: MutableMap<UUID, AdmissionRequest>) 
{

    private val roomsList = mutableListOf<Int>()
    private val bedsList = mutableListOf<Int>()

    fun addBedToList(bedNumber: Int) {
        if (bedNumber < totalNumberOfRooms && !bedsList.contains(bedNumber)) {
            roomsList.add(bedNumber)
        } else {
            println("room already taken")
        }
    }

    fun addRoomToList(roomNumber: Int) {
        if (roomNumber < totalNumberOfRooms && !roomsList.contains(roomNumber)) {
            roomsList.add(roomNumber)
        } else {
            println("room already taken")
        }
    }

    fun removeRoomFromList(roomNumber: Int) {
        roomsList.remove(roomNumber);
    }

    fun removeBedFromList(bedNumber: Int) {
        bedsList.remove(bedNumber);
    }
}