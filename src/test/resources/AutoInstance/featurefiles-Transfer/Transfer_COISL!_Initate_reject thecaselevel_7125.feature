##########################################################################################3
#Author: Pavan
#Written on: 25-Sep-2023
#Feature: Transfer for fund 7114- COIS L1 document reject and case level Approve
#Description:7125- COIS L2 Document reject to COIS L1 and reject the case level
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@Reg_Areteans__AlterDomusTT7125 @RegressionFinal1 @feature3TransferAUTO
Feature: Verify that COIS L2 reject Document to COIS L1 and reject the case level

  @Tansfer_COISL1_initiate_7125 @7125_1
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
      | Username                    | Password    | ProcessName | Fund                   | transaction_name   | DocumentPath                 | DocumentPath1                | Externalcomments | Internalcomments | status          |
      | ATCOIS-02-L1@alterdomus.com | Welcome@123 | Transfer    | ATFathoms Artisan L.P. | Automation Testing | \\attachments\\document1.pdf | \\attachments\\document2.pdf | By COISL1        | By COISL1        | L2 - Initiation |

  @Tansfer_COISL1_initiate_7125 @7125_2
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by COISL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L2" workbasket
    And wait for loading to get completed
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User can assign the Priority selected case using the option like "<Crossprocess>" from actions dropdown
    Then user selects "Approve"
    Then the user selects second "Reject"
    And User enters Reason for rejection "<Reason>"
    Then the user clicks on "COIS L1" in "Assign review of the intake to?"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on  frist toggle button "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Crossprocess    | Reason                  | Internalcomments | status          |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | Assign Priority | rejected the second doc | Testing          | L1 - Initiation |

  @Tansfer_COISL1_initiate_7125 @7125_3
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by client
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    #Then the user select the captured case id from the Process Id in worklist and click the filtered case
    Then the user select the captured case id from the workbasket and click the filtered case to priority "<prioritystatus>"
    Then the user should land on the "Initiation" screen
    And User verify the rejects comments from AD to client "<Rejectcomments>"
    Then the user should upload the "<DocumentPath>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Rejectcomments          | prioritystatus | Internalcomments | DocumentPath                 | status          |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | rejected the second doc | Priority       | COISL1           | \\attachments\\document1.pdf | L2 - Initiation |

  @Tansfer_COISL1_initiate_7125 @7125_4
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by COIS-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    Then user selects "Approve2"
    Then the user selects thrid "Reject"
    And User enters Reason for rejection "<Reason>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Internalcomments | Reason               | status          |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | By COISL2        | Case level rejection | L1 - Initiation |

  @Tansfer_COISL1_initiate_7125 @7125_5
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by client
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    #Then the user select the captured case id from the workbasket and click the filtered case to priority "<prioritystatus>"
    #Then verify that Priority status as "<prioritystatus>" after assign priority at CSL2
    Then the user should land on the "Initiation" screen
    And User verify the rejects comments from AD to client "<Rejectcomments>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Rejectcomments       | prioritystatus | Internalcomments | DocumentPath                 | status          |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | Case level rejection | Priority       | COISL1           | \\attachments\\document1.pdf | L2 - Initiation |

  @Tansfer_COISL1_initiate_7125 @7125_6
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by COIS-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve3"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Internalcomments | Reason               | status                 |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | By COISL2        | Case level rejection | L1 - Accounting Checks |

  @Tansfer_COISL1_initiate_7125 @7125_7
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    #Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Accounting Checks" screen
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess        | Internalcomments | status                 |
      | ATClientservices016@alterdomus.com | Welcome@123 | Transfer Assignment | By CSL1          | L2 - Accounting Checks |

  @Tansfer_COISL1_initiate_7125 @7125_8
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Accounting Checks" screen
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    And user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Internalcomments | status                   |
      | ATClientservices015@alterdomus.com | Welcome@123 | By CSL2          | L1 - Final Confirmations |

  @Tansfer_COISL1_initiate_7125 @7125_9
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And User should click "Yes" on  second toggle button "The investor registry is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Internalcomments | status                   |
      | ATClientservices016@alterdomus.com | Welcome@123 | By CSL1          | L2 - Final Confirmations |

  @Tansfer_COISL1_initiate_7125 @7125_10
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And User should click "Yes" on  second toggle button "The investor registry is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Internalcomments | status             |
      | ATClientservices015@alterdomus.com | Welcome@123 | By CSL2          | Resolved-Completed |
