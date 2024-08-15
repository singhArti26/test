#############################################################################################################
#Author: Pavan
#Written on: 14-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#TRA-51005
############################################################################################################
@PER2 @PeriodEndReporting @RegressionFinal1
Feature: Verify that Client Service L2 initiates the case with "Break out processes" toggle and "financial statements" toggle set as "No" 

  @PER_1 @10052023_PERTodayacd
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

  @PER_2 @10052023_PERTodayacd
  Scenario Outline: Verify that user "<Username>" approves case submitted by CS L1
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

  @PER_3 @10052023_PERTodayacd
  Scenario Outline: Verify that user "<Username>" performs L1 Cash Reconciliation
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

  @PER_4 @10052023_PERTodayacd
  Scenario Outline: Verify that user "<Username>" performs Cash Reconciliation
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
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | ProcessName | FundDoc    | DocumentPath                 | DocumentPath1 | Comments   | status                   |
      | Client001@alterdomus.com | Welcome@123 | Transfer    | Select all | \\attachments\\document2.pdf | By client     | PER Review | L1 - Cash Reconciliation |

  @PER_5 @10052023_PERTodayacd
  Scenario Outline: Verify that user "<Username>" performs L1 Cash Reconciliation
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

  @PER_6 @10052023_PERTodayacd
  Scenario Outline: Verify that user "<Username>" performs L2 Cash Reconciliation
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

  @PER_7 @10052023_PERTodayacd
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

  @PER_8 @10052023_PERTodayacd
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

  @PER_9 @10052023_PERTodayacd
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

  @PER_10 @10052023_PERTodayacd
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

  @PER_11 @10052023_PERTodayacd
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

  @PER_12 @10052023_PERTodayacd
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

  @PER_13 @10052023_PERTodayacd
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

  @PER_14 @10052023_PERTodayacd
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

  @PER_15 @10052023_PERTodayacd @PER_ApprovePPCC
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

  @PER_16 @10052023_PERTodayacd @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should land on the "Draft Reporting" screen
    Then user selects "Approve"
    Then the user should upload the "<DocumentPath>"
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                     |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Investment Valuations |

  @PER_17 @PER_ApprovePPCC
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

  @PER_18 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Investment Valuations
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L2 Investment Valuations" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on external toggle button "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | Externalcomments | status                    |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing          | Testing          | L1 - Financial Statements |

  @PER_19 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Financial Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Financial Statements" screen
    Then User select the open check list and validate and provide support
    And User should click "Yes" on frist toggle button "Does the fund(s) have investor that are charged carried interest?"
    And User should click "Yes" on second toggle button "Accounting platform has been updated for carried interest"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                    |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Financial Statements |

  #
  @PER_20 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Financial Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L2 Financial Statements" screen
    Then User select the open check list and validate and provide support
    And User should click "Yes" on frist toggle button "Does the fund(s) have investor that are charged carried interest?"
    And User should click "Yes" on second toggle button "Accounting platform has been updated for carried interest"
    And User should click "Yes" on thrid toggle button "Accounting platform has been updated for carried interest"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                          |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L1 - Partner Capital Statements |

  @PER_21 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Partner Capital Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L1 Partner Capital Statements" screen
    Then User select the open check list and validate and provide support
    Then the user should upload the second document "<DocumentPath>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                          |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Partner Capital Statements |

  @PER_22 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Partner Capital Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L2 Partner Capital Statements" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                       |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Client - FS And PCAPs Review |

  @PER_23 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" submit case and Validate the "<status>" by Client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then user selects "Approve"
    Then user selects "Approve2"
    And User should click "Yes" on frist toggle button "Partner capital statements are distributed to investors"
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                           |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Post Reporting Deliverables |

  @PER_24 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Post Reporting Deliverables
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

  @PER_25 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Post Reporting Deliverables
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click fund filtered
    Then the user should land on the "L2 Post Reporting Deliverables" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                      |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Pending L2 Final Validation |

  @PER_26 @PER_Approve_Today1234 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Investment Valuations
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Investment Valuations" screen
    Then User select the open check list and validate and provide support
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | Desrequestclient | status                     |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | client           | L2 - Investment Valuations |

  @PER_27 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Investment Valuations
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Investment Valuations" screen
    Then User select the open check list and validate and provide support
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on external toggle button "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                    |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L1 - Financial Statements |

  @PER_28 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Financial Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Financial Statements" screen
    Then User select the open check list and validate and provide support
    And User should click "Yes" on frist toggle button "Does the fund(s) have investor that are charged carried interest?"
    And User should click "Yes" on second toggle button "Accounting platform has been updated for carried interest"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                    |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Financial Statements |

  @PER_29 @PER_Approve_Today123 @PER_ApprovePPCC
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
    And User should click "Yes" on thrid toggle button "Accounting platform has been updated for carried interest"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                          |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L1 - Partner Capital Statements |

  @PER_30 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Partner Capital Statements
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Partner Capital Statements" screen
    Then User select the open check list and validate and provide support
    Then the user should upload the second document "<DocumentPath>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                          |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Partner Capital Statements |

  @PER_31 @PER_Approve_Today123 @PER_ApprovePPCC
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
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                       |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Client - FS And PCAPs Review |

  @PER_32 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs partner capital activity
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id from the workbasket and click the filtered case
    Then user selects "Approve"
    Then user selects "Approve2"
    And User should click "Yes" on frist toggle button "Partner capital statements are distributed to investors"
    Then the user enters "<Comments>" on Initiation Page
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | DocumentPath                 | Comments | status                           |
      | Client001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing  | L1 - Post Reporting Deliverables |

  @PER_33 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L1 Post Reporting Deliverables activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Post Reporting Deliverables" screen
    Then User select the open check list and validate and provide support
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                           |
      | Clientservices002@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | L2 - Post Reporting Deliverables |

  @PER_34 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs L2 Post Reporting Deliverables
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
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | Internalcomments | Externalcomments | status                      |
      | Clientservices001@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Testing          | Testing          | Pending L2 Final Validation |

  @PER_35 @PER_Approve_Today123 @PER_ApprovePPCC
  Scenario Outline: Verify that user "<Username>" performs final validation
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
