package seg3102.hms.domain.patientRegistration.facade.implementation

import seg3102.hms.application.dtos.queries.AdmissionCreateDTO
import seg3102.hms.application.dtos.queries.NextOfKinCreateDTO
import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.domain.patientRegistration.entities.admission.Admission
import seg3102.hms.domain.patientRegistration.entities.admission.AdmissionRequest
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import seg3102.hms.domain.patientRegistration.events.NewAdmission
import seg3102.hms.domain.patientRegistration.events.NewAdmissionRequest
import seg3102.hms.domain.patientRegistration.events.NewPatient
import seg3102.hms.domain.patientRegistration.events.PatientUpdated
import seg3102.hms.domain.patientRegistration.facade.PatientRegistrationFacade
import seg3102.hms.domain.patientRegistration.factories.AdmissionFactory
import seg3102.hms.domain.patientRegistration.factories.PatientFactory
import seg3102.hms.domain.patientRegistration.repositories.AdmissionRepository
import seg3102.hms.domain.patientRegistration.repositories.PatientRepository

import java.util.*

class PatientRegistrationFacadeImpl(private var patientFactory: PatientFactory,
                                    private var patientRepository: PatientRepository,
                                    private var domainEventEmitter: DomainEventEmitter,
                                    private var admissionFactory: AdmissionFactory,
                                    private var admissionRepository: AdmissionRepository):
        PatientRegistrationFacade {

    override fun getPatient(patientID: UUID): Patient {
        return patientRepository.find(patientID);
    }

    override fun updatePatientFile(patientID: UUID, patientInfo: PatientCreateDTO) {
        val patient:Patient = patientRepository.find(patientID);
        patient.update(patientInfo);
        patientRepository.save(patient);
        domainEventEmitter.emit(PatientUpdated(patient.patientID, Date()));
    }

    override fun removePatientFromFile(patientID: UUID) {
        patientRepository.removePatientFromFile(patientID);
    }

    override fun admissionFromRequest(admissionRequest: AdmissionRequest): AdmissionCreateDTO {
        val adm = admissionFactory.createAdmissionFromRequest(admissionRequest);
        return adm;
    }

    override fun checkValidPatientInfo(patientInfo: PatientCreateDTO): Boolean {
        if((patientInfo.governmentInsuranceNumber is String) &&
            (patientInfo.firstName is String) &&
            (patientInfo.lastName is String) &&
            (patientInfo.address is String) &&
            (patientInfo.telephoneNumber is String) &&
            (patientInfo.dateOfBirth is Date) &&
            (patientInfo.gender is String) &&
            (patientInfo.maritalStatus is String) &&
            (patientInfo.externalDoctor is String) &&
            (patientInfo.nextOfKin is NextOfKinCreateDTO)
        ){
            return true
        }
        return false
    }

    override fun admitPatient(admission: AdmissionCreateDTO, patientID: UUID): Admission {

        val adm = admissionFactory.createAdmission(admission, patientID);
        admissionRepository.save(adm);
        domainEventEmitter.emit(NewAdmission(adm, Date()));
        return adm;
    }

    override fun registerPatient(patientInfo: PatientCreateDTO): UUID {
        val patient:Patient = patientFactory.createPatient(patientInfo);
        patientRepository.save(patient);
        domainEventEmitter.emit(NewPatient(patient, Date()));
        return patient.patientID;
    }

    override fun createAdmissionRequest(patientID: UUID, divisionID: UUID): AdmissionRequest {
        val admRequest = admissionFactory.createAdmissionRequest(patientID, divisionID);
        admissionRepository.saveAdmissionRequest(admRequest);
        domainEventEmitter.emit(NewAdmissionRequest(admRequest, Date()));

        return admRequest;
    }

    override fun getPatientLocalDoctor(patientID: UUID): UUID {
        val doctorUUID = admissionRepository.getAdmissionDoctorUUID()
        return doctorUUID

    }
}