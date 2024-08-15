##########################################################################################3
#Author: Arun
#Written on: 23-Aug-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionDirectInvestmentSaleProcess_QA @RegressionDISScenario1_QA @RegressionRunQA
Feature: Verify that client services team initiates the case for any random fund by using "Use template" - CS L2 reviews & rejects sale agreement and details

  @Direct_inv_sale_UseTemp_001_QA
  Scenario Outline: CS L1 initiates the case - performs L1 sale of investment review - submits the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on Direct Investment Sale link
    Then the user selects use template option from Actions "<Status>"
    Then the user should land on the "Initiation" screen
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then the user land on L1 "L1 Sale Of Investment Review" screen
    Then the user clicks on the L1 agreement"<Sale_agreement>"
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
      | Username                         | Password    | Document_form | Intl_cmnts | upld_wrdFile                             | Sale_agreement | Confirm_decision | Trnsctn_nme      | Amount_to_sell | Transaction_type1                 | Amount1 | Status                       | Action_name                  | Action_By           |
      | Clientservices002@alterdomus.com | Welcome@123 | Executed      | testing    | \\DirectInvestmentResources\\sample.docx | Draft          | Approve          | Transaction name |          15000 | Amortization: Administration Fees |   15000 | L1 - Sale of Inv. Initiation | L1 Sale Of Investment Review | Client Services 002 |

  @Direct_inv_sale_UseTemp_002_QA
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
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 – Cash Col. and Recon"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                  | Action_By           |
      | Clientservices001@alterdomus.com | Welcome@123 | testing    | L2 Sale of Investment Review | Client Services 001 |
