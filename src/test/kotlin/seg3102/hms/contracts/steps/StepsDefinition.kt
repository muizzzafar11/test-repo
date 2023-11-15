package seg3102.hms.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.assertj.core.api.Assertions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.contracts.testStubs.factories.*
import seg3102.hms.contracts.testStubs.repositories.*
import seg3102.hms.contracts.testStubs.services.DomainEventEmitterStub
import seg3102.hms.domain.patientRegistration.entities.patient.Patient
import seg3102.hms.domain.patientRegistration.facade.implementation.PatientRegistrationFacadeImpl
import seg3102.hms.domain.userManagement.entities.Staff

import java.util.*

class StepsDefinition: En {
    private var admissionFactory = AdmissionFactoryStub()
    private var divisionFactory = DivisionFactoryStub()
    private var logFactory = LogFactoryStub()
    private var patientFactory = PatientFactoryStub()
    private var staffFactory = StaffFactoryStub()
    private var prescriptionFactory = PrescriptionFactoryStub()
    private var admissionRepository = AdmissionRepositoryStub()
    private var divisionRepository = DivisionRepositoryStub()
    private var logRepository = LogRepositoryStub()
    private var patientRepository = PatientRepositoryStub()
    private var staffRepository = StaffRepositoryStub()
    private var prescriptionRepository = PrescriptionRepositoryStub()
    private var domainEventEmitter = DomainEventEmitterStub()

    @Mock
    private var registeredPatient: Patient? = null
    private var currentStaff: Staff? = null

    init {
        Before { _: Scenario ->
            MockitoAnnotations.openMocks(this)
        }
        Given("the Medical Staff Member is logged in") {
            currentStaff = createStaff(staffRepository)
            Assertions.assertThat(currentStaff).isNotNull
        }
        Given("the Patient is not registered") {
            // TODO: to be implemented
        }
        Given("complete patient details are provided") {
            // TODO: to be implemented
        }
        When("the Medical Staff Member asks for new Patient registration") {
            // Then the HMS issues a new identification number for the patient
            registeredPatient = registerPatient(patientRepository)
            val log = logFactory.createLog(currentStaff!!.employeeNumber, registeredPatient!!.patientID)
        }
    }
}