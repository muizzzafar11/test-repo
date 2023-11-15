Feature: Discharge Patient
  Scenario 1: Charge Nurse is logged in, Patient is admitted
    Given the Charge Nurse is logged in
    And the Patient is admitted
    When the Charge Nurse includes the use case "Consult File"
    And the Charge Nurse selects to discharge the Patient
    Then the HMS updates bed availability
    And the HMS prints discharge information
    And the Patient is no longer admitted
    And the Patient bed is added to the division availabilities
    And the Patient discharge information is issued and copies are slated to be sent to the Patient's external doctor
    And a new Log is created is initialized
    And Staff Member ID is associated with the Log
    And Patient ID is associated with the Log