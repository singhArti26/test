##############################################################################################################################################################################
#Author: Suneel
#Written on: 26-May-2023
#Modified By: Pavan Gangone
#Modified Date: 17-Aug-2023
#Discription:Validate that as a Client service L1 for Ogilvie Midas LLC where Notice File Reject in Client and assign to CS-L1Ccharge of sending and AD Client Services is in charge of Investor Registry
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 12 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusCC @RegressionFinal1 @CapitalCall5_AutoIns
Feature: Validate Capital activity process for fund Ogilvie Midas LLC with case level Rejection

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_1 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" Create process id for the "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "Ogilvie Midas LLC"
    Then the user enters "Transaction name"
    Then the user provides the "<TotalCallAmount>"
    And then click on the "Transaction types" dropdown and select the "Investor Contribution: Expenses" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "Foundation Protyping Inc."
    And the user click on the "Position" dropdown and select the "Aire Irvine (Units)"
    And enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    Then User provides the Notice Date and Due Date from calendar
    And The user clicks on the "Submit" button
    Then the user can check Capital Activity "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName      | Fund                | TotalCallAmount | status                       |
      | ATClientservices002@alterdomus.com | Welcome@123 | Capital Activity | ATOgilvie Midas LLC |           22500 | L2 - Capital Activity Review |

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_1 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve case and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                           |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Allocation File Preparation |

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_3 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client Services L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
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
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | allocationfile                              | status                      |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\allocationfiletemplate1.xlsx | L2 - Allocation File Review |

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_4 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the "L2 Allocation File Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    Then the user clicks on "Approve" toggle button
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | L1 - Notice Preparation |

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_5 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client Services L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the pagetitle "L1 Investor Notice Preparation" page
    Then the user should upload the "<DocumentPath>"
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | DocumentPath                 | status             |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\document2.pdf | L2 - Notice Review |

  @Smoke105_Today_Done @Capital_Call_ScenarioOutline5_6 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L2 Investor Notice Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    Then the user clicks on "Approve" toggle button
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | Client – Package Review |

  @Smoke105_Today_Now @Capital_Call_ScenarioOutline5_7 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" reject and submit the case and Validate the "<status>" by Client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should reject "Notice file"
    Then the user enter reason for rejection
    And the user clicks on the "Submit"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                  |
      | ATClient002@alterdomus.com | Welcome@123 | L1 - Notice Preparation |

  @Smoke105_Today @Capital_Call_ScenarioOutline5_8 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" upload the document again submit case and Validate the "<status>" by Client Services L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the pagetitle "L1 Investor Notice Preparation" page
    Then the user should upload the "<DocumentPath>"
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | DocumentPath                 | status             |
      | ATClientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | L2 - Notice Review |

  @Smoke105_Today @Capital_Call_ScenarioOutline5_9 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" revivew and submit the case and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L2 Investor Notice Review" page and click on "Approve"
    Then the user enters "Internal comments" filed
    And User should click "Yes" on  frist toggle button "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                  |
      | ATClientservices001@alterdomus.com | Welcome@123 | Client – Package Review |

  @Smoke105_Today @Capital_Call_ScenarioOutline5_010 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" approve the allocation file for case and Validate the "<status>" by Client
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
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                   |
      | ATClient001@alterdomus.com | Welcome@123 | L1 - Cash Reconciliation |

  @Smoke105_Today @Capital_Call_ScenarioOutline5_011 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" submit case for Cash Reconciliation and Validate the "<status>" by Client Services L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Cash Reconciliation" screen
    Then user clicks on "Paid in full"
    And the user should click "Yes" on toggle button "Accounting platform has been updated for cash collection"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                   |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Cash Reconciliation |

  @Smoke105_Today @Capital_Call_ScenarioOutline5_012 @CapitalCall_Reg_1 @alterDomus_Regression_Suite_CP
  Scenario Outline: Verify that user "<Username>" land to L2 Cash Reconciliation and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Cash Reconciliation" screen
    And user should click "Yes" on toggle button "All payments have been received"
    And the user should clicks "Yes" on toggle button "Accounting platform has been reviewed for cash collection update"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status             |
      | ATClientservices001@alterdomus.com | Welcome@123 | Resolved-Completed |
