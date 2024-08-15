#########################################################################################################################################################
#Author: Ankita
#Modified By :Arun
#Team:
#Written on: 2nd-June-2023
#Feature: ExpensePaymentscenario1
##########################################################################################################################################################3333
@RegressionExpensePaymentProcess_Auto @ExpensePaymentBulkFeature4 @RegressionFinal @ExpPayment_4AUTO
Feature: Verify that as a client with fund 'Kemp Hickinbottom Co.'where AD in charge of preparation  and proposed decision as "Assign to Client service L1" Allocation file as a package and ReportPro for notice review & sending to Investors and AD Central Ops IS in charge of Investor Registry and Client in charge of payment preparation & release

  @ExpensePaymentScenario4_001 @ExpensePaymentScenario @exp4test
  Scenario Outline: Verify that Client001 creats case for "<Fund>"
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user verifies expected data of "Operator" is same as actual data "Client001"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on "Expense Payment Initiation" exp screen
    Then the user enters name of package "Payment package name" with value "<Payment_package_name>"
    Then the user click on the "Fund" dropdown and Select the value for fund "<Fund>"
    Then upload the "Invoices" and change file type to "<invoice file type 1>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify summary page title "Summary - Initiation"
    And click on Submit button
    And wait for success message
    And capture the "case id"
    And click on refresh from Actions "<Status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | Payment_package_name | Fund                    | Number of invoices | ProcessName     | Status                           |
      | ATClient001@alterdomus.com | Welcome@123 | TestEP1              | ATKemp Hickinbottom Co. |                  1 | Expense Payment | L1 - Expense Payment Preparation |

  @ExpensePaymentScenario4_002 @ExpensePaymentScenario @exp4test
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Preparation activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
   #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the COPP page "L1 Expense Payment Preparation"
    And then user click on the "Currency" dropdown and select the currency "<Currency>"
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>"
    Then the user should be able to provide the total amount as "<total_amount>"
    And the user enters the vendor name in "<Vendor_Name>"
    And the user is able to provide the invoiceNo
    Then User provides the Invoice Date and Payment date from calendar
    Then the user is able to add Account number as "<Account_number>"
    Then the user should be able to provide the routing no ABA routing number as "<r_number>"
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>"
    Then the user should be able to provide the Memo as "<Memo>"
    Then the user should be able to click on the "Proposed decision" and select "<ProposedDecision for invoice 1>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | total_amount | Vendor_Name | Account_number | r_number | SWIFT_number | ProposedDecision for invoice 1 | Currency | issuing_account | Memo     |
      | ATCOPP-01-l1@alterdomus.com | Welcome@123 |        77899 | TestUser    |         867676 |      899 |         3344 | Okay to proceed                | USD      |      7897654545 | TestMemo |

  @ExpensePaymentScenario4_003 @ExpensePaymentScenario
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Preparation activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    And wait for loading to get completed
    #When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 expense payment preparation - "L2 Expense Payment Preparation"
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<Confirm decision>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Confirm decision |
      | ATCOPP-01-l2@alterdomus.com | Welcome@123 | Okay to proceed  |

  @ExpensePaymentScenario4_004 @ExpensePaymentScenario
  Scenario Outline: Verify "<Username>" picks the case performs Liquidity Review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    #When the user clicks on the the workbasket CSL1 "FSNA Client Services L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Liquidity Review - "L1 Liquidity Review"
    Then select answer for fund has sufficient liquidity as "<sufficnt_lquidty>" "selected"
    And click on Submit button
    Then Select Fee type as "<Fee_Type>"
    And enter amount the same as Amount to be paid
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | sufficnt_lquidty | Fee_Type                      |
      | ATClientservices002@alterdomus.com | Welcome@123 | Yes              | Expense: Credit Facility Fees |

  @ExpensePaymentScenario4_005 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Call Back activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Expense Payment Call Back - "L1 Expense Payment Call Back"
    Then select template input as "Edit";
    And enter template name "<templte_name>"
    And enter template bank as "<templte_bank>"
    And enter client representative call name "<rep_name>"
    Then enter call completed time "<compltd_time>"
    And enter no of client representative as "<rep_no>"
    And User should select "<call_success>" for client call successful
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Supporting documents             | templte_name | templte_bank | rep_name | compltd_time      | rep_no     | call_success |
      | ATCOPP-01-l1@alterdomus.com | Welcome@123 | Supporting documents - Call back | test templte | test bank    | abc      | 7/5/2023 10:52 PM | 1234567890 | Yes          |

  @ExpensePaymentScenario4_006 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Call Back Review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page call back review - "L2 Expense Payment Call Back Review"
    Then confirm the decision by clicking on "Approve"
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    |
      | ATCOPP-01-l2@alterdomus.com | Welcome@123 |

  @ExpensePaymentScenario4_007 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Processing activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Expense Payment Processing - "L1 Expense Payment Processing"
    Then select answer "Yes" for question - All the payments above were set up on the banking platform
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    |
      | ATCOPP-01-l1@alterdomus.com | Welcome@123 |

  @ExpensePaymentScenario4_008 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 Expense Payment Processing Review and Release - "L2 Expense Payment Review And Release"
    Then select answer "Yes" for question - L2 "All the payments above were set up on the banking platform"
    Then select "Yes" for - L2 Payment has been released from banking platform
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    |
      | ATCOPP-01-l2@alterdomus.com | Welcome@123 |

  @ExpensePaymentScenario4_009 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Cash Reconciliation activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 cash reconcilation - "L1 Expense Payment Cash Reconciliation"
    Then select answer "Yes" for L1 accounting platform - All the payments above were set up on the banking platform
    Then select "Yes" for L1 payment release - Payment has been released from banking platform
    And click on Submit button
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    |
      | ATClientservices002@alterdomus.com | Welcome@123 |

  @Smoke597 @ExpensePayment_010 @ExpensePaymentScenario4
  Scenario Outline: Verify "<Username>" picks the case performs cash reconcilation review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #When the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 cash reconcilation review - "L2 Expense Payment Cash Reconciliation Review"
    Then select answer "Yes" for L1 accounting platform - All the payments above were set up on the banking platform
    Then select "Yes" for L1 payment release - Payment has been released from banking platform
    And click on Submit button
    And the case is resolved and successful message will appeared on the page "Thank you! The next step in this case has been routed appropriately. "
    Then verify the status change - "Resolved-Completed"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    |
      | ATClientservices001@alterdomus.com | Welcome@123 |
