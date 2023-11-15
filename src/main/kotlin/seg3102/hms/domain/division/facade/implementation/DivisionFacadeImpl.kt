package seg3102.hms.domain.division.facade.implementation

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.domain.division.facade.DivisionFacade
import seg3102.hms.domain.division.factories.DivisionFactory

import seg3102.hms.domain.division.repositories.DivisionRepository
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.repositories.AdmissionRepository
import java.util.*

class DivisionFacadeImpl(private var divisionRepository: DivisionRepository,
                         private var divisionFactory: DivisionFactory,
                         private var admissionRepository: AdmissionRepository):
        DivisionFacade {
    override fun removeRoom(patientID: UUID) {
        val admission = admissionRepository.find(patientID);
        val divisionId = admission.divisionID;
        val division = divisionRepository.getDivision(divisionId);
        division.removeRoomFromList(admission.roomNumber);
        divisionRepository.save(division);
    }

    override fun removeBed(patientID: UUID) {
        val admission = admissionRepository.find(patientID);
        val divisionId = admission.divisionID;
        val division = divisionRepository.getDivision(divisionId);
        division.removeBedFromList(admission.bedNumber);
        divisionRepository.save(division);
    }

    override fun getChargeNurseID(divisionID: UUID): UUID {
        val division = divisionRepository.getDivision(divisionID)

        val id = division.chargeNurse.employeeNumber 
        return id;
    }

    override fun updateAvailableBeds(admission: AdmissionCreateDTO) {
        val division = divisionRepository.getDivision(admission.divisionID)

        division.addBedToList(admission.roomNumber)
    }

    override fun updateAvailableRooms(admission: AdmissionCreateDTO) {
        val division = divisionRepository.getDivision(admission.divisionID)

        division.addRoomToList(admission.roomNumber)

    }

    override fun patientInRequestList(patientID: UUID, chargeNurseID: UUID): Boolean {
        val division = divisionRepository.find(chargeNurseID);
        return division.requestList.containsKey(patientID);
    }

    override fun addPatientToRequestList(patientID: UUID, admissionRequest: AdmissionRequest, chargeNurseID: UUID) {
        val division = divisionRepository.find(chargeNurseID)
        division.requestList.put(patientID, admissionRequest)
    }

    override fun removePatientFromRequestList(admission: AdmissionCreateDTO, patientID: UUID) {
        val divisionId = admission.divisionID;
        val division = divisionRepository.getDivision(divisionId);
        division.requestList.remove(patientID);
        divisionRepository.save(division);
    }

    override fun getValidAdmission(admission: AdmissionCreateDTO): Boolean {

        val division = divisionRepository.getDivision(admission.divisionID);
        return if (division.totalNumberOfRooms <= 0) {
            println("no rooms available in this division")
            false;
        } else {
            true;
        }
    }
}