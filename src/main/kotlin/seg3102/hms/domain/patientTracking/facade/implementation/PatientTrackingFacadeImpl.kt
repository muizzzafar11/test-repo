package seg3102.hms.domain.patientTracking.facade.implementation

import seg3102.hms.application.dtos.queries.PrescriptionCreateDTO
import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.patientTracking.entities.Prescription
import seg3102.hms.domain.patientTracking.events.NewPrescriptionAdded
import seg3102.hms.domain.patientTracking.facade.PatientTrackingFacade
import seg3102.hms.domain.patientTracking.factories.PrescriptionFactory
import seg3102.hms.domain.patientTracking.repositories.PrescriptionRepository
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class PatientTrackingFacadeImpl(private var userManagementFacade: UserManagementFacade, private var patientRegistrationFacade: PatientRegistrationFacade, private var prescriptionFactory: PrescriptionFactory, private var prescriptionRepository: PrescriptionRepository, private var domainEventEmitter: DomainEventEmitter): PatientTrackingFacade {
    override fun checkValidPrescription(prescription: PrescriptionCreateDTO, patientID: UUID): Boolean {
        // Check if the patient is in the doctors list
        var patient = patientRegistrationFacade.getPatient(patientID)
        var currentStaff = userManagementFacade.getCurrentStaff();
        return patient?.localDoctor == currentStaff
    }

    override fun prescribeMedication(prescription: PrescriptionCreateDTO, patientID: UUID): Prescription {
        val pres = prescriptionFactory.createPrescription(prescription, patientID);
        prescriptionRepository.save(pres)
        domainEventEmitter.emit(NewPrescriptionAdded(pres, Date()))
        return pres;
    }
}