Feature: Update Patient File
  Scenario 1: Medical Staff Member is logged in, Patient's file is accessible, Update details are provided
    Given the Medical Staff Member is logged in
    And existing Patient information referred to in updated patient details
    And the Patient's file is accessible
    When the Medical Staff Member modifies information
    And the Medical Staff Member resubmits the information
    Then the HMS updates the Patient's registration information
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 2: Medical Staff Member is logged in, does not have enough privilege to modify
    Given the Medical Staff Member is logged in
    And the Medical Staff Member does not have enough privilege to modify the patient's file
    When the Medical Staff Member attempts to modify the patient's file
    Then the HMS displays a "Modification not allowed" error message
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log