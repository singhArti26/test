##########################################################################################################################################################################3
#Author: Suneel
#Written on: 22-May-2023
#Modified By: Pavan Gangone
#Modified Date: 17-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusCC @RegressionFinal1 @CapitalCall1_AutoIns1
Feature: Verify that Capital actvity process should be initiated by CSL1 and Resloved-completd by CSL2, CS is in charge of registry, AD in charge of preparation & client in charge of sending,

  @alterDomus_Capital_call_Reg_123410 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" initiate a case with the "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then the user enters "<Transactionname>"
    Then the user provides the "<TotalCallAmount>"
    And then click on the "Transaction types" dropdown and select the "Investor Contribution: Expenses" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "Foundation Protyping Inc."
    #And the user click on the "Position" dropdown and select the "Unallocated"
    And enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    Then User provides the Notice Date and Due Date from calendar
    And The user clicks on the "Submit" button
    And wait for success message
    Then the user can get the "Case ID"
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName      | Fund                | Transactionname | TotalCallAmount | status                       |
      | ATClientservices002@alterdomus.com | Welcome@123 | Capital Activity | ATOgilvie Midas LLC | AutoTesing      |           30000 | L2 - Capital Activity Review |

  @alterDomus_Capital_call_Reg_123456 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation Review" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                           |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Allocation File Preparation |

  @alterDomus_Capital_call_Reg_123456 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" validate the "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L1 Allocation File Preparation" page
    Then the user should upload the "<allocationfile>"
    Then the user should click on "Investor List"
    And the user should click "Yes" on the toggle button "The investor registry of this fund is up to date"
    Then the user can upload Documents
    Then the user clicks on "Submit" button on the internal window
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                      | allocationfile                                |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Allocation File Review | \\attachments\\allocationfiletemplate30k.xlsx |

  @alterDomus_Capital_call_Reg_123456 @alterDomus_Regression_Suite_CP
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
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Notice Preparation |

  @alterDomus_Capital_call_Reg_123456 @alterDomus_Regression_Suite_CP
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
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | DocumentPath                 | status             |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\document2.pdf | L2 - Notice Review |

  @alterDomus_Capital_call_Reg_1234567 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L2 Investor Notice Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    And User should click "Yes" on  frist toggle button "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | Client – Package Review |

  @alterDomus_Capital_call_Reg_1234567 @alterDomus_Regression_Suite_CP @singleRun
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L1
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
    And the user should able to see case status as "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                   |
      | ATClient001@alterdomus.com | Welcome@123 | L1 - Cash Reconciliation |

  @alterDomus_Capital_call_Reg_1234567 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L1 Cash Reconciliation" page title
    Then user clicks on "Paid in full"
    And the user should click "Yes" on toggle button "Accounting platform has been updated for cash collection"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                   |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Cash Reconciliation |

  @alterDomus_Capital_call_Reg_1234567 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
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
