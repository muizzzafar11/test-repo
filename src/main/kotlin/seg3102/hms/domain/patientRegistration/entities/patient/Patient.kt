package seg3102.hms.domain.patientRegistration.entities.patient

import seg3102.hms.application.dtos.queries.PatientCreateDTO
import java.util.*

class Patient (val patientID: UUID,
               var governmentInsuranceNumber: String,
               var firstName: String,
               var lastName: String,
               var address: String,
               var telephoneNumber: String,
               var dateOfBirth: Date,
               var gender: String,
               var maritalStatus: String,
               var externalDoctor: String,
               var localDoctor: UUID,
               var nextOfKin: NextOfKin
) {

    fun update(patientInfo: PatientCreateDTO) {
        this.governmentInsuranceNumber = patientInfo.governmentInsuranceNumber;
        this.firstName = patientInfo.firstName;
        this.lastName = patientInfo.lastName;
        this.address = patientInfo.address;
        this.telephoneNumber = patientInfo.telephoneNumber;
        this.dateOfBirth = patientInfo.dateOfBirth;
        this.gender = patientInfo.gender;
        this.maritalStatus = patientInfo.maritalStatus;
        this.externalDoctor = patientInfo.externalDoctor;
        this.localDoctor = patientInfo.localDoctor;

        val newNextOfKin:NextOfKin = NextOfKin(patientInfo.nextOfKin.fullName,
                patientInfo.nextOfKin.relationshipToPatient,
                patientInfo.nextOfKin.address,
                patientInfo.nextOfKin.telephoneNumber)

        this.nextOfKin = newNextOfKin;
    }

}