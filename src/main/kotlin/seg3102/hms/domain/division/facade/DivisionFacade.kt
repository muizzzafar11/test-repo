package seg3102.hms.domain.division.facade

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import java.util.*

interface DivisionFacade {
    fun removeRoom(patientID: UUID)
    fun removeBed(patientID: UUID)
    fun getChargeNurseID(divisionID: UUID): UUID
    fun updateAvailableRooms(admission: AdmissionCreateDTO)
    fun updateAvailableBeds(admission: AdmissionCreateDTO)
    fun patientInRequestList(patientID: UUID, chargeNurseID: UUID): Boolean
    fun addPatientToRequestList(patientID: UUID, admissionRequest: AdmissionRequest, chargeNurseID: UUID)
    fun removePatientFromRequestList(admission: AdmissionCreateDTO, patientID: UUID)
    fun getValidAdmission(admission: AdmissionCreateDTO): Boolean
}