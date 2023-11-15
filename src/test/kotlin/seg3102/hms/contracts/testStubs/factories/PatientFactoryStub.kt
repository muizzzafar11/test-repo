package seg3102.hms.contracts.testStubs.factories

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import seg3102.hms.domain.patientRegistration.entities.patient.NextOfKin
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import seg3102.hms.domain.patientRegistration.factories.PatientFactory
import java.util.*

class PatientFactoryStub: PatientFactory {
    override fun createPatient(patientInfo: PatientCreateDTO): Patient {
        val newNextOfKin: NextOfKin = NextOfKin(patientInfo.nextOfKin.fullName,
                patientInfo.nextOfKin.relationshipToPatient,
                patientInfo.nextOfKin.address,
                patientInfo.nextOfKin.telephoneNumber)

        val patient:Patient = Patient(UUID.randomUUID(),
                patientInfo.governmentInsuranceNumber,
                patientInfo.firstName,
                patientInfo.lastName,
                patientInfo.address,
                patientInfo.telephoneNumber,
                patientInfo.dateOfBirth,
                patientInfo.gender,
                patientInfo.maritalStatus,
                patientInfo.externalDoctor,
                patientInfo.localDoctor,
                newNextOfKin);

        return patient;
    }
}