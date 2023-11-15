Feature: Admit Patient from Request List
  Scenario 1: Charge Nurse is logged in, Patient is in request list, Patient can be admitted
    Given the Charge Nurse is logged in
    And the Patient is in the request list
    When the Charge Nurse browses through the list of Patients in request list and selects one
    And the HMS displays the selected Patient registration
    And the Charge Nurse performs the admission as in the use case "Admit Patient"
    Then the Patient is admitted from the request list
  Scenario 2: Charge Nurse is logged in, Patient is in request list, Patient cannot be admitted
    Given the Charge Nurse is logged in
    And the Patient is in the request list
    When the Charge Nurse browses through the list of Patients in request list and selects one
    And the HMS displays the selected Patient registration
    And the Charge Nurse determines the Patient cannot be admitted
    Then the Charge Nurse denies the Patient admission
    And the HMS sends a notification to the Charge Nurse who requested admission