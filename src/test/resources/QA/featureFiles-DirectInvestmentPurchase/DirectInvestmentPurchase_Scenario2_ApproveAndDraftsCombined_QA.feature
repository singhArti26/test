##########################################################################################3
#Author: Arun
#Written on: 23-Aug-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionDirectInvestmentPurchaseProcess_QA @RegressionDIPScenario2_QA
Feature: Verify that client services team initiates the case for the fund "Ogilvie Midas LLC" - CS L2 accepts purchase agreement - later approves it and case goes till "Resolved" status

  @Direct_inv_prchseApprve_001_QA
  Scenario Outline: CS L1 initiates the case - performs L1 investment review - submits the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    Then the user click on the Fund dropdown and Select the value for fund "<Fund>" in Direct Inv Sale
    Then the user clicks on the Investment list dropdown and select the "<Investment_List>"
    Then the user provide "<Amount_to_invest>"
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then click "<Document_form>" under agreement section
    And click on Submit button
    Then verify the status change - "L1 - Investment Preparation"
    Then the user clicks on the L1 agreement"<Purchse_agreement>"
    Then user selects "<Confirm_decision>" in Details Preparation screen
    Then user enters "<Trnsctn_nme>" client service
    And select "<Security_Name>" from dropdown
    Then add multiple transaction types "<Transaction_type1>" - "<Amount1>" "<Transaction_type2>" - "<Amount2>" "<Transaction_type3>" - "<Amount3>" - DIP
    Then User provides the Trade date and Settlement date from calendar
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Investment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Document_form | Intl_cmnts | Fund              | Investment_List       | upld_wrdFile                             | Purchse_agreement | Confirm_decision | Trnsctn_nme      | Amount_to_invest | Transaction_type1                 | Amount1 | Transaction_type2       | Amount2 | Transaction_type3 | Amount3 | Status                       | Action_name                         | Action_By           | ProcessName                | Security_Name       |
      | Clientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | Ogilvie Midas LLC | Glaswegian Slone Inc. | \\DirectInvestmentResources\\sample.docx | Draft             | Approve          | Transaction name |            15000 | Amortization: Administration Fees |    5000 | Amortization: Insurance |    5000 | Cash: Received    |    5000 | L1 - Sale of Inv. Initiation | L1 - Investment Details Preparation | Client Services 002 | Direct Investment Purchase | Aire Irvine (Units) |

  @Direct_inv_prchseApprve_002_QA
  Scenario Outline: CS L2 picks the case submitted CS L1 - approves Agreement & approves details - submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Investment Review"
    And wait for loading to get completed
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Liquidity Check"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name            | Intl_cmnts | Action_By           |
      | Clientservices001@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L2 - Investment Review | testing    | Client Services 001 |

  @Direct_inv_prchseApprve_003_QA
  Scenario Outline: CS L1 picks the case submitted CS L2 for "L1 - Liquidity Check" - submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Liquidity Check"
    And wait for loading to get completed
    Then select answer for fund has sufficient liquidity as "<sufficient_liquidity>" ""
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Call Back Preparation"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name        | Intl_cmnts | Action_By           | sufficient_liquidity |
      | Clientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L1 Liquidity Check | testing    | Client Services 002 | Yes                  |

  @Direct_inv_prchseApprve_004_QA
  Scenario Outline: "<Username>" performs L1 - Call Back Preparation as case rejected by COPP L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Call Back Preparation"
    And wait for loading to get completed
    Then click yes on toggle - Are the banking details for this investment present in the banking platform?
    Then provide the reason for banking platform "<Intl_cmnts>" - "<Process>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Call Back Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name        | Action_By           |
      | COPP-01-l1@alterdomus.com | Welcome@123 | testing    | L1 Liquidity Check | Client Services 002 |

  @Direct_inv_prchseApprve_005_QA
  Scenario Outline: "<Username>" performs L2 Call back review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Call Back Review"
    And wait for loading to get completed
    Then the operator accepts the outcome of review
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Payment Preparation"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name        | Action_By           |
      | COPP-01-l2@alterdomus.com | Welcome@123 | testing    | L1 Liquidity Check | Client Services 002 |

  @Direct_inv_prchseApprve_006_QA
  Scenario Outline: "<Username>" performs L1 - Payment Preparation
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Payment Preparation"
    And wait for loading to get completed
    Then select answer "Yes" for question - All the payments above were set up on the banking platform - DIP
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    #And wait for loading to get completed
    And wait for success message
    Then verify the status change - "L2 - Payment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name            | Action_By     |
      | COPP-01-l1@alterdomus.com | Welcome@123 | testing    | L1 Payment Preparation | CO PP 01 - L1 |

  @Direct_inv_prchseApprve_007_QA
  Scenario Outline: "<Username>" performs L2 - Notice Payment Processing activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Payment Review"
    And wait for loading to get completed
    Then select answer "Yes" for question - All the payments above were set up on the banking platform - DIP
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "Client - Payment Release"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name       | Action_By     |
      | COPP-01-l2@alterdomus.com | Welcome@123 | testing    | L2 Payment Review | CO PP 01 - L2 |

  @Direct_inv_prchseApprve_008_QA
  Scenario Outline: "<Username>" performs Payment Review
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the workbasket and click the filtered case ""
    Then verify the status change - "Client - Payment Release"
    And wait for loading to get completed
    Then select answer Yes for the question - All payments were released on the banking platform - DIP
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Payment Reconciliation"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | Supporting document                    | Intl_cmnts | Action_name              | Action_By     |
      | Client001@alterdomus.com | Welcome@123 | Supporting documents - Payment release | testing    | L2 Notice Payment Review | CO PP 01 - L2 |

  @Direct_inv_prchseApprve_009_QA
  Scenario Outline: "<Username>" performs "L1 - Notice Pay. Cash Recon." activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Payment Reconciliation"
    And wait for loading to get completed
    Then select Yes - All the payments were successfully released - DIP
    Then select Yes - The accounting platform has been updated to reflect the payments - DIP
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Payment Recon. Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Action_name       | Intl_cmnts | Action_By           |
      | Clientservices002@alterdomus.com | Welcome@123 | L1 Reconciliation | testing    | Client Services 002 |

  @Direct_inv_prchseApprve_010_QA
  Scenario Outline: "<Username>" performs "L2 - Notice Pay. Recon. Review" activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Payment Recon. Review"
    And wait for loading to get completed
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then verify payment error message - "<Error_message>" - DIP
    Then select Yes - All the payments were successfully released - DIP
    Then select Yes - The accounting platform has been reviewed to reflect the payments - DIP
    And click on Submit button
    And wait for success message
    Then verify the status change - "Client - Executed Doc. Upload"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name              | Action_By           | Error_message                                                        |
      | Clientservices001@alterdomus.com | Welcome@123 | testing    | L2 Reconciliation Review | Client Services 001 | **Please select accounting platform has been reviewed for investment |

  @Direct_inv_prchseApprve_011_QA
  Scenario Outline: Client uploads final "Executed" document and send it for L1 document review
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the workbasket and click the filtered case ""
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    Then enter client comments "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Executed Doc. Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | invoice file type 2 | Intl_cmnts | upld_wrdFile                             | Document_form | Action_name               | Intl_cmnts | Action_By | Priority_chk |
      | Client001@alterdomus.com | Welcome@123 | Invoice 2           | testing    | \\DirectInvestmentResources\\sample.docx | Executed      | Upload Executed Documents | testing    | Client001 | Priority     |

  @Direct_inv_prchseApprve_012_QA
  Scenario Outline: "<Username>" performs "L1 - Notice Pay. Cash Recon." activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Executed Doc. Review"
    And wait for loading to get completed
    Then user selects "<Confirm_decision>" in Details Preparation screen
    And click on Submit button
    And wait for success message
    Then verify the status change - "Resolved-Completed"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Action_By           | Confirm_decision |
      | Clientservices002@alterdomus.com | Welcome@123 | Client Services 002 | Approve          |
