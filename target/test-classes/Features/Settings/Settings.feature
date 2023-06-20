Feature: Test Settings Functionality
  Background:
    Given user has logged into the portal

  @settings @others @all_us @all_non_us
  Scenario: Verify Password Change Functionality
    When user clicks on settings button
    And user clicks on change password
    And user inputs current password
    And user inputs new password
    And user clicks on change password button
    And user inputs otp and clicks on confirm button
    And success message should appear
    And user should be able to login using new password
    Then user will change password again

  @settings @others @all_us @all_non_us
  Scenario: Verify Change Billing Method to Automatic
    When user is on settings page
    And user clicks on change billing method
    And user selects automatic from method dropdown
    And clicks on save button
    Then automatic should show in settings page

  @settings @others @all_us @all_non_us
  Scenario: Verify Change Billing Method to Accounts
    When user is on settings page
    And user clicks on change billing method
    And user selects accounts from method dropdown
    And user clicks first wallet
    And clicks on save button
    Then selected wallet should show in settings page

  @settings @others @all_us @all_non_us @t1
  Scenario: Verify Change Billing Method to Debit or Credit card
    When user is on settings page
    And user clicks on change billing method
    And user selects debit or credit card from method dropdown
    And clicks on add new card
    And enter card details in Apexx getway and clicks on pay
    And check newly added card
    And user selects new added card
    And clicks on save button
    Then verify payment method change in setting page

  @settings @others @all_us @all_non_us
  Scenario: Verify Marketing Functionality of Settings Page
    When user is on settings page
    And user clicks on Phone change of marketing
    And user should see message
    And user clicks on Fax change of marketing
    And user should see message
    And user clicks on Email change of marketing
    And user should see message
    And user clicks on postalmail change of marketing
    Then user should see message

  @settings @others @all_us @all_non_us
  Scenario: Verify Settings Functionality of Settings Page
    When user clicks on settings button
    And user clicks on preferred currency change button
    And user clicks dropdown and saves any currency
    And user clicks on preferred language change button
    And user clicks dropdown and saves any Language
    Then saved currency and language should show in settings page






