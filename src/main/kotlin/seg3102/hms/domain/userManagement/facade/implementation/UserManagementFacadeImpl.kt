package seg3102.hms.domain.userManagement.facade.implementation

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import seg3102.hms.application.services.DomainEventEmitter
import seg3102.hms.domain.userManagement.events.NewStaffEvent
import seg3102.hms.domain.userManagement.entities.Staff
import seg3102.hms.domain.userManagement.entities.StaffRole
import seg3102.hms.domain.userManagement.events.NewStaffRole
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import seg3102.hms.domain.userManagement.factories.StaffFactory
import seg3102.hms.domain.userManagement.repositories.StaffRepository

import java.util.*

class UserManagementFacadeImpl(private var staffFactory: StaffFactory,
                               private var staffRepository: StaffRepository,
                               private var domainEventEmitter: DomainEventEmitter)
        : UserManagementFacade {

    val currentStaffID: UUID = UUID.randomUUID();
    override fun getStaff(staffInfo: StaffCreateDTO): UUID {
        return staffInfo.employeeNumber;
    }

    override fun checkValidStaffInfo(staffInfo: StaffCreateDTO, employeeID: UUID?): Boolean {
        return staffInfo.employeeNumber == employeeID
    }

    override fun addStaffRole(staffInfo: StaffCreateDTO): StaffRole {
        val role:StaffRole = staffFactory.createRole(staffInfo);
        staffRepository.save(role);
        domainEventEmitter.emit(NewStaffRole(role, Date()));
        return role;
    }

    override fun registerStaff(staffInfo: StaffCreateDTO, staffRole: StaffRole): UUID {
        val staff: Staff = staffFactory.createStaff(staffInfo, staffRole);
        staffRepository.save(staff);
        domainEventEmitter.emit(NewStaffEvent(staff, Date()));
        return staff.employeeNumber;
    }

    override fun getCurrentStaff(): UUID {
        return currentStaffID;
    }

    override fun getStaffRole(staffID: UUID): StaffRole {
        val staff = staffRepository.find(staffID);
        return staff.role;
    }

    override fun getStaffDivision(staffID: UUID): UUID {
        val staff = staffRepository.find(staffID);
        return staff.divisionID;
    }
}