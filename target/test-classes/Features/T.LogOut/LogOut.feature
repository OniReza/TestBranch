Feature: Test Log Out Functionality
  Background:
    Given user has logged into the portal
  @logout @others @all_us @all_non_us
  Scenario: Verify Logout Functionality
    When user clicks on logout button