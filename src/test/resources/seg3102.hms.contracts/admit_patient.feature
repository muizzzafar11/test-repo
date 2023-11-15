Feature: Admit Patient
  Scenario 1: Charge Nurse is logged in, Patient's file is accessible, Room and bed are manually entered
    Given the Charge Nurse is logged in
    And the Patient's file is accessible
    When the Charge Nurse chooses to admit the patient
    And the HMS asks for room and bed number
    And the Charge Nurse enters room and bed number
    And the HMS asks for the remaining admission information
    And the Charge Nurse enters the requested information
    Then the HMS admits the patient
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 2: Charge Nurse is logged in, Patient's file is accessible, Room and bed are selected from a list
    Given the Charge Nurse is logged in
    And the Patient's file is accessible
    When the Charge Nurse chooses to admit the patient
    And the HMS provides a list of available rooms and beds
    And the Charge Nurse makes a selection from the list
    And the HMS asks for the remaining admission information
    And the Charge Nurse enters the requested information
    Then the HMS admits the patient
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 3: Charge Nurse is logged in, Division is complete
    Given the Charge Nurse is logged in
    And the division is complete
    When the Charge Nurse chooses to admit the patient
    Then the HMS notifies the Charge Nurse that their division is complete
    And the HMS gives the possibility to request an admission for the Patient as in the use case "Request Patient Admission"