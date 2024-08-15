##########################################################################################3
#Author: Arun
#Written on: 23-Aug-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionDirectInvestmentSaleProcessAuto @RegressionDISScenario2AUTO @RegressionFinal
Feature: Verify that client services team initiates the case using random fund(use template) - submits "cancel request" - L2 approves the cancel request

  @DirectInvSale_cancel_001
  Scenario Outline: CS L1 initiates the case - performs L1 sale of investment review - submits the case requesting cancellation review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on Direct Investment Sale link
    Then the user selects use template option from Actions "<Status_Temp>"
    Then the user should land on the "Initiation" screen
    Then upload documents with one supported file type "<upld_wrdFile>"
    And the user should clicks on the Submit button in upload popup
    Then click "<Document_form>" under agreement section
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then User cancels the request "<Cancel_Rsn>"
    And click on Submit button
    And wait for success message
    Then verify the status "L1 – Sale of Investment Review"
    And capture the "case id"
    Then validate the comments section "<Action_name>" "<Cancel_Rsn>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Banking_details_provided | Document_form | Intl_cmnts | upld_wrdFile                             | Status_Temp                  | Cancel_Rsn | Action_name           | Action_By              |
      | ATClientservices002@alterdomus.com | Welcome@123 | Yes                      | Executed      | testing    | \\DirectInvestmentResources\\sample.docx | L1 - Sale of Inv. Initiation | invalid    | Initiate Cancellation | Client Services 002 AT |

  @DirectInvSale_cancel_002
  Scenario Outline: CS L2 accepts the cancellation request sent by CS L1 --> Case status changes to "<Status_Cancel>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user filters the cancelled case""
    Then operator approves the cancel request "<Cancel_Rsn>" "<Status_Cancel>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Banking_details_provided | Document_form | Intl_cmnts | upld_wrdFile                             | Status_Temp                  | Status_Cancel      | Cancel_Rsn | Action_name                    | Action_By              |
      | ATClientservices001@alterdomus.com | Welcome@123 | Yes                      | Executed      | testing    | \\DirectInvestmentResources\\sample.docx | L1 - Sale of Inv. Initiation | Resolved-Cancelled | invalid    | Review Cancel Request Decision | Client Services 001 AT |
