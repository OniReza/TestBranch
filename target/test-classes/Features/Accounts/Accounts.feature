Feature: Test Accounts Functionality

  Background:
    Given user has logged into the portal

  @card_deposit_usd_us @card_deposit_us @usd_all_features_us @all_wallet_features_us @all_us
  Scenario: Deposit: Verify Card Deposit to USD Wallet via Stripe
    When user clicks on USD wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Stripe and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

  @card_deposit_usd_non_us @card_deposit_non_us @usd_all_features_non_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Card Deposit to USD Wallet via Apexx
    When user clicks on USD wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Apexx and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

  @usd_move @move @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify USD Wallet to GBP Wallet Move(Sender's End)
    When user clicks on USD wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects GBP wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @usd_move @move @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify USD Wallet to GBP Wallet Move(Receiver's End)
    When user clicks on USD wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects GBP wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @usd_us_bank @usd_all_features_us @all_wallet_features_us @all_us @localUs
  Scenario: Deposit: Verify Local(US Bank) Deposit to USD Wallet
    When user clicks on USD wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects local(US Bank)
    Then user should see details of local us bank of usd wallet

  @usd_uk_bank @usd_all_features_non_us @all_non_us @all_wallet_features_non_us @localUk
  Scenario: Deposit: Verify Local(UK Bank) Deposit to USD Wallet
    When user clicks on USD wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    And user expend from dropdown again
    And user selects local(UK Bank)
    Then user should see details of local UK bank

  @usd_intl_bank @usd_all_features_non_us @all_non_us @all_wallet_features_non_us @intl_non_uk_bank
  Scenario: Deposit: Verify International (non UK Bank) Deposit to USD Wallet
    When user clicks on USD wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    Then user should see details of International non UK Bank


  @usd_crypto @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Crypto Deposit to USD Wallet
    When user clicks on USD wallet
    When user clicks on deposit
    And user expend from dropdown
    And user selects crypto deposit
    And user enters sending amount in TBTC
    And user clicks on terms and condition check box
    And user clicks confirm
    Then user should see a summary

  @usd_m2m @m2m @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "55" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @fp
  Scenario: Payments: Verify Make a FP payment to a New Individual from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for FP
    And user enters amount 6000
    And user checks total debit amount with FP fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum FP fee
    And user selects timing(now)
    And user enter references for FP
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab
    Then user should see sender post transaction balance after FP is equal to available balance


  @SEPA
  Scenario: Payments: Verify Make a SEPA payment to a New Individual from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for SEPA
    And user enters amount 6000
    And user checks total debit amount with SEPA fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum SEPA fee
    And user selects timing(now)
    And user enter references for SEPA
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after SEPA is equal to available balance

  @ach
  Scenario: Payments: Verify Make a ACH payment to a New Individual from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for ACH
    And user enters amount 6000
    And user checks total debit amount with ACH fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum ACH fee
    And user selects timing(now)
    And user enter references for ACH
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after ACH is equal to USD wallets to available balance

  @wir
  Scenario: Payments: Verify Make a WIR payment to a New Individual from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for WIR
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR payment is equal to wallet's available balance


  @usd_make_payment @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to New Business from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on new
    And user enters other recipient details for new business
    And user enters bank details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @usd_make_payment @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to Existing Business from USD Wallet
    When user clicks on USD wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on existing
    And user selects existing recipient from recipient details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @usd_details @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Details Tab Graph of USD Wallet
    When user clicks on USD wallet
    Then user should see a graph


  @usd_statement @usd_all_features_us @usd_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Statement Tab of USD Wallet
    When user clicks on USD wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded

#+++++++++++++++++++++++++++++++++++++++++++++++++++++++EURO wallet++++++++++++++++++++++++++++++++++++++++++++++++++++++
  @card_deposit_euro_us @card_deposit_us @euro_all_features_us @all_wallet_features_us @all_us
  Scenario: Deposit: Verify Card Deposit to Euro Wallet via Stripe
    When user clicks on EURO wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Stripe and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

  @card_deposit_euro_non_us @card_deposit_non_us @euro_all_features_non_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Card Deposit to Euro Wallet via Apexx
    When user clicks on EURO wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Apexx and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance


  @euro_move @move @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Euro Wallet to USD Wallet Move(Sender's End)
    When user clicks on EURO wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @euro_move @move @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Euro Wallet to USD Wallet Move(Receiver's End)
    When user clicks on EURO wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @euro_us_bank @euro_all_features_us @all_wallet_features_us @all_us @localUs
  Scenario: Deposit: Verify Local(US Bank) Deposit to Euro Wallet
    When user clicks on EURO wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects local(US Bank)
    Then user should see details of local us bank


  @euro_uk_bank @euro_all_features_non_us @all_non_us @all_wallet_features_non_us @localUk
  Scenario: Deposit: Verify Local(UK Bank) Deposit to EURO Wallet
    When user clicks on EURO wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    And user expend from dropdown again
    And user selects local(UK Bank)
    Then user should see details of local UK bank

  @euro_intl_bank @euro_all_features_non_us @all_non_us @all_wallet_features_non_us @intl_non_uk_bank
  Scenario: Deposit: Verify International (non UK Bank) Deposit to EURO Wallet
    When user clicks on EURO wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    Then user should see details of International non UK Bank


  @euro_crypto @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Crypto Deposit to Euro Wallet
    When user clicks on EURO wallet
    When user clicks on deposit
    And user expend from dropdown
    And user selects crypto deposit
    And user enters sending amount in TBTC
    And user clicks on terms and condition check box
    And user clicks confirm
    Then user should see a summary

  @euro_m2m @m2m @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from Euro Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "45" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @fp
  Scenario: Payments: Verify Make a FP payment to a New Individual from EURO Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for FP
    And user enters amount 6000
    And user checks total debit amount with FP fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum FP fee
    And user selects timing(now)
    And user enter references for FP
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after FP is equal to available balance

  @sepa
  Scenario: Payments: Verify Make a SEPA payment to a New Individual from EURO Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for SEPA
    And user enters amount 6000
    And user checks total debit amount with SEPA fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum SEPA fee
    And user selects timing(now)
    And user enter references for SEPA
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after SEPA is equal to Euro wallets available balance

  @ach
  Scenario: Payments: Verify Make a ACH payment to a New Individual from EURO Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for ACH
    And user enters amount 6000
    And user checks total debit amount with ACH fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum ACH fee
    And user selects timing(now)
    And user enter references for ACH
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after ACH payment is equal to available balance

  @wir
  Scenario: Payments: Verify Make a WIR payment to a New Individual from Euro Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for WIR
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR payment is equal to wallet's available balance

  @euro_make_payment @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to New Business from Euro Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on new
    And user enters other recipient details for new business
    And user enters bank details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @euro_make_payment @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to Existing Business from Euro Wallet
    When user clicks on EURO wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on existing
    And user selects existing recipient from recipient details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @euro_details @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Details Tab Graph of Euro Wallet
    When user clicks on EURO wallet
    Then user should see a graph

  @euro_statement @euro_all_features_us @euro_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Statement Tab of Euro Wallet
    When user clicks on EURO wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded

#+++++++++++++++++++++++++++++++++++++++++++GBP wallet feature++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  @card_deposit_gbp_us @card_deposit_us @gbp_all_features_us @all_wallet_features_us @all_us
  Scenario: Deposit: Verify Card Deposit to GBP Wallet via Stripe
    When user clicks on GBP wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Stripe and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

  @card_deposit_gbp_non_us @card_deposit_non_us @gbp_all_features_non_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Card Deposit to GBP Wallet via Apexx
    When user clicks on GBP wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "10000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Apexx and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance


  @gbp_move @move @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify GBP Wallet to EURO Wallet Move(Sender's end)
    When user clicks on GBP wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects EUR wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @gbp_move @move @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify GBP Wallet to EURO Wallet Move(Receiver's end)
    When user clicks on GBP wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects EUR wallet
    And enter amount on sending amount box "200"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @gbp_us_bank @gbp_all_features_us @all_wallet_features_us @all_us @localUs
  Scenario: Deposit: Verify Local(US Bank) Deposit to GBP Wallet
    When user clicks on GBP wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects local(US Bank)
    Then user should see details of local us bank

  @gbp_uk_bank @gbp_all_features_non_us @all_non_us @all_wallet_features_non_us @localUk
  Scenario: Deposit: Verify Local(UK Bank) Deposit to GBP Wallet
    When user clicks on GBP wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    And user expend from dropdown again
    And user selects local(UK Bank)
    Then user should see details of local UK bank

  @gbp_intl_bank @gbp_all_features_non_us @all_non_us @all_wallet_features_non_us @intl_non_uk_bank
  Scenario: Deposit: Verify International (non UK Bank) Deposit to GBP Wallet
    When user clicks on GBP wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    Then user should see details of International non UK Bank


  @gbp_crypto @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Crypto Deposit to GBP Wallet
    When user clicks on GBP wallet
    When user clicks on deposit
    And user expend from dropdown
    And user selects crypto deposit
    And user enters sending amount in TBTC
    And user clicks on terms and condition check box
    And user clicks confirm
    Then user should see a summary

  @gbp_m2m @m2m @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "40" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @fp
  Scenario: Payments: Verify Make a FP payment to a New Individual from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for FP
    And user enters amount 6000
    And user checks total debit amount with FP fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum FP fee
    And user selects timing(now)
    And user enter references for FP
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after FP is equal to GBP wallets to available balance


  @sepa
  Scenario: Payments: Verify Make a SEPA payment to a New Individual from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for SEPA
    And user enters amount 6000
    And user checks total debit amount with SEPA fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum SEPA fee
    And user selects timing(now)
    And user enter references for SEPA
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after SEPA is equal to available balance

  @ach
  Scenario: Payments: Verify Make a ACH payment to a New Individual from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for ACH
    And user enters amount 6000
    And user checks total debit amount with ACH fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum ACH fee
    And user selects timing(now)
    And user enter references for ACH
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after ACH payment is equal to available balance

  @wir
  Scenario: Payments: Verify Make a WIR payment to a New Individual from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for WIR
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 50
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR payment is equal to wallet's available balance

  @gbp_make_payment @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to New Business from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on new
    And user enters other recipient details for new business
    And user enters bank details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @gbp_make_payment @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to Existing Business from GBP Wallet
    When user clicks on GBP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on existing
    And user selects existing recipient from recipient details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @gbp_details @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Details Tab Graph of GBP Wallet
    When user clicks on GBP wallet
    Then user should see a graph


  @gbp_statement @gbp_all_features_us @gbp_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Statement Tab of GBP Wallet
    When user clicks on GBP wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded

#+++++++++++++++++++++++++++++++++++++++++++JPY wallet feature++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  @card_deposit_jpy_us @card_deposit_us @jpy_all_features_us @all_wallet_features_us @all_us
  Scenario: Deposit: Verify Card Deposit to JPY Wallet via Stripe
    When user clicks on JPY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "25000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Stripe and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

    #add money in JPY wallet
  @jpy_move @jpy_all_features_non_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify USD Wallet to JPY Wallet Move
    When user clicks on USD wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects JPY wallet
    And enter amount on sending amount box "2000"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    Then transfer successfully completed message should appear


  @jpy_move @move @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify JPY Wallet to GBP Wallet Move(Sender's end)
    When user clicks on JPY wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects GBP wallet
    And enter amount on sending amount box "2000"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @jpy_move @move @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify JPY Wallet to GBP Wallet Move(Receiver's end)
    When user clicks on JPY wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects GBP wallet
    And enter amount on sending amount box "2000"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @jpy_us_bank @jpy_all_features_us @all_wallet_features_us @all_us @localUs
  Scenario: Deposit: Verify Local(US Bank) Deposit to JPY Wallet
    When user clicks on JPY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects local(US Bank)
    Then user should see details of local us bank

  @jpy_uk_bank @jpy_all_features_non_us @all_non_us @all_wallet_features_non_us @all_non_us @all_wallet_features_non_us @localUk
  Scenario: Deposit: Verify Local(UK Bank) Deposit to JPY Wallet
    When user clicks on JPY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    And user expend from dropdown again
    And user selects local(UK Bank)
    Then user should see details of local UK bank

  @jpy_intl_bank @jpy_all_features_non_us @all_non_us @all_wallet_features_non_us @intl_non_uk_bank
  Scenario: Deposit: Verify International (non UK Bank) Deposit to JPY Wallet
    When user clicks on JPY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    Then user should see details of International non UK Bank

  @jpy_crypto @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Crypto Deposit to JPY Wallet
    When user clicks on JPY wallet
    When user clicks on deposit
    And user expend from dropdown
    And user selects crypto deposit
    And user enters sending amount in TBTC
    And user clicks on terms and condition check box
    And user clicks confirm
    Then user should see a summary

  @jpy_m2m @m2m @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "2500" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @jpy_make_payment @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a payment to a New Individual from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @fp
  Scenario: Payments: Verify Make a FP payment to a New Individual from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for FP
    And user enters amount 6000
    And user checks total debit amount with FP fee as per rate
    And user enters amount 300
    And user checks total debit amount with minimum FP fee
    And user selects timing(now)
    And user enter references for FP
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after FP is equal to available balance

  @sepa
  Scenario: Payments: Verify Make a SEPA payment to a New Individual from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for SEPA
    And user enters amount 6000
    And user checks total debit amount with SEPA fee as per rate
    And user enters amount 300
    And user checks total debit amount with minimum SEPA fee
    And user selects timing(now)
    And user enter references for SEPA
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after SEPA is equal to available balance

  @ach
  Scenario: Payments: Verify Make a ACH payment to a New Individual from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for ACH
    And user enters amount 6000
    And user checks total debit amount with ACH fee as per rate
    And user enters amount 300
    And user checks total debit amount with minimum ACH fee
    And user selects timing(now)
    And user enter references for ACH
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after ACH payment is equal to available balance

  @wir
  Scenario: Payments: Verify Make a WIR payment to a New Individual from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for WIR
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 300
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR payment is equal to wallet's available balance

  @jpy_make_payment @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to Existing Business from JPY Wallet
    When user clicks on JPY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on existing
    And user selects existing recipient from recipient details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @jpy_details @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Details Tab Graph of JPY Wallet
    When user clicks on JPY wallet
    Then user should see a graph

  @jpy_statement @jpy_all_features_us @jpy_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Statement Tab of JPY Wallet
    When user clicks on JPY wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded

#+++++++++++++++++++++++++++++++++++++++++++CNY wallet feature++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  @card_deposit_cny_us @card_deposit_us @cny_all_features_us @all_wallet_features_us @all_us
  Scenario: Deposit: Verify Card Deposit to CNY Wallet via Stripe
    When user clicks on CNY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects debit or credit card
    And user enters amount to deposit "15000"
    And user clicks agreement
    And deposit summary should appear
    And clicks confirm
    And enter card details in Stripe and clicks on pay
    And user checks confirmation message and press ok
    Then user should see post transaction balance is equal to available balance

     #add money in CNY wallet
  @cny_move @cny_all_features_non_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify USD Wallet to CNY Wallet Move
    When user clicks on USD wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects CNY wallet
    And enter amount on sending amount box "2000"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    Then transfer successfully completed message should appear

  @cny_move @move @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify CNY Wallet to USD Wallet Move(Sender's end)
    When user clicks on CNY wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "500"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @cny_move @move @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify CNY Wallet to USD Wallet Move(Receiver's end)
    When user clicks on CNY wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "500"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @cny_us_bank @cny_all_features_us @all_wallet_features_us @all_us @localUs
  Scenario: Deposit: Verify Local(US Bank) Deposit to CNY Wallet
    When user clicks on CNY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects local(US Bank)
    Then user should see details of local us bank

  @cny_uk_bank @cny_all_features_non_us @all_non_us @all_wallet_features_non_us @localUk
  Scenario: Deposit: Verify Local(UK Bank) Deposit to CNY Wallet
    When user clicks on CNY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    And user expend from dropdown again
    And user selects local(UK Bank)
    Then user should see details of local UK bank

  @cny_intl_bank @cny_all_features_non_us @all_non_us @all_wallet_features_non_us @intl_non_uk_bank
  Scenario: Deposit: Verify International (non UK Bank) Deposit to CNY Wallet
    When user clicks on CNY wallet
    And user clicks on deposit
    And user expend from dropdown
    And user selects International(non UK Bank)
    Then user should see details of International non UK Bank

  @cny_crypto @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Deposit: Verify Crypto Deposit to CNY Wallet
    When user clicks on CNY wallet
    When user clicks on deposit
    And user expend from dropdown
    And user selects crypto deposit
    And user enters sending amount in TBTC
    And user clicks on terms and condition check box
    And user clicks confirm
    Then user should see a summary

  @cny_m2m @m2m @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "500" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @fp
  Scenario: Payments: Verify Make a FP payment to a New Individual from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for FP
    And user enters amount 6000
    And user checks total debit amount with FP fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum FP fee
    And user selects timing(now)
    And user enter references for FP
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after FP is equal to available balance

  @sepa
  Scenario: Payments: Verify Make a SEPA payment to a New Individual from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for SEPA
    And user enters amount 6000
    And user checks total debit amount with SEPA fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum SEPA fee
    And user selects timing(now)
    And user enter references for SEPA
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after SEPA is equal to available balance

  @ach
  Scenario: Payments: Verify Make a ACH payment to a New Individual from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for ACH
    And user enters amount 6000
    And user checks total debit amount with ACH fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum ACH fee
    And user selects timing(now)
    And user enter references for ACH
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after ACH payment is equal to available balance

  @wir
  Scenario: Payments: Verify Make a WIR payment to a New Individual from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for WIR
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR is equal to CNY wallets available balance

  @cny_make_payment @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to New Business from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on new
    And user enters other recipient details for new business
    And user enters bank details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @cny_make_payment @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Payments: Verify Make a Payment to Existing Business from CNY Wallet
    When user clicks on CNY wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on business
    And user clicks on existing
    And user selects existing recipient from recipient details
    And user enters amount
    And user selects timing(now)
    And user enter references
    And user clicks on pay for payment
    And check request success message and press ok
    Then if payment is complete user should redirect to payments tab

  @cny_details @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Details Tab Graph of CNY Wallet
    When user clicks on CNY wallet
    Then user should see a graph

  @cny_statement @cny_all_features_us @cny_all_features_non_us @all_wallet_features_us @all_us @all_non_us @all_wallet_features_non_us
  Scenario: Verify Statement Tab of CNY Wallet
    When user clicks on CNY wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded

#+++++++++++++++++++++++++++++++++++++++++++PHP wallet feature++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  @php_add_money
  Scenario: Verify USD Wallet to PHP Wallet Move
    When user clicks on USD wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects PHP wallet
    And enter amount on sending amount box "1000"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    Then transfer successfully completed message should appear

  @php_move @php
  Scenario: Verify PHP Wallet to USD Wallet Move(Sender's end)
    When user clicks on PHP wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "1500"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see sender post transaction balance after move is equal to available balance

  @php_move @php
  Scenario: Verify PHP Wallet to USD Wallet Move(Receiver's end)
    When user clicks on PHP wallet
    And user clicks on move tab
    And user clicks on select beneficiary dropdown
    And user selects USD wallet
    And enter amount on sending amount box "1500"
    And move summary should appear
    And user clicks confirm
    And user inputs otp and press confirm button
    And transfer successfully completed message is shown
    And user clicks on ok
    Then user should see receiver post transaction balance after move is equal to available balance

  @php_m2m @php
  Scenario:Payments: Verify Transfer to an Existing Member(m2m) from PHP Wallet
    When user clicks on PHP wallet
    And user clicks payments tab
    And user clicks on transfer to a member pay
    And user selects existing beneficiary
    And user enters sending amount "2000" and payment reference
    And user checks summary of transfer amount
    And clicks confirm button
    And user inputs otp and press confirm button
    And user checks success message
    And press ok
    Then user should redirect to details

  @php_payment  @php
  Scenario: Payments: Verify Make a FP payment to a New Individual from PHP Wallet
    When user clicks on PHP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters wrong bank details for payment
    And user enters amount
    And user selects timing(now)
    And user enter references
    Then pay button should remain disable and error message should be visible below amount box

  @php_payment  @php
  Scenario: Payments: Verify Make a PHP to PHP payment to a New Individual from PHP Wallet
    When user clicks on PHP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for that accepts php payment "PHP"
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR is equal to PHP wallets available balance

  @php_payment @php
  Scenario: Payments: Verify Make a PHP to USD WIR payment to a New Individual from PHP Wallet
    When user clicks on PHP wallet
    And user clicks payments tab
    And clicks on make payment pay button
    And user clicks on individual
    And user clicks on new
    And user enters other recipient details for new individual
    And user enters bank details for that accepts php payment "USD"
    And user enters amount 6000
    And user checks total debit amount with WIR fee as per rate
    And user enters amount 200
    And user checks total debit amount with minimum WIR fee
    And user selects timing(now)
    And user enter references for WIR
    And user clicks on pay for payment
    And check request success message and press ok
    Then user should see sender post transaction balance after WIR payment is equal to wallet's available balance

  @php_details @php
  Scenario: Verify Details Tab Graph of PHP Wallet
    When user clicks on PHP wallet
    Then user should see a graph

  @php_statement @php
  Scenario: Verify Statement Tab of PHP Wallet
    When user clicks on PHP wallet
    And user clicks on statements tab
    And if any statement available user clicks on download button
    Then statement should be downloaded
