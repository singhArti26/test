##############################################################################################################
#Author: Arun
#Written on: 09-Oct-2023
#Feature: Period End Reporting - Scenario C
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@PeriodEndReporting @PER3 @RegressionFinal1
Feature: Verify that Client Service L1 initiates the case with financial toggle marked as "Yes"

  @PERSce_1
  Scenario Outline: Verify that user "<Username>" initiate Period End Reporting  for "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    Then enter Period end reporting description as "<PeriodendrepDes>"
    Then then click on the "Fund" dropdown and select the multi "<Fund>"
    Then then click on the "Fund" dropdown and select the multi "<Fund1>"
    Then then click on the "Applicabletimetable " dropdown and select the Applicable timetable "<Applicabletimetable>"
    Then User provides the Period end date from calendar "<perEnddate>"
    Then select the toggle "Will the financial statements be consolidated for all funds in scope" - PER
    Then User select the documents to be requested from the client and enter description as "Automation Testing"
    Then User select enter description as "Automation Testing"
    And the user provides the internal comments as "<Internalcomments>"
    And The user clicks on the "Submit" button
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | ProcessName          | Fund                  | Fund1                 | FundDoc    | Applicabletimetable | perEnddate | PeriodendrepDes    | Internalcomments  | Externalcomments | DocumentPath                 | status          |
      | Clientservices002@alterdomus.com | Welcome@123 | Period End Reporting | Rickwood Handbook Co. | Kemp Hickinbottom Co. | Select all | Standard            | 08/26/2023 | Automation Testing | initiated by CSL1 | By CSL1          | \\attachments\\document1.pdf | L2 - Initiation |

  @PERSce_2
  Scenario Outline: Verify that user "<Username>" picks the case and approves it
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                   |
      | Clientservices001@alterdomus.com | Welcome@123 | L1 - Cash Reconciliation |

  @PERSce_3
  Scenario Outline: Verify that user "<Username>" performs L1 Cash Reconciliation activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then User selects the L1 CashReconciliation from phase-status
    Then the user should land on the "L1 Cash Reconciliation" screen
    Then User select the open check list and validate and provide support
    And User should click "Yes" on client toggle button "Is additional documentation required from the client?"
    And User Please reconcile cash and validate and provide support "<Desrequestclient>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Desrequestclient | status                       |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | Client - Cash Reconciliation |

  @PERSce_4
  Scenario Outline: Verify that user "<Username>" performs "Cash reconciliation" check activity
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should land on the "Cash Reconciliation" screen
    Then the user should upload the "<DocumentPath>"
    Then then click on the "Fund" dropdown and select the multi "<FundDoc>"
    And The user clicks on the client doc "Submit" button
    Then the user enters "<comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | ProcessName | FundDoc    | DocumentPath                 | comments | status                   |
      | Client001@alterdomus.com | Welcome@123 | Transfer    | Select all | \\attachments\\document2.pdf | testing  | L1 - Cash Reconciliation |

  @PERSce_5
  Scenario Outline: Verify that user "<Username>" performs "L1 Cash reconciliation" activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Cash Reconciliation" screen
    Then User select the open check list and validate and provide support
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Desrequestclient | status                   |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | L2 - Cash Reconciliation |

  @PERSce_6
  Scenario Outline: Verify that user "<Username>" performs L2 Cash Reconciliation activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Cash Reconciliation" screen
    Then User select the open check list for reconcile cash and validate and provide support at CSL2
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Desrequestclient | status                   |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | L2 - Cash Reconciliation |

  @PERSce_7
  Scenario Outline: Verify that user "<Username>" performs L1 Ongoing Capital Activities
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then User selects the L1 Open Capital Activity from phase-status
    Then the user should land on the "L1 Ongoing Capital Activities" screen
    And User should click "Yes" on frist toggle button "Do you want to force the process despite activites open?"
    Then the user enters "<Comments>" on Explanation
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Desrequestclient | Comments           | status                     |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | Automation Testing | L2 - Open Capital Activity |

  @PERSce_8
  Scenario Outline: Verify that user "<Username>" performs L2 Capital Activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Capital Activity" screen
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | L1 - Capital Activity |

  @PERSce_9
  Scenario Outline: Verify that user "<Username>" performs L1 Capital Activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Capital Activity" screen
    Then User select the open check list and validate and provide support
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Desrequestclient | Comments           | status                |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | Automation Testing | L2 - Capital Activity |

  @PERSce_10
  Scenario Outline: Verify that user "<Username>" performs L2 Capital Activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Capital Activity" screen
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | L2 - Capital Activity |

  @PERSce_11
  Scenario Outline: Verify that user "<Username>" performs L1 Accruals and Other Entries
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Accruals and Other Entries" screen
    And User should click "Yes" on frist toggle button "Does the fund(s) have expense accruals?"
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                          |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | L2 - Accruals and Other Entries |

  @PERSce_12
  Scenario Outline: Verify that user "<Username>" performs L2 Accruals and Other Entries
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Accruals and Other Entries" screen
    And User should click "Yes" on frist toggle button "Does the fund(s) have expense accruals?"
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                        |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | L1 - Draft Reporting Decision |

  @PERSce_13
  Scenario Outline: Verify that user "<Username>" performs Draft Reporting Decision
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Draft Reporting Decision" screen
    Then User selecting Please funds that require draft reporting to the client
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status            |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | L2 - Stage Gate 2 |

  @PERSce_14
  Scenario Outline: Verify that user "<Username>" performs L1 Draft Reporting
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then User selects the L1 Drafting from phase-status
    Then the user should land on the "L1 Draft Reporting" screen
    Then the user should upload the "<DocumentPath>"
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status               |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Draft Reporting |

  @PERSce_15
  Scenario Outline: Verify that user "<Username>" performs L2 Draft Reporting
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L2 Draft Reporting" screen
    Then user selects "Approve"
    And User should click "Yes" on  frist toggle button "Is the client required for the review of the draft reporting?"
    And User should click "Yes" on external toggle button "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | Desrequestclient | status                   |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | client           | Client - Draft Reporting |

  @PERSce_16
  Scenario Outline: Verify that user "<Username>" performs Draft Reporting activity
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should land on the "Draft Reporting" screen
    Then user selects "Approve"
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                     |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Investment Valuations |

  @PERSce_17
  Scenario Outline: Verify that user "<Username>" performs L1 Investment Valuations
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Investment Valuations" screen
    Then User select the open check list and validate and provide support
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | Externalcomments | status                     |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing          | Testing          | L2 - Investment Valuations |

  @PERSce_18
  Scenario Outline: Verify that user "<Username>" performs L1 Investment Valuations
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Investment Valuations" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on external toggle button "External comments"
    And user clicks on next fund tab
    Then user selects "Approve" in second fund
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | Externalcomments | status                    |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | Testing          | L1 - Financial Statements |

  @PERSce_19 @PERSce_Approve
  Scenario Outline: Verify that user "<Username>" performs L1 Financial Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Financial Statements" screen
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                    |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Financial Statements |

  @PERSce_20 @PERSce_Approve
  Scenario Outline: Verify that user "<Username>" performs L2 Financial Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Financial Statements" screen
    Then User select the open check list and validate and provide support
    And User should click "Yes" on frist toggle button "Does the fund(s) have investor that are charged carried interest?"
    And User should click "Yes" on second toggle button "Accounting platform has been updated for carried interest"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                        |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Client - Financial Statements |

  @PERSce_21
  Scenario Outline: Verify that user "<Username>" performs Client - Financial Statements
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user should land on the "Client - Financial Statements" screen
    Then user selects "Approve"
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                          |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Partner Capital Statements |

  @PERSce_22
  Scenario Outline: Verify that user "<Username>" performs L1 Partner Capital Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Partner Capital Statements" screen
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    Then the user should upload the "<DocumentPath>" and select "Partner capital statements" - PER
    Then then click on the "Fund" dropdown and select the multi "<FundDoc>"
    And The user clicks on the client doc "Submit" button
    And user clicks on next fund tab
    Then the user should upload the "<DocumentPath>" and select "Partner capital statements" - PER
    Then then click on the "Fund" dropdown and select the multi "<FundDoc>"
    And The user clicks on the client doc "Submit" button
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                          | FundDoc    |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Partner Capital Statements | Select all |

  @PERSce_23
  Scenario Outline: Verify that user "<Username>" performs L2 Partner Capital Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Partner Capital Statements" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And user clicks on next fund tab
    Then user selects "Approve" in second fund
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status         |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Client - PCAPs |

  @PERSce_24
  Scenario Outline: Verify that user "<Username>" performs partner capital activity
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then user selects "Approve"
    And User should click "Yes" on  frist toggle button "Partner capital statements are distributed to investors"
    Then the user enters "<Comments>" on Initiation Page
    And user clicks on next fund tab
    Then user selects "Approve" in second fund
    And User should click "Yes" on  second toggle button "Partner capital statements are distributed to investors"
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                           |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Post Reporting Deliverables |

  @PERSce_25
  Scenario Outline: Verify that user "<Username>" performs L1 Post Reporting Deliverables activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Post Reporting Deliverables" screen
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                           |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Post Reporting Deliverables |

  @PERSce_26
  Scenario Outline: Verify that user "<Username>" performs L2 Post Reporting Deliverables activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Post Reporting Deliverables" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And user clicks on next fund tab
    Then user selects "Approve" in second fund
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                      |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Pending L2 Final Validation |

  @PERSce_27
  Scenario Outline: Verify that user "<Username>" performs L2 final validation
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Stage Gate 2" screen
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status             |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Resolved-Completed |
