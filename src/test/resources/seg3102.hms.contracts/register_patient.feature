Feature: Register Patient
  Scenario 1: Medical Staff Member is logged in, Patient details are complete, Patient ID is unique
    Given the Medical Staff Member is logged in
    And the Patient is not registered
    And complete patient details are provided
    When the Medical Staff Member asks for new Patient registration
    And the HMS asks for Patient's information
    And the Medical Staff Member enters the requested information
    Then the HMS issues a new identification number for the patient
    And a new Patient is created with attributes matching patient details
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log
    And the HMS registers the Patient
  Scenario 2: Medical Staff Member is logged in, Patient details are incomplete
    Given the Medical Staff Member is logged in
    And the Patient is not registered
    And incomplete patient details are provided
    When the Medical Staff Member attempts to register the Patient
    Then the HMS displays an "Incomplete information" error message
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log