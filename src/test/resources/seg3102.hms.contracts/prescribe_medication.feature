Feature: Prescribe Medication
  Scenario 1: Doctor is logged in, Patient is one of the Doctor's, Correct information is provided
    Given the Doctor is logged in
    And there exist a Patient with Patient ID
    And there exist an assciation between the Doctor and the Patient as treating patient
    And the Patient is one of the Doctor's
    When the Doctor includes the use case "Consult File"
    And the Doctor asks to add a prescription to the selected patient
    And the HMS asks for the required information
    And the Doctor enters the required information
    Then the HMS records the prescription in the Patient's file
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 2: Doctor is logged in, Selected Patient is not one of the Doctor's
    Given the Doctor is logged in
    And there exist a Patient with Patient ID
    And the selected Patient is not one of the Doctor's
    When the Doctor attempts to prescribe medication
    Then the HMS notifies the Doctor that the Patient is not theirs
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 3: Doctor is logged in, Incorrect information is entered
    Given the Doctor is logged in
    And the Patient is one of the Doctor's
    When the Doctor includes the use case "Consult File"
    And the Doctor asks to add a prescription to the selected patient
    And the Doctor enters incorrect information
    Then the HMS displays an "Incorrect prescription" error message
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log