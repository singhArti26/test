##########################################################################################3
#Author: Ankita
#Modified by: Arun
#Team:
#Written on: 2nd-June-2023
#Feature: ExpensePaymentscenario1
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@ExpensePaymentBulkFeature1 @RegressionFinal @AutomationIns_ExPay1 @RegressionExpensePaymentProcess_QA @RegressionRunQA
Feature: Verify that as a client with fund 'Rickwood Handbook Co' where client is in charge of prepartion and confirm decision as "OK to proceed" and client in charge of sending notices,review with Client service L1 and AD central ops PP  in charge of payment preparation

  @ExpensePayment_001QA
  Scenario Outline: Verify that case id should be created sucessfully for selected "<Fund>" of Expense Payment with Client1 login and "Are any invoices paid by more than one fund?" marked as "No" by default
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user verifies expected data of "Operator" is same as actual data "Client001"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon for client
    Then the user should click on process name "<ProcessName>"
    Then the user should land on "Expense Payment Initiation" exp screen
    Then the user enters name of package "Payment package name" with value "<Payment_package_name>"
    Then the user enters the "<Number of invoices>" that needs to be attached
    Then the user click on the "Fund" dropdown and Select the value for fund "<Fund>"
    Then upload the "Invoices" and change file type to "<invoice file type 1>" "<invoice file type 2>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify summary page title "Summary - Initiation"
    And click on Submit button
    And wait for success message
    And capture the "case id"
    And click on refresh from Actions "<Status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | Fund                    | Payment_package_name | Number of invoices | invoice file type 1 | invoice file type 2 | Status                           | ProcessName     |
      | Client001@alterdomus.com | Welcome@123 | ATRickwood Handbook Co. | TestEP1              |                  2 | Invoice 1           | Invoice 2           | L1 - Expense Payment Preparation | Expense Payment |

  @ExpensePayment_002 @ExpensePayment_001 @trialProcessId
  Scenario Outline: Verify that case is sucessfully moved to CO PP L1 workbasket --> CO PP L1 operator picks the case created by client --> deletes first invoice and for second invoice,chooses proposed decision as "assign to client" and submits case to
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 expense payment preparation - "L1 Expense Payment Preparation"
    And then user click on the "Currency" dropdown and select the currency "<Currency>"
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>"
    Then the user should be able to provide the total amount as "<total_amount>"
    And the user enters the vendor name in "<Vendor Name>"
    And the user is able to provide the invoiceNo
    Then User provides the Invoice Date and Payment date from calendar
    Then the user is able to add Account number as "<Account_number>"
    Then the user should be able to provide the routing no ABA routing number as "<r_number>"
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>"
    Then the user should be able to provide the Memo as "<Memo>"
    Then the user should be able to click on the "Proposed decision" and select "<ProposedDecision for invoice 1>"
    And the user shuld be to provide the comments as "<Comments for invoice 1>" "<Intl_cmnts>"
    Then the user should able to click on "Invoice 2" header
    And then user click on the "Currency" dropdown and select the currency "<Currency>" for Invoice two
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>" Invoice Two
    Then the user should be able to provide the total amount as "<total_amount>" for Invoice two
    And the user enters the vendor name in "<Vendor Name>" for Invoice Two
    And the user is able to provide the invoiceNo for Invoice Two
    And the user should be able to provide the Invoice date and payment date for Invoice Two
    Then the user is able to add Account number as "<Account_number>" for Invoice Two
    Then the user should be able to provide the routing no ABA routing number as "<r_number>" for Invoice Two
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>" for Invoice Two
    Then the user should be able to provide the Memo as "Test Communication" for Invoice Two
    Then the user should be able to click on the  "Proposed decision" and select "<ProposedDecision for invoice 2>" for Invoice Two
    And the user shuld be to provide the comments as "<Comments for invoice 2>" for Invoice Two
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | issuing_account | total_amount | Account_number | r_number | SWIFT_number | Currency | Vendor Name | Memo              | ProposedDecision for invoice 1 | ProposedDecision for invoice 2 | Comments for invoice 1 | Comments for invoice 2 | Intl_cmnts        |
      | COPP-01-l1@alterdomus.com | Welcome@123 | ABC123          |        77899 |         867676 |      899 |         3344 | USD      | TestUser    | Testcommunication | Delete invoice                 | Assign to client               | delete invoice         | Assign to client       | internal comments |

  @ExpensePayment_003
  Scenario Outline: Verify that the case is sucessfully moved to CO PP L2 workbasket --> CO PP L2 operator picks up the case sent by CO PP L1 --> makes changes as per CO PP L1 and submits case back to cient
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
    Then the user should able to click on "Invoice 2" header
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<decision2>" for Invoice Two
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | decision1      | decision2        |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Delete invoice | Assign to client |

  @ExpensePayment_004
  Scenario Outline: Verify that the case is sucessfully moved to client workbasket --> client uploads pdf document for second invoice as requested by CO PP and submits the case
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should land on expense payment initiation "Expense Payment Initiation" screen
    Then upload the "Invoices" and change file type to "<invoice file type 2>" client
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify page title "Expense Payment Initiation"
    And click on Submit button
    And wait for success message
    And click on refresh from Actions "<Status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | invoice file type 2 | Status                           |
      | Client001@alterdomus.com | Welcome@123 | Invoice 2           | L1 - Expense Payment Preparation |

  @ExpensePayment_005
  Scenario Outline: Verify that the case is in CO PP L1 work list --> operator picks up the updated case submitted by client --> reviews it and submits it to CO PP L2 for review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 expense payment preparation - "L1 Expense Payment Preparation"
    And the user enters the vendor name in "<Vendor Name>"
    Then the user should be able to click on the "Proposed decision" and select "<Proposed decision>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Vendor Name | Proposed decision |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Test002     | Okay to proceed   |

  @ExpensePayment_006
  Scenario Outline: Verify that the case is in CO PP L2 work list --> operator picks up the updated case submitted by CO PP L1 --> reviews it and submits case to COPP-L1 for L1 Expense Payment Call Back and FSNA Client Services L1 for L1 Liquidity Review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 expense payment preparation - "L2 Expense Payment Preparation"
    Then the user should be able to click on the dropDown to "Confirm decision" and select "<Confirm decision>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Confirm decision |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Okay to proceed  |

  @ExpensePayment_007
  Scenario Outline: Verify that the case is in Client Services L1 workbasket --> operator picks up the case submitted by CO PP L2 -->  works on liquidity review --> submits case to CO PP L1 for "Expense Payment Call Back"
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
    Then Select Fee type as "<Fee_type>"
    And enter amount the same as Amount to be paid ""
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Fee_type                      | sufficnt_lquidty |
      | Clientservices002@alterdomus.com | Welcome@123 | Expense: Credit Facility Fees | Yes              |

  @ExpensePayment_008
  Scenario Outline: Verify that the case is in CO PP L1 "work list" --> CO PP L1 operator performs a call back for any vendors with new or updated banking information --> submits case to COPP-02 for Expense Payment Call Back review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Expense Payment Call Back - "L1 Expense Payment Call Back"
    Then select template input as "Edit";
    And enter template name "<template_name>"
    And enter template bank as "<template_bank>"
    And enter client representative call name "<representative>"
    Then enter call completed time "<call completed time>"
    And enter no of client representative as "<representative_no>"
    And User should select "Yes" for client call successful
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Supporting documents             | template_name | template_bank | representative | call completed time | representative_no |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Supporting documents - Call back | template name | template bank | abc            | 9/8/2023 10:52 PM   |        1234567890 |

  @ExpensePayment_009
  Scenario Outline: Verify that the case is in CO PP L2 "work list" --> CO PP L2 operator performs "Expense Payment Call Back review" --> submits case to CO PP L1 for "Payment processing"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page call back review - "L2 Expense Payment Call Back Review"
    Then confirm the decision by clicking on "Approve"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l2@alterdomus.com | Welcome@123 |

  @ExpensePayment_010
  Scenario Outline: Verify that the case is in CO PP L2 "work list" --> CO PP L1 performs "payment processing" activity --> sends the case to CO PP L2 for review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L1 Expense Payment Processing - "L1 Expense Payment Processing"
    Then select answer "Yes" for question - All the payments above were set up on the banking platform
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l1@alterdomus.com | Welcome@123 |

  @ExpensePayment_011
  Scenario Outline: Verify that the case is in CO PP L2 "work list" --> CO PP L2 performs L2 Expense Payment Review and Release --> submits the case to FSNA: Client
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page L2 Expense Payment Processing Review - "L2 Expense Payment Processing Review"
    Then select answer "Yes" for the question - All the payments above were set up on the banking platform
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Reason  |
      | COPP-01-l2@alterdomus.com | Welcome@123 | testing |

  @ExpensePayment_012
  Scenario Outline: Verify that the case is sucessfully moved to client workbasket --> client uploads pdf document as supporting document and submits the case to "Client Services" for "L1 Expense Payment Cash Reconciliation"
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user is able to land on the page client expense payment review - "Expense Payment Review And Release"
    Then upload the "Supporting document" and change file type to "<Supporting document>"
    And click on Submit button
    Then select answer "Yes" for the question - All the payments above were set up on the banking platform
    And click on Submit button
    And wait for success message
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | Supporting document                    |
      | Client001@alterdomus.com | Welcome@123 | Supporting documents - Payment release |

  @Smoke2000 @ExpensePayment_013
  Scenario Outline: Verify that the case is in CO PP L1 "work list" --> CO PP L1 reviews the case --> submit the case to L2 review for "Cash review and reconciliation"
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
      | Username                         | Password    |
      | Clientservices002@alterdomus.com | Welcome@123 |

  @Smoke597 @ExpensePayment_014
  Scenario Outline: Verify that the case is in CO PP L2 "work basket" --> CO PP L2 reviews and submits case --> case is changed to "Resolved-Completed"
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
    And wait for success message
    Then verify the status change - "Resolved-Completed"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | Clientservices001@alterdomus.com | Welcome@123 |
