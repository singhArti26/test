#########################################################################################3
#Author: Pavan
#Written on: 20-Sep-2023
#Feature: Transfer for fund 7114- COIS L1 document reject and case level Approve
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 13 ||Sanity Suite TC's-1|Time Taking for execution:
############################################################################################################
@Reg_Areteans__AlterDomusTT @RegressionFinal1 @feature2TransferAuto
Feature: Verify that COIS L2 reject the Document to send to client and Case level Reslove

  @Tansfer_COISL1_initiate_7121_1 @7121_1
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
      | ATCOIS-02-L1@alterdomus.com | Welcome@123 | Transfer    | ATLangton Drawdeal LLC | Automation Testing | \\attachments\\document1.pdf | \\attachments\\document2.pdf | By COISL1        | By COISL1        | L2 - Initiation |

  @Tansfer_COISL1_initiate_7121_2 @7121_2
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L2" workbasket
    And wait for loading to get completed
    #Then click on "FSNA Central Operations IS L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User can assign the Priority selected case using the option like "<Crossprocess>" from actions dropdown
    Then user selects "Approve"
    Then the user selects second "Reject"
    And User enters Reason for rejection "<Reason>"
    Then the user clicks on "Client" in "Assign review of the intake to?" filed
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Crossprocess    | Reason                  | status                       |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | Assign Priority | rejected the second doc | Client - Transfer Initiation |

  @Tansfer_COISL1_initiate_7121_3 @7121_3
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>"
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should land on the "Initiation" screen
    And User verify the rejects comments from AD to client "<Rejectcomments>"
    Then the user should upload the "<DocumentPath>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | Rejectcomments          | prioritystatus | DocumentPath                 | status          |
      | ATClient001@alterdomus.com | Welcome@123 | rejected the second doc | Priority       | \\attachments\\document1.pdf | L1 - Initiation |

  @Tansfer_COISL1_initiate_7121 @7121_4
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve2"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Crossprocess        | Reason        | status          |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | Transfer Assignment | reject reason | L2 - Initiation |

  @Tansfer_COISL1_initiate_7121 @7121_5
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve3"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                       |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | L1-Inv Registry Confirmation |

  @Tansfer_COISL1_initiate_7121 @7121_6
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                         |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | L2 - Inv Registry Confirmation |

  @Tansfer_COISL1_initiate_7121 @7121_7
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Investor Registry Confirmation" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Crossprocess        | DocumentPath                 | Internalcomments   | status                         |
      | ATCOIS-03-l2@alterdomus.com | Welcome@123 | Transfer Assignment | \\attachments\\document1.pdf | Automation Testing | L2 - Inv Registry Confirmation |

  @Tansfer_COISL1_initiate_7121 @7121_8
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>"
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
      | ATClientservices014@alterdomus.com | Welcome@123 | Transfer Assignment | By CSL1          | L2 - Accounting Checks |

  @Tansfer_COISL1_initiate_7121 @7121_9
  Scenario Outline: Verify that user "<Username>" submit the case and  "<status>"
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
      | ATClientservices013@alterdomus.com | Welcome@123 | By CSL2          | L1 - Final Confirmations |

  @Tansfer_COISL1_initiate_7121 @7121_10
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>"
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Internalcomments | status                   |
      | ATClientservices014@alterdomus.com | Welcome@123 | By CSL1          | L2 - Final Confirmations |

  @Tansfer_COISL1_initiate_7121 @7121_11
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Internalcomments | status             |
      | ATClientservices013@alterdomus.com | Welcome@123 | By CSL2          | Resolved-Completed |
