##########################################################################################################################################################################3
#Author: Gangone Pavan
#Written on: 24-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 2 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusF0F_QA @RegressionRunQA
Feature: Verify that CSL1 or CL2 initiate and cancel the FOF distribution case by CSL2

  @alterDomus_Regression_set1_QA
  Scenario Outline: Verify that user "<Username>" initiate case with required fields and cancel the case using Cancel Request
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then User provides the Due Date from calendar
    Then the user enters "Transaction name"
    Then the user should upload the "<DocumentPath>"
    And User enter mandatory fileds like "<Distrfund>" "<Amtdistributed>" "<Distritype>" in Initiation page
    And User selects the "<TrantypesName1>" and  enters the amount for transaction "<transAmt>" for Transaction Details section
    And The user clicks on the "Submit" button
    And User wants to cancel the request "<cancelreqcomments>" for that select "<Crossprocess>" from actions dropdown
    And The user clicks on the "Submit" button
    And wait for success message
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | ProcessName      | Fund                | transAmt | Distrfund                 | Amtdistributed | Distritype | TrantypesName1          | TrantypesName2                | DocumentPath                 | Crossprocess   | cancelreqcomments | status                           |
      | ClientServices002@alterdomus.com | Welcome@123 | FOF Distribution | ATOgilvie Midas LLC |    30000 | Foundation Protyping Inc. |          20000 | Cash       | Amortization: Insurance | Amortization: Management Fees | \\attachments\\document1.pdf | Cancel Request | Auto cancel       | L2 – FoF Distribution Initiation |

  @alterDomus_Regression_set1_QA
  Scenario Outline: Verify that user "<Username>" approve pending cancelled case and status for FOF by CSL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user filters the cancelled case""
    Then the user should land on the "Review Cancel Request Decision" screen
    #And User selects the pending cancel option from phase-status
    #Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status             |
      | Clientservices001@alterdomus.com | Welcome@123 | Resolved-Cancelled |
