Feature: Register Staff
  Scenario 1: Staff Member is not registered, Staff details are complete, Staff ID is unique
    Given the Staff Member is not registered
    And complete Staff details are provided
    When the Staff Member selects to register
    And the HMS asks for Staff Member information
    And the Staff Member provides all the required information
    Then the HMS displays an acknowledgment message
    And a new Staff Member is created with attributes matching staff details
    And the Staff Member is registered
  Scenario 2: Staff Member is not registered, Staff details are incomplete
    Given the Staff Member is not registered
    And incomplete staff details are provided
    When the Staff Member attempts to register
    Then the HMS displays an "Incomplete information" error message