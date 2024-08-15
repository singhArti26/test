############################################################################################################################################################
#Author: Suneel
#Written on: 22-May-2023
#Modified By: Pavan Gangone
#Modified Date: 17-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS - || Total automated TC's - 14. ||Sanity Suite TC's-1|Time Taking for execution:
####################################################################################################################################################################
@Reg_Areteans__AlterDomusCC @RegressionFinal1 @CapitalCall2_AutoIns
Feature: Verify that as a Client for Kemp Hickinbottom Co. for Review Intake-Reject and assign to Client where AD in charge of preparation and client in charge of sending as well as AD Central Ops IS in charge of Investor Registry

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_1 @alterDomus_Regression_Suite_CP @cap
  Scenario Outline: Verify that user "<Username>" initiate a case with the "<Fund>" and other required fields
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    #Then the user verifies expected data of "Operator" is same as actual data "Client001"
    #Then the user clicks on "PortalNavHeader"
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then the user enters "Transaction name"
    Then the user clicks on "Percentage" under "Capital Call"
    Then the user enters percentage under "<Percentagetobecalled>"
    Then the user enters "<Comments>" on Initiation Page
    Then User provides the Notice Date and Due Date from calendar
    And the user clicks on the "Submit"
    And the user clicks on the "Submit"
    And wait for success message
    Then the user can get the "Case ID"
    #Then the user can check Capital Activity "Case ID"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | ProcessName      | Fund                    | status                           | Percentagetobecalled | Comments           |
      | ATClient002@alterdomus.com | Welcome@123 | Capital Activity | ATKemp Hickinbottom Co. | L1 - Capital Activity Enrichment |                 0.01 | Automation Testing |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_2 @alterDomus_Regression_Suite_CP @cap
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    #Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And then click on the "Transaction types" dropdown and select the "Investor Contribution: Management Fees" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "<Dealname>"
    And the user click on the "Position" dropdown and select the "<Position>"
    And the user should enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    And the user clicks on the "Submit" button
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | TrantypesName1          | transAmt | Dealname           | Position                  | status                       |
      | ATClientservices002@alterdomus.com | Welcome@123 | Amortization: Insurance |    30000 | Brunswick Less Co. | Andreas Nephew (Series Z) | L2 - Capital Activity Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_3 @alterDomus_Regression_Suite_CP @cap
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Reject" in "Review of intake"
    Then the user clicks on "Client" in "Assign review of the intake to?" filed
    And User enters Reason for rejection "<Reason>"
    And The user clicks on the "Submit" button
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Reason  | status                           |
      | ATClientservices001@alterdomus.com | Welcome@123 | Testing | Client - Cap Activity Initiation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_4 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should land on the "Initiation" screen
    And the user clicks on the "Submit"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                      |
      | ATClient002@alterdomus.com | Welcome@123 | L1- Capital Activity Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_5 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                       |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Capital Activity Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_6 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                           |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Allocation File Preparation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_7 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by COIS L1.
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L1" workbasket
    #Then the user click on "FSNA:COISL1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on "Investor Registry Confirmation" screen pagetitle
    And the user click "Yes" on toggle button "The investor registry of this fund is up to date"
    Then the user should upload the "<DocumentPath>"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | DocumentPath                 | status                           |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | L1 - Allocation File Preparation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_8 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L1 Allocation File Preparation" page
    Then the user should upload the "<allocationfile>"
    Then the user should click on "Investor List"
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | allocationfile                                               | status                      |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\allocationfiletemplate_Kemp_Hickinbottom.xlsx | L2 - Allocation File Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_9 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the "L2 Allocation File Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    Then the user clicks on "Approve" toggle button
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Notice Preparation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_10 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the pagetitle "L1 Investor Notice Preparation" page
    Then the user should upload the "<DocumentPath>"
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | DocumentPath                 | status             |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | L2 - Notice Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_11 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L2 Investor Notice Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    Then the user clicks on "Approve" toggle button
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | Client – Package Review |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_12 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by Client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should approve "Allocation file" and "Notices"
    And user should click "Yes" on the toggle button "All investor notices have been distributed to the relevant parties"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                   |
      | ATClient002@alterdomus.com | Welcome@123 | L1 - Cash Reconciliation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_13 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L1 Cash Reconciliation" page title
    Then user clicks on "Paid in full"
    And User should click "Yes" on  second toggle button "Accounting platform has been updated for cash collection"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                   |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Cash Reconciliation |

  @alterDomus_Capital_call_Reg_Today25 @CP_Reg_14 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #hen the user select the captured case id from the Process Id and click the filtered case
    Then the user should display "L2 Cash Reconciliation" page
    And user should click "Yes" on toggle button "All payments have been received"
    And the user should clicks "Yes" on toggle button "Accounting platform has been reviewed for cash collection update"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status             |
      | ATClientservices001@alterdomus.com | Welcome@123 | Resolved-Completed |
