package seg3102.hms.contracts.steps

import seg3102.hms.domain.patientRegistration.entities.patient.NextOfKin
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import seg3102.hms.domain.patientRegistration.repositories.PatientRepository
import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole
import seg3102.hms.domain.userManagement.repositories.StaffRepository
import java.util.*

fun createStaff(staffRepository: StaffRepository): Staff {
    val staff = Staff(UUID.randomUUID(),
            "pswd",
            "Jusitn",
            "Zoorob",
            "email@email.com",
            StaffRole.DOCTOR,
            UUID.randomUUID())

    return staffRepository.save(staff)
}

fun registerPatient(patientRepository: PatientRepository): Patient {
    val newNextOfKin: NextOfKin = NextOfKin("patientInfo.nextOfKin.fullName",
            "patientInfo.nextOfKin.relationshipToPatient",
            "patientInfo.nextOfKin.address",
            "patientInfo.nextOfKin.telephoneNumber")

    val newPatient = Patient(UUID.randomUUID(),
            "random insurance number",
            "Jusitn",
            "Zoorob",
            "417 Nelson",
            "0000000000",
            Date(),
            "male",
            "single",
            "Arunav",
            UUID.randomUUID(),
            newNextOfKin)

    return patientRepository.save(newPatient)
}