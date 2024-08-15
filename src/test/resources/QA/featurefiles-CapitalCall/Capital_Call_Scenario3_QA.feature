##########################################################################################################################################################################3
#Author: Suneel
#Written on: 24-May-2023
#Modified By: Pavan Gangone
#Modified Date: 17-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 14 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Reg_Areteans__AlterDomusCC_QA @CapCall_3QA
Feature: Validate that as a Client for Trust Tweed Co. for Review Intake-Reject and assign to Client Services L1 where AD in charge of preparation & sending as well as AD Central Ops IS in charge of Investor Registry

  @TrustTweedCo_Initiation_1_QA
  Scenario Outline: Verify that user "<Username>" initiate a case with the "<Fund>" and other required fields
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
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
    Then the user can check Capital Activity "Case ID"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | ProcessName      | status                           | Fund              | Comments    | Percentagetobecalled | NoticeDate | DueDate    |
      | Client002@alterdomus.com | Welcome@123 | Capital Activity | L1 - Capital Activity Enrichment | ATTrust Tweed Co. | AutoTesting |                 0.01 | 08-21-2023 | 08-28-2023 |

  @TrustTweedCo_Initiation_2_QA
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then the user should land on the "Initiation" screen
    And then click on the "Transaction types" dropdown and select the "Investor Contribution: Expenses" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "Foundation Protyping Inc."
    And the user click on the "Position" dropdown and select the "Unallocated"
    And the user should enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                       |
      | Clientservices012@alterdomus.com | Welcome@123 | L2 - Capital Activity Review |

  @TrustTweedCo_Initiation_3_QA
  Scenario Outline: Verify that user "<Username>"  reject and submit the case and validate the "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Reject" in "Review of intake"
    Then the user clicks on "Client services L1" in "Assign review of the intake to?"
    And User enters Reason for rejection "<Reason>"
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Reason            | status                       |
      | Clientservices011@alterdomus.com | Welcome@123 | Automation Reject | L1 - Capital Activity Review |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_4_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    Then the user should land on the "Initiation" screen
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | TrantypesName1          | TrantypesName2        | transAmt | status                       |
      | Clientservices012@alterdomus.com | Welcome@123 | Amortization: Insurance | Investor Contribution |    20000 | L2 - Capital Activity Review |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_5_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                           |
      | Clientservices011@alterdomus.com | Welcome@123 | L1 - Allocation File Preparation |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_6_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by Client Services L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    Then user should display the "L1 Allocation File Preparation" page
    Then the user should upload the "<allocationfile>"
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | allocationfile                                  | status                      |
      | Clientservices012@alterdomus.com | Welcome@123 | \\attachments\\allocationfiletemplateTrust.xlsx | L2 - Allocation File Review |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_7_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by Client Services L2
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
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                  |
      | Clientservices011@alterdomus.com | Welcome@123 | L1 - Notice Preparation |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_8_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by by Client Services L1
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
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | DocumentPath                 | status             |
      | Clientservices012@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | L2 - Notice Review |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_9_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by by Client Services L2
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
      | Username                         | Password    | status                  |
      | Clientservices011@alterdomus.com | Welcome@123 | Client – Package Review |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_010_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    Then the user should approve "Allocation file" and "Notices"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | status                   |
      | Client002@alterdomus.com | Welcome@123 | L2 - Notice Distribution |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_011_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L2 Investor Notice Distribution"
    Then the user enable toggle button "All investor notices have been distributed to relevant parties via ReportPro"
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                   |
      | Clientservices011@alterdomus.com | Welcome@123 | L1 - Cash Reconciliation |

  @Smoke103_Today_25_QA @TrustTweedCo_Initiation_012_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by Client Services L1
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
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                   |
      | Clientservices012@alterdomus.com | Welcome@123 | L2 - Cash Reconciliation |

  @TrustTweedCo_Initiation_013_QA @Smoke103_Today_25 @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by Client Services L2
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
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | status                   |
      | Clientservices011@alterdomus.com | Welcome@123 | L2 - Cash Reconciliation |

  @TrustTweedCo_Initiation_014_QA @Smoke103_Today_25_QA @alterDomus_Regression_Suite_CP_QA
  Scenario Outline: Verify that user "<Username>" submit the case and Validate the "<status>" by COIS L1
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
      | Username                  | Password    | DocumentPath                 | status             |
      | COIS-02-l1@alterdomus.com | Welcome@123 | \\attachments\\document1.pdf | Resolved-Completed |
