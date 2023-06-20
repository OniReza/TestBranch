Feature: Test Add card Functionality in Seacret
  Background:
    Given user has logged into the portal

  @addCard
  Scenario: Verify Add card page
    When user clicks on cards on side menu
    And user clicks on Add card tab
    Then all three card with price should appear in a carousel

  Scenario:Verify Add First card (Tier 1) functionality
    When user clicks on cards on side menu
    And user clicks on Add card tab
    And user select first tier card
    And user checks paying amount with standard mail shipping
    And user clicks on continue button
    And user apply discount code of $8 in payment page
    And user checks payment and shipping summary in payment page
    And user press cross button
    And user checks paying amount with Expedite mail shipping
    And user clicks on continue button
    And user checks payment and shipping summary in payment page
    And user selects Accounts for payment
    And user confirms payment using accounts and press ok below the success message
    Then user should redirects to cards tab and one physical card with inactive status should appear

  Scenario: Verify Upgrade card to Second Tier page
    When user clicks on cards on side menu
    And user is in cards tab
    And user clicks on Upgrade card tab
    Then tier 2 and tier 3 card with price should appear in a carousel

  Scenario: Verify Upgrade card to Second Tier
    When user clicks on cards on side menu
    And user clicks on Upgrade card tab
    And user select second tier card
    And user checks paying amount with standard mail shipping
    And user clicks on continue button
    And user apply discount code of $100 in payment page
    And user checks payment and shipping summary in payment page
    And user press cross button
    And user checks paying amount with Expedite mail shipping
    And user clicks on continue button
    And user checks payment and shipping summary in payment page
    And user selects Accounts for payment
    And user confirms payment using accounts and press ok below the success message
    Then user should redirects to cards tab and two physical card with inactive status should appear

  Scenario: Verify Upgrade card to Third Tier
    When user clicks on cards on side menu
    And user is in cards tab
    And user clicks on Upgrade card tab
    Then tier 3 card with price should appear

  Scenario: Verify Upgrade card to Second Tier
    When user clicks on cards on side menu
    And user clicks on Upgrade card tab
    And user checks paying amount with standard mail shipping
    And user clicks on continue button
    And user apply discount code of $500 in payment page
    And user checks payment and shipping summary in payment page
    And user press cross button
    And user checks paying amount with Expedite mail shipping
    And user clicks on continue button
    And user checks payment and shipping summary in payment page
    And user selects Accounts for payment
    And user confirms payment using accounts and press ok below the success message
    Then user should redirects to cards tab and three physical card with inactive status should appear


