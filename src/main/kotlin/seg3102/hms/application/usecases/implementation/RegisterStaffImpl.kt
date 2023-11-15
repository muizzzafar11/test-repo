package seg3102.hms.application.usecases.implementation

import seg3102.hms.application.dtos.queries.StaffCreateDTO
import seg3102.hms.application.usecases.RegisterStaff
import seg3102.hms.domain.userManagement.facade.UserManagementFacade
import java.util.*

class RegisterStaffImpl (private var userManagementFacade: UserManagementFacade): RegisterStaff {
    override fun registerStaff(staffInfo: StaffCreateDTO): UUID? {
        val employeeID = userManagementFacade.getStaff(staffInfo);
        val staffValid = userManagementFacade.checkValidStaffInfo(staffInfo, employeeID);

        if (staffValid) {
            // staff found in system and info is valid
            val staffRole = userManagementFacade.addStaffRole(staffInfo);
            val staffID = userManagementFacade.registerStaff(staffInfo, staffRole);
            return staffID;
        }

        // staff not found in system, error message somewhere
        return null;
    }
}