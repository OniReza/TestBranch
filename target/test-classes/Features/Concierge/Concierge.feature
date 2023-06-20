Feature: Functionality Test For Concierge Feature

 @concierge @others @all_us @all_non_us
  Scenario:Verify Concierge Page
    Given user has logged into the portal
    When user click on concierge button
    And input a message on chat area
    And user hit the send button
    Then user should see the message on concierge board