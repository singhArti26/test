##############################################################################################################
#Author: Pavan
#Written on: 14-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 3 ||Sanity Suite TC's-1|Time Taking for execution:
#TRA-51005
#############################################################################################################
@Reg_Areteans__AlterDomusTT @RegressionFinal1 @7117 @feature4TransferAUTO
Feature: Verify that as a COIS create a process using the Use template and Transfer the case to next level cross funcnality

  @Tansfer_CSL1_initiate_7117 @Reg_7117_1Auto
  Scenario Outline: Verify that user "<Username>" initiate a Transfer case for "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then enter the transaction name as "<transaction_name>"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then User provides the Transfer effective date from calendar
    Then User provides the Target date from calendar
    Then the user should upload the "<DocumentPath>"
    Then the user should upload the second document "<DocumentPath1>"
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And The user clicks on the "Submit" button
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName | Fund                  | transaction_name   | Funddisbankacc | Internalcomments  | Externalcomments | DocumentPath                 | DocumentPath1                | status          |
      | ATClientservices002@alterdomus.com | Welcome@123 | Transfer    | ATVirji Powerware LLC | Automation Testing |     7897654545 | initiated by CSL1 | By CSL1          | \\attachments\\document1.pdf | \\attachments\\document2.pdf | L2 - Initiation |

  @Tansfer_CSL1_initiate_7117 @Reg_7117_2
  Scenario Outline: Verify that user "<Username>" transfer the case to "<otherCSL2>" for FOF Distribution with required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User wants to transfer the case to "<otherCSL2>" for that select "<Crossprocess>" from actions dropdown
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | otherCSL2                          | Password    | Crossprocess        | status          |
      | ATClientservices001@alterdomus.com | ATClientServices005@alterdomus.com | Welcome@123 | Transfer Assignment | L2 - Initiation |

  @Tansfer_CSL1_initiate_7117 @Reg_7117_3
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    Then user selects "Approve2"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then user selects "Approve3"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on  second toggle button "External comments"
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Reason               | Internalcomments | Externalcomments | status                      |
      | ATClientServices005@alterdomus.com | Welcome@123 | case level rejection | By CSL2          | By CSL2          | L1 - AML/KYC Comfort Letter |

  @TansferCOIS_Use_Template @7115_1
  Scenario Outline: Verify that user "<Username>" initiate a Transfer case for "<Fund>" and other required fields
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    #Cross functionality: Use Template
    Then the user selects use template option "<crossProsses>"
    Then User provides the Transfer effective date from calendar
    Then the user should upload the "<DocumentPath>"
    Then the user should upload the second document "<DocumentPath1>"
    Then User validates the following message displaying or not based effective date
    And The user clicks on the "Submit" button
    And The user clicks on the "Submit" button
    Then the user can get the "Case ID"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | ProcessName | crossProsses | transaction_name   | DocumentPath                 | DocumentPath1                | status               |
      | ATClient001@alterdomus.com | Welcome@123 | Transfer    | Use Template | Automation Testing | \\attachments\\document1.pdf | \\attachments\\document2.pdf | L1 - Transfer Review |
