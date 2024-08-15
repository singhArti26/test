##########################################################################################################################################################################3
#Author: Gangone Pavan
#Written on: 24-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 5 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusF0F @RegressionFinal1 @FOF_Scenario1_AutomationIns @FOFDisBulk
Feature: Verify that CSL1 or CL2 initiate with cancel request and Reject the cancel request then reslove the case

  @alterDomus_Regression_set1_Tos @cancelrequest @FOF_DisAuto1
  Scenario Outline: Verify that user "<Username>" initiate case with cancel request option with required fields
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
    And the user shall be able to add a Transaction type by clicking on "Add Image"
    And User selects the "<TrantypesName2>" and  enters the amount for transaction "<transAmt>" for second Transaction Details section
    And The user clicks on the "Submit" button
    And User wants to cancel the request "<cancelreqcomments>" for that select "<Crossprocess>" from actions dropdown
    And The user clicks on the "Submit" button
    And wait for success message
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName      | Fund                | transAmt | Distrfund                 | Amtdistributed | Distritype | TrantypesName1   | TrantypesName2                | DocumentPath                 | cancelreqcomments | Crossprocess   | status                           |
      | ATClientServices002@alterdomus.com | Welcome@123 | FOF Distribution | ATOgilvie Midas LLC |    30000 | Foundation Protyping Inc. |          20000 | Cash       | Asset: Inventory | Amortization: Management Fees | \\attachments\\document1.pdf | Auto reject       | Cancel Request | L2 – FoF Distribution Initiation |

  @alterDomus_Regression_set1_Tos @cancelrequest
  Scenario Outline: Verify that user "<Username>" Reject cancelled case by CSL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    #And User selects the pending cancel option from phase-status
    Then the user filters the cancelled case""
    Then the user should land on the "Review Cancel Request Decision" screen
    Then user selects "Reject"
    And User enters Reason for rejection "<Reason>"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                           | Reason                     |
      | ATClientservices001@alterdomus.com | Welcome@123 | L2 – FoF Distribution Initiation | CSL2 enter the reject case |

  @alterDomus_Regression_set1_Tos @cancelrequest
  Scenario Outline: Verify that user "<Username>" assign Priority and Approve case by CSL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User can assign the Priority selected case using the option like "<Crossprocess>" from actions dropdown
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess    | status                         |
      | ATClientservices001@alterdomus.com | Welcome@123 | Assign Priority | L1 – Cash Collection and Recon |

  @alterDomus_Regression_set1_Tos @cancelrequest_1
  Scenario Outline: Verify that user "<Username>" validate review paged and Accounting platform
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    And User should click "Yes" on  frist toggle button "Cash collection and reconciliation completed"
    And User should click "Yes" on  second toggle button "Accounting platform was updated correctly"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | prioritystatus | status                           |
      | ATClientservices002@alterdomus.com | Welcome@123 | Priority       | L2 – Cash Coll. and Recon Review |

  @alterDomus_Regression_set1_Tos @cancelrequest_1
  Scenario Outline: Verify that user "<Username>" reslove case cancelled by CSL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "Reconciliation" page title
    And User should click "Yes" on  frist toggle button "Payment has been received"
    And User should click "Yes" on  second toggle button "Accounting platform was reviewed"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status             |
      | ATClientservices001@alterdomus.com | Welcome@123 | Resolved-Completed |
