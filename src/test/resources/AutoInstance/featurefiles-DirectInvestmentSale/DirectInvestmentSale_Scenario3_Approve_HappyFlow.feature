##########################################################################################3
#Author: Arun
#Written on: 31-Aug-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionDirectInvestmentSaleProcessAuto @RegressionDISScenario3 @RegressionFinal @RegressionDISScenario3AUTO
Feature: Verify that client services team initiates the case for the fund "<Fund>" - CS L2 reviews & approves sale agreement and details - later case goes till "Resolved" status

  @Direct_inv_sale_Approve_001
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
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then the user land on L1 "L1 Sale Of Investment Review" screen
    Then verify if Sale agreement is in Executed state
    Then user selects "<Confirm_decision>" in Details Preparation screen
    Then user enters "<Trnsctn_nme>" client service
    Then the user provide amount "<Amount_to_sell>"
    Then add single transaction type "<Transaction_type1>" - "<Amount1>"
    Then User provides the Trade date and Settlement date from calendar
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 – Sale of Investment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button
    
    Examples: 
      | Username                           | Password    | Document_form | Intl_cmnts | Fund                    | Investment_List        | upld_wrdFile                             | Confirmdecision | Trnsctn_nme      | Amount_to_sell | Transaction_type1                 | Amount1 | Status                       | Action_name                  | Action_By              |
      | ATClientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | ATRickwood Handbook Co. | Journal Greenworld LLC | \\DirectInvestmentResources\\sample.docx | Approve         | Transaction name |           5000 | Amortization: Administration Fees |    5000 | L1 - Sale of Inv. Initiation | L1 Sale Of Investment Review | Client Services 002 AT |

  @Direct_inv_sale_Approve_002
  Scenario Outline: CS L2 picks the case submitted by CS L1 - performs L2 sale of investment review - approves the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user assigns priority
    Then verify the status change - "L2 – Sale of Investment Review"
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 – Cash Col. and Recon"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button
    
    Examples: 
      | Username                           | Password    | Intl_cmnts | Action_name                  | Intl_cmnts | Action_By              |
      | ATClientservices001@alterdomus.com | Welcome@123 | testing    | L2 Sale of Investment Review | testing    | Client Services 001 AT |

  @Direct_inv_sale_Approve_003
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
      | Username                           | Password    | Document_form | Intl_cmnts | Confirm_decision | Action_name                           | Intl_cmnts | Action_By              | Priority_chk |
      | ATClientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | Approve          | L1 Cash Collection And Reconciliation | testing    | Client Services 002 AT | Priority     |

  @Direct_inv_sale_Approve_004
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
