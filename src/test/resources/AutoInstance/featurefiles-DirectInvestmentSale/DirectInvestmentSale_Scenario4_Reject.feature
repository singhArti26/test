##########################################################################################3
#Author: Arun
#Written on: 23-Aug-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionDirectInvestmentSaleProcessAuto @RegressionDISScenario4AUTO @RegressionFinal
Feature: Verify that client services team initiates the case for the fund "Ogilvie Midas LLC" - CS L2 reviews & rejects sale agreement and details - later approves the document - and case goes till "Resolved" status

  @Direct_inv_sale_001
  Scenario Outline: CS L1 initiates the case - performs L1 sale of investment review - submits the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on Direct Investment Sale link
    Then the user should land on the "Initiation" screen
    Then the user click on the Fund dropdown and Select the value for fund "<Fund>" in Direct Inv Sale
    Then the user clicks on the Investment list dropdown and select the "<Investment_List>"
    Then upload documents with all supported file types "<upld_wrdFile>" "<upld_excelFile>" "<upld_pptFile>" "<upld_pdfFile>" "<upld_jpgFile>" "<upld_pngFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then the user land on L1 "L1 Sale Of Investment Review" screen
    Then the user clicks on the L1 agreement"<Sale_agreement>"
    Then user selects "<Confirm_decision>" in Details Preparation screen
    Then user enters "<Trnsctn_nme>" client service
    Then the user provide amount "<Amount_to_sell>"
    And select "<Security_Name>" from dropdown
    Then add multiple transaction types "<Transaction_type1>" - "<Amount1>" "<Transaction_type2>" - "<Amount2>" "<Transaction_type3>" - "<Amount3>"
    Then User provides the Trade date and Settlement date from calendar
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 – Sale of Investment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Fund                | Investment_List       | upld_wrdFile                             | upld_excelFile                          | upld_pptFile                               | upld_pdfFile                             | upld_jpgFile                                 | upld_pngFile                           | Sale_agreement | Confirm_decision | Trnsctn_nme      | Amount_to_sell | Transaction_type1                 | Amount1 | Transaction_type2       | Amount2 | Transaction_type3 | Amount3 | Status                       | Action_name                  | Action_By              | Security_Name       |
      | ATClientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | ATOgilvie Midas LLC | Glaswegian Slone Inc. | \\DirectInvestmentResources\\sample.docx | \\DirectInvestmentResources\\Book2.xlsx | \\DirectInvestmentResources\\blankPpt.pptx | \\DirectInvestmentResources\\Invoice.pdf | \\DirectInvestmentResources\\Blank_image.jpg | \\DirectInvestmentResources\\Empty.png | Draft          | Approve          | Transaction name |          15000 | Amortization: Administration Fees |    5000 | Amortization: Insurance |    5000 | Cash: Received    |    5000 | L1 - Sale of Inv. Initiation | L1 Sale Of Investment Review | Client Services 002 AT | Aire Irvine (Units) |

  @Direct_inv_sale_002
  Scenario Outline: CS L2 picks the case submitted by CS L1 - performs L2 sale of investment review - rejects the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 – Sale of Investment Review"
    Then the operator rejects the confirm decision and approves the outcome of review - error validation check "<Intl_cmnts>" "<error_valdtn>"
    Then the operator rejects the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "Client - Sale of Inv. Initiation"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Intl_cmnts | error_valdtn                                                  | Action_name                  | Intl_cmnts | Action_By              |
      | ATClientservices001@alterdomus.com | Welcome@123 | testing    | **The case can not be approved if sale agreement is rejected. | L2 Sale of Investment Review | testing    | Client Services 001 AT |

  @Direct_inv_sale_003
  Scenario Outline: Client picks the case submitted by CS L2 --> upload new sale agreement --> submits case
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should land on the "Initiation" screen
    Then verify the reject reason comments submitted by previous operator is displayed or not "<Intl_cmnts>"
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    Then enter client comments "<Intl_cmnts>"
    And click on Submit button
    Then verify summary page title "Summary - Initiation"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 – Sale of Investment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | invoice file type 2 | Intl_cmnts | upld_wrdFile                             | Document_form | Action_name | Intl_cmnts | Action_By    | Priority_chk |
      | ATClient001@alterdomus.com | Welcome@123 | Invoice 2           | testing    | \\DirectInvestmentResources\\sample.docx | Executed      | Initiation  | testing    | Client001_AT | Priority     |

  @Direct_inv_sale_004
  Scenario Outline: CS L1 picks the case submitted client - do necessary changes - submits the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user land on L1 "L1 Sale Of Investment Review" screen
    Then user selects "<Confirm_decision>" in Details Preparation screen
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 – Sale of Investment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name                  | Intl_cmnts | Action_By              |
      | ATClientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L1 Sale Of Investment Review | testing    | Client Services 002 AT |

  @Direct_inv_sale_005
  Scenario Outline: CS L2 picks the case submitted CS L1 - approves sale Agreement & approves details - submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 – Sale of Investment Review"
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 – Cash Col. and Recon"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name                  | Intl_cmnts | Action_By              |
      | ATClientservices001@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L2 Sale of Investment Review | testing    | Client Services 001 AT |

  @Direct_inv_sale_006
  Scenario Outline: CS L1 picks the case submitted CS L2 for "L1 cash col and recon" - submits case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 – Cash Col. and Recon"
    Then select Yes for Cash collection and reconciliation completed
    Then select Yes for Accounting platform was updated correctly
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 – Cash Col. and Recon. Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name                           | Intl_cmnts | Action_By              |
      | ATClientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L1 Cash Collection And Reconciliation | testing    | Client Services 002 AT |

  @Direct_inv_sale_007
  Scenario Outline: CS L2 picks the case submitted CS L1 for "L2 – Cash Col. and Recon. Review" - Resolves the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 – Cash Col. and Recon. Review"
    Then select Yes for Payment has been received
    Then select Yes for Accounting platform was reviewed
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "Resolved-Completed"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name                                  | Intl_cmnts | Action_By              |
      | ATClientservices001@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L2 Cash Collection And Reconciliation Review | testing    | Client Services 001 AT |
