##########################################################################################
#Author: Ankita
#Written on: 2nd-June-2023
#Modified by: Arun
#Modified date: 24-Aug-2023
#Team:
#Feature: ExpensePaymentscenario2
##########################################################################################
@RegressionExpensePaymentProcess_Auto @ExpensePaymentBulkFeature2 @RegressionFinal @AutomationIns_ExPay2 @ExpPayment_2AUTO
Feature: Verify that as a client with fund 'Fathoms Artisan L.P.'where AD in charge of preparation & sending and proposed decision as "Assign to Client service L1", Allocation file as a package and ReportPro is No Adoption and AD Client Services in charge of Investor Registry and Client in charge of payment preparation & release

  @ExpnsePayment01
  Scenario Outline: Verify that case id should be created sucessfully for selected "<Fund>" of Expense Payment with Client1 login and "Are any invoices paid by more than one fund?" marked as "Yes"
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user verifies expected data of "Operator" is same as actual data "Client001"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on expense payment initiation "Expense Payment Initiation" screen
    Then the user enters name of package "Payment package name" with value "<Payment_package_name>"
    And Select answer "<question_more_than_one_fund>" for question Are any invoices paid by more than one fund
    Then the user click on the "Fund" dropdown and Select the value for fund "<Fund>"
    Then upload the "Invoice" and change file type to "<invoice file type 1>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify summary page title "Summary - Initiation"
    And click on Submit button
    And the "successful message" should get displayed after the "Submit" button clicked.
    And capture the "case id"
    And click on refresh from Actions "<Status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | Payment_package_name | question_more_than_one_fund | Numbr_of_invoices | Fund                   | invoice file type 1 | ProcessName     | Status                           |
      | ATClient001@alterdomus.com | Welcome@123 | TestEP1              | Yes                         |                 1 | ATFathoms Artisan L.P. | Invoice 1           | Expense Payment | L1 - Expense Payment Preparation |

  @ExpnsePayment02 @testExpP2
  Scenario Outline: Verify that case is routed to client services L1 workbasket --> CS L1 reviews the case --> routes case to CS L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    #When the user clicks on the the workbasket CSL1 "FSNA Client Services L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 expense payment preparation - "L1 Expense Payment Preparation"
    #Add code to check that issuing account should not appear mandatory
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>"
    And Select Fee Type as "<Fee_type>"
    And the user should be able to provide the Amount To Be Paid
    And the user should be able to provide the "<Vendor_Name>"
    Then User provides the Invoice Date and Payment date from calendar
    Then the user should be able to provide the routing no ABA routing number
    Then the user should be able to provide the SWIFT number
    Then the user should be able to provide the Memo as "<Memo>"
    Then the user should be able to click on the "Proposed decision" and select "<ProposedDecision for invoice 1>"
    And the user should provide the intlComments as "<comments>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | issuing_account | Fee_type          | Vendor_Name | Memo               | ProposedDecision for invoice 1 | comments        |
      | ATClientservices016@alterdomus.com | Welcome@123 | 123566263457235 | Expense: Dividend | TestUser    | Test Communication | Okay to proceed                | Okay to process |

  @ExpnsePayment03
  Scenario Outline: Verify that case is routed to client services L2 workbasket --> CS L2 reviews the case --> assigns case back to CS L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #When the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 expense payment preparation - "L2 Expense Payment Preparation"
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<ConfirmDecision>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ConfirmDecision |
      | ATClientservices015@alterdomus.com | Welcome@123 | Assign to L1    |

  @ExpnsePayment04
  Scenario Outline: Verify that case is routed to client services L1 worklist --> CS L1' reviews the case --> assigns case back to CS L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 expense payment preparation - "L1 Expense Payment Preparation"
    Then the user should be able to click on the "Proposed decision" and select "<ProposedDecision for invoice 1>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProposedDecision for invoice 1 |
      | ATClientservices016@alterdomus.com | Welcome@123 | Okay to proceed                |

  @ExpnsePayment05
  Scenario Outline: Verify CS L2 picks the case performs Expense Payment Preparation activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 expense payment preparation - "L2 Expense Payment Preparation"
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<Decicion>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Decicion        |
      | ATClientservices015@alterdomus.com | Welcome@123 | Okay to proceed |

  @ExpnsePayment06
  Scenario Outline: Verify CS L1 picks the case performs L1 Liquidity Review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Liquidity Review - "L1 Liquidity Review"
    Then select answer for fund has sufficient liquidity as "<sufficient_liquidity>" "<liquidity_resolution>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | sufficient_liquidity | liquidity_resolution |
      | ATClientservices016@alterdomus.com | Welcome@123 | No                   | Leverage credit line |

  @ExpnsePayment07
  Scenario Outline: Verify client picks the case performs payment review activity and submits case
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user is able to land on the page client expense payment review - "Expense Payment Review And Release"
    Then select answer "Yes" for - All the payments were released on the banking platform
    And click on Submit button
    And wait for success message
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    |
      | ATClient001@alterdomus.com | Welcome@123 |

  @ExpnsePayment08
  Scenario Outline: Verify "<Username>" picks the case performs cash reconcilation activity and submits case
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
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    |
      | ATClientservices016@alterdomus.com | Welcome@123 |

  @ExpnsePayment09
  Scenario Outline: Verify "<Username>" picks the case performs cash reconcilation review activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 cash reconcilation review - "L2 Expense Payment Cash Reconciliation Review"
    Then select answer "Yes" for L1 accounting platform - All the payments above were set up on the banking platform
    Then select "Yes" for L1 payment release - Payment has been released from banking platform
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    |
      | ATClientservices015@alterdomus.com | Welcome@123 |
