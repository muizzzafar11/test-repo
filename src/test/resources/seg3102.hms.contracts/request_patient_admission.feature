Feature: Request Patient Admission
  Scenario 1: Charge Nurse is logged in, Patient registration is displayed, Correct information is provided
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    When the Charge Nurse chooses to request patient admission
    And the HMS asks for the division and additional information
    And the Charge Nurse provides the required information
    Then the HMS puts the Patient in the requested ward list of patients awaiting admission
    And the HMS sends a notification to the requested ward Charge Nurse
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 2: Charge Nurse is logged in, Incorrect information is provided
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    When the Charge Nurse chooses to request patient admission
    And the HMS asks for the division and additional information
    And the Charge Nurse provides incorrect information
    Then the HMS displays an "Information error" message
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
  Scenario 3: Charge Nurse is logged in, Patient is already admitted to a service
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    And the patient is already admitted to a service
    When the Charge Nurse chooses to request patient admission
    Then the HMS displays a "Patient already in ward" error message
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log