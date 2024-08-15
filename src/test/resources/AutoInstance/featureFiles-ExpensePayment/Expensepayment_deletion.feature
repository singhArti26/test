##########################################################################################
#Author: Ankita
#Written on: 2nd-June-2023
#Modified by: Arun
#Modified date: 24-Aug-2023
#Team:
#Feature: ExpensePaymentscenario3
##########################################################################################
@RegressionExpensePaymentProcess_Auto @ExpensePaymentBulkFeature3 @RegressionFinal @AutomationIns_ExPay3 @ExpPayment_3AUTO
Feature: Verify that as a client with fund 'Rickwood Handbook Co' where AD is in charge of prepartion and confirm decision as "Delete Invoice" and not routing to Investor registry,Notice Preparation and review and Payments

  @Smoke4500 @Exp_Payment_Del01
  Scenario Outline: Create case in Client1 login
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
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | Fund                    | Payment_package_name | invoice file type 1 | ProcessName     |
      | ATClient001@alterdomus.com | Welcome@123 | ATRickwood Handbook Co. | TestEP1              | Invoice 1           | Expense Payment |

  @Smoke592 @Exp_Payment_Del02
  Scenario Outline: Verify "<Username>" picks the case performs Expense Payment Preparation activity and submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user verifies expected data of "COPP_Operator" is same as actual data "CO PP 01 - L1"
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 expense payment preparation - "L1 Expense Payment Preparation"
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>"
    And the user enters the vendor name in "<Vendor Name>"
    Then User provides the Invoice Date and Payment date from calendar
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>"
    Then the user should be able to provide the Memo as "<Memo>"
    Then the user should be able to click on the "Proposed decision" and select "<ProposedDecision for invoice 1>"
    And the user shuld be to provide the comments as "<Comments for invoice 1>" "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | issuing_account | total_amount | Account_number | r_number | SWIFT_number | Currency | Vendor Name | Memo              | ProposedDecision for invoice 1 | Comments for invoice 1 | Intl_cmnts        |
      | ATCOPP-01-l1@alterdomus.com | Welcome@123 | ABC123          |        77899 |         867676 |      899 |         3344 | USD      | TestUser    | Testcommunication | Delete invoice                 | delete invoice         | internal comments |

  @Smoke592 @Exp_Payment_Del03
  Scenario Outline: Verify that the case is sucessfully moved to CO PP L2 workbasket --> CO PP L2 operator picks up the case sent by CO PP L1 --> makes changes as per CO PP L1 and deletes the Invoice 1
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
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<decision1>"
    And click on Submit button
    And error message is displayed stating "<Warning>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | decision1      | Warning                                    |
      | ATCOPP-01-l2@alterdomus.com | Welcome@123 | Delete invoice | All invoices can't be marked to be deleted |
