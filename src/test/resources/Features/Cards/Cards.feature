Feature: Test functionality of Card page
  Background:
    Given user has logged into the portal


  @phy_card_load @all_phy_card_feature @all_card_features @all_us @all_non_us @card_load @test
  Scenario: Verify Load Functionality of Physical Card
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on load tab
    And user enters amount to load "180"
    And user checks load summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

  @phy_card_unload @all_phy_card_feature @all_card_features @all_us @all_non_us @card_unload @test
  Scenario: Verify Unload Functionality of Physical Card
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on unload tab
    And user enters amount to unload "90"
    And user checks unload summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

    #Topup only for clubswan
  @cs_phy_card_topup_us @cs_card_topup_us
  Scenario: Verify Topup Functionality of Physical Card for US members
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Stripe and clicks on pay
    And user checks topup confirmation message and clicks ok button
    Then user should redirect back to physical card page

    #Topup only for clubswan
  @cs_phy_card_topup_non_us @cs_card_topup_non_us
  Scenario: Verify Topup Functionality of Physical Card for Non-US members
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Apexx and clicks on pay
    And user checks topup confirmation message and clicks ok button
    Then user should redirect back to physical card page

  @phy_card_pin @all_phy_card_feature @all_card_features @all_us @all_non_us
  Scenario: Verify Pin Functionality of Physical Card
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on pin tab
    And user inputs password
    And user clicks on submit
    Then card pin should appear

  @phy_card_dgCard @all_phy_card_feature @all_card_features @all_us @all_non_us @dgCard
  Scenario: Verify Digital Card Functionality of Physical Card
    When user clicks on cards on side menu
    And user clicks on activated physical master card
    And user clicks on digital card tab
    And user inputs otp
    And user clicks on show card details button
    Then card details should appear

  @phy_card_statement @all_phy_card_feature @all_card_features @all_us @all_non_us
  Scenario: Verify Statement Tab of Physical Card
    When user clicks on cards on side menu
    And user clicks on physical card
    And user clicks on statements Tab
    And user clicks on download button if any statement available
    Then a statement will be downloaded

  @phy_card_transaction @all_phy_card_feature @all_card_features @all_us @all_non_us
  Scenario: Verify Transaction Tab of Physical Card
    When user clicks on cards on side menu
    And user clicks on physical card
    When user clicks on transaction tab
    And latest transactions should appear in  your transactions section
    Then user should be able to export transactions as pdf and csv

##++++++++++++++++++++++++++++++++++++++++++++++++++++ First Virtual Card ++++++++++++++++++++++++++++++++++++++++++++++
  @first_Vcard_load @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_load
  Scenario: Verify Load Functionality of First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on load tab
    And user enters amount to load "550"
    And user checks load summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

  @first_Vcard_unload @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_unload
  Scenario: Verify UnLoad Functionality of First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    When user clicks on unload tab
    And user enters amount to unload "90"
    And user checks unload summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

  @cs_first_Vcard_topup_us @cs_card_topup_us
  Scenario: Verify Topup Functionality of First Virtual Card for US members
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Stripe and clicks on pay
    And user checks topup confirmation message and clicks ok button
    Then user should redirect back to virtual card page


  @cs_first_Vcard_topup_non_us @cs_card_topup_non_us
  Scenario: Verify Topup Functionality of First Virtual Card for Non-US members
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Apexx and clicks on pay
    And user checks topup confirmation message and clicks back button
    Then user should redirect back to virtual card page

  @first_Vcard_pin @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Pin Functionality of First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on pin tab
    And user inputs password
    And user clicks on submit
    Then card pin should appear

  @first_Vcard_dgCard @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @dgCard
  Scenario: Verify Digital Card Functionality of  First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on activated first virtual card
    And user clicks on digital card tab
    And user inputs otp
    And user clicks on show card details button
    Then card details should appear

  @first_Vcard_transaction @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Transaction Tab of First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on transaction tab
    And latest transactions should appear in  your transactions section
    Then user should be able to export transactions as pdf and csv

  @first_Vcard_statement @all_first_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Statement Tab of First Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on first virtual card
    And user clicks on statements Tab
    And user clicks on download button if any statement available
    Then a statement will be downloaded

##++++++++++++++++++++++++++++++++++++++++++++++++++++ Second Virtual Card +++++++++++++++++++++++++++++++++++++++++++++
  @second_Vcard_load @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_load
  Scenario: Verify Load Functionality of Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on load tab
    And user enters amount to load "350"
    And user checks load summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

  @second_Vcard_unload @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_unload
  Scenario: Verify UnLoad Functionality of Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    When user clicks on unload tab
    And user enters amount to unload "90"
    And user checks unload summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page


  @cs_second_Vcard_topup_us @cs_card_topup_us
  Scenario: Verify Topup Functionality of Second Virtual Card for US members
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Stripe and clicks on pay
    And user checks topup confirmation message and clicks ok button
    Then user should redirect back to virtual card page


  @cs_second_Vcard_topup_non_us @cs_card_topup_non_us
  Scenario: Verify Topup Functionality of Second Virtual Card for Non-US members
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Apexx and clicks on pay
    And user checks topup confirmation message and clicks back button
    Then user should redirect back to virtual card page

  @second_Vcard_pin @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Pin Functionality of Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on pin tab
    And user inputs password
    And user clicks on submit
    Then card pin should appear

  @second_Vcard_dgCard @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @dgCard
  Scenario: Verify Digital Card Functionality of  Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on activated second virtual card
    And user clicks on digital card tab
    And user inputs otp
    And user clicks on show card details button
    Then card details should appear

  @second_Vcard_transaction @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Transaction Tab of Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on transaction tab
    And latest transactions should appear in  your transactions section
    Then user should be able to export transactions as pdf and csv

  @second_Vcard_statement @all_second_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Statement Tab of Second Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on second virtual card
    And user clicks on statements Tab
    And user clicks on download button if any statement available
    Then a statement will be downloaded

    ##++++++++++++++++++++++++++++++++++++++++++++++++++++ Third Virtual Card +++++++++++++++++++++++++++++++++++++++++++++
  @third_Vcard_load @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_load
  Scenario: Verify Load Functionality of Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on load tab
    And user enters amount to load "150"
    And user checks load summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page

  @third_Vcard_unload @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @card_unload
  Scenario: Verify UnLoad Functionality of Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    When user clicks on unload tab
    And user enters amount to unload "90"
    And user checks unload summary
    And user clicks confirm button
    And user provides otp and clicks confirm button again
    And user checks transfer success message and press ok button
    Then user should redirect back to physical card page


  @cs_third_Vcard_topup_us @cs_card_topup_us
  Scenario: Verify Topup Functionality of Third Virtual Card for US members
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Stripe and clicks on pay
    And user checks topup confirmation message and clicks ok button
    Then user should redirect back to virtual card page


  @cs_third_Vcard_topup_non_us @cs_card_topup_non_us
  Scenario: Verify Topup Functionality of Third Virtual Card for Non-US members
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on topup tab
    And user selects amount to topup
    And clicks on topup button
    And user checks summary
    And user clicks confirm button for topup
    And enter card details in Apexx and clicks on pay
    And user checks topup confirmation message and clicks back button
    Then user should redirect back to virtual card page

  @third_Vcard_pin @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Pin Functionality of Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on pin tab
    And user inputs password
    And user clicks on submit
    Then card pin should appear

  @third_Vcard_dgCard @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us @dgCard
  Scenario: Verify Digital Card Functionality of  Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on activated third virtual card
    And user clicks on digital card tab
    And user inputs otp
    And user clicks on show card details button
    Then card details should appear

  @third_Vcard_transaction @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Transaction Tab of Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on transaction tab
    And latest transactions should appear in  your transactions section
    Then user should be able to export transactions as pdf and csv

  @third_Vcard_statement @all_third_Vcard_feature @all_card_features @all_Vcard_features @all_us @all_non_us
  Scenario: Verify Statement Tab of Third Virtual Card
    When clicks on virtual card tab from card page
    And user clicks on third virtual card
    And user clicks on statements Tab
    And user clicks on download button if any statement available
    Then a statement will be downloaded

