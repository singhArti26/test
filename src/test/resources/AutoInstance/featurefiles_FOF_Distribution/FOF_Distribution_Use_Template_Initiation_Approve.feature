##########################################################################################################################################################################3
#Author: Gangone Pavan
#Written on: 24-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 4 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusF0F @RegressionFinal1 @FOF_Scenario5_AutomationIns @FOFDisBulk
Feature: Verify that CSL1 or CL2 initiate and reslove uing use template for FOF distribution case

  @alterDomus_Regression_set1 @Test123
  Scenario Outline: Verify that user "<Username>" initiate case with Use template option from Actions
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user selects use template option "<crossProsses>"
    Then the user should land on the "Initiation" screen
    Then the user should upload the "<DocumentPath>"
    And User enter mandatory fileds like "<Distrfund>" "<Amtdistributed>" "<Distritype>" in Initiation page
    And User selects the "<TrantypesName1>" and  enters the amount for transaction "<transAmt>" for Transaction Details section
    And The user clicks on the "Submit" button
    And wait for success message
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName      | crossProsses | DocumentPath                 | Distrfund                 | Amtdistributed | Distritype | TrantypesName1   | transAmt | status                           |
      | ATClientServices002@alterdomus.com | Welcome@123 | FOF Distribution | Use Template | \\attachments\\document1.pdf | Foundation Protyping Inc. |          20000 | Cash       | Asset: Inventory |    20000 | L2 – FoF Distribution Initiation |

  @alterDomus_Regression_set1
  Scenario Outline: Verify that user "<Username>" Approve copied case for FOF Distribution with required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                         |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 – Cash Collection and Recon |

  @alterDomus_Regression_set1
  Scenario Outline: Verify that user "<Username>" validate  Review case by CSL1 at cash reconciliation page
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "Reconciliation" page title
    And User should click "Yes" on  frist toggle button "Cash collection and reconciliation completed"
    And User should click "Yes" on  second toggle button "Accounting platform was updated correctly"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                           |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 – Cash Coll. and Recon Review |

  @alterDomus_Regression_set1
  Scenario Outline: Verify that user "<Username>" validate that reslove case for use template
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
