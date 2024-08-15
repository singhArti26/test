############################################################################################################################################
#Author: Pavan
#Written on: 20-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:Transer Process initiated CSL1 for Fund 7115 with child cases blocked and CSL2 Reslove the process
#Parent-Parallel Task
#Upload kyc status
#Two child cases will be created
#Pick one child case from COIS L1 worklist-Request document from client-COIS L2 reviews the document request on submit case will be assigned to Client
#Client will upload the documents and submit case will be assigned to COIS L1 worklist
#COISL1 user will Approve the documents and on submit case will be asisgned to COIS L2
#COIS L2 user will Approve the documents on submit case will be resolved completed
#Child case sc-2
#Pick child from COIS L1 worklist- Request documents from Investor fill all the mandatory details and submit the case then case will be assigned to COIS L2 user workbasket
#Login as COIS L2 User view the details and submit the case on submit case will be resolved-completed
#Test case coverage || Total TS -  | Total automated TC's - 19 ||Sanity Suite TC's-1|Time Taking for execution:
##############################################################################################################################################
@Reg_Areteans__AlterDomusTT @RegressionFinal1
Feature: Verify that CSL1 initiate a case with fund "Kemp Hickinbottom Co." and CSL2 Review and Reslove the chlid case
  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_1
  Scenario Outline: Verify that user "<Username>" initiate a Transfer case for "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then enter the transaction name as "<transaction_name>"
    And User selects the "<Funddisbankacc>" for Fund distributing bank account
    Then User provides the Transfer effective date from calendar
    Then User provides the Target date from calendar
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then User validates the following message displaying or not based effective date
    Then the user should upload the "<DocumentPath>"
    Then the user should upload the second document "<DocumentPath1>"
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And The user clicks on the "Submit" button
    Then the user can get the "Case ID"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button
    Examples: 
      | Username                         | Password    | ProcessName | Fund                  | transaction_name   | Funddisbankacc | Internalcomments  | Externalcomments | DocumentPath                 | DocumentPath1                | status          |
      | Clientservices002@alterdomus.com | Welcome@123 | Transfer    | Kemp Hickinbottom Co. | Automation Testing |     7897654545 | initiated by CSL1 | By CSL1          | \\attachments\\document1.pdf | \\attachments\\document2.pdf | L2 - Initiation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_2
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    Then user selects "Approve2"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then the user selects thrid "Reject"
    And User enters Reason for rejection "<Reason>"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button
    Examples: 
      | Username                         | Password    | Reason               | Internalcomments | Externalcomments | status          |
      | Clientservices001@alterdomus.com | Welcome@123 | case level rejection | By CSL2          | By CSL2          | L1 - Initiation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_3
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User verify the rejects comments from AD to client "<Rejectcomments>"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then the user enters "<Internalcomments>" and "<Externalcomments>"
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button
    Examples: 
      | Username                         | Password    | Rejectcomments       | Internalcomments | Externalcomments | status          |
      | Clientservices002@alterdomus.com | Welcome@123 | case level rejection | By CSL2          | By CSL2          | L2 - Initiation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_4
  Scenario Outline: Verify that user "<Username>" submit case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then user selects "Approve3"
    And the user provides the internal comments as "<Internalcomments>"
    And User should click "Yes" on  second toggle button "External comments"
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button
    Examples: 
      | Username                         | Password    | Internalcomments | status             |
      | Clientservices001@alterdomus.com | Welcome@123 | By CSL2          | L1 - AMLKYC Review |

  ######################################three parell task will be created  based on funds meta data ######################################################################
  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_5
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COISL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations IS L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 - AML/KYC Review" screen
    And the user clicks on the "Submit"
    And the user validate following error message "Atleast one blocked investor must be added"
    Then the user should upload the "<DocumentPath1>"
    And the user clicks on the "Submit"
    And the user provides the internal comments as "<Internalcomments>"
    Then User click on Related Cases section from case360
    And User should click "Yes" on  second toggle button "Cayman AML Checklist"
    And User should click "Yes" on  thrid toggle button "Certificate of Good Standing"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments | DocumentPath1                  | status                          |
      | COIS-02-l1@alterdomus.com | Welcome@123 | By COISL1        | \\attachments\\KYC Status.xlsx | L2 - Blocked Inv AML/KYC Review |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_6
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COIS-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations IS L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Blocked Investor AML/KYC Review" screen
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button
    

    Examples: 
      | Username                  | Password    | Internalcomments       | status                           |
      | COIS-03-l2@alterdomus.com | Welcome@123 | child case is resloved | Client - Blocked Inv AML/KYC Rem |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_7
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    Then the user select the captured case id based on Description the workbasket and click the filtered case
    Then the user should land on the "Blocked Investor AML/KYC Remediation" screen
    Then the user should upload the "<DocumentPath>"
    Then the user should upload the second document "<DocumentPath1>"
    Then the user enters "<Comments>" on Initiation Page
    And the user clicks on the "Submit"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button
    #child case-1
    Examples: 
      | Username                 | Password    | Rejectcomments       | DocumentPath                 | DocumentPath1                | Comments  | status                       |
      | Client001@alterdomus.com | Welcome@123 | Document is rejected | \\attachments\\document1.pdf | \\attachments\\document2.pdf | By Client | L1 - Blocked Inv AML/KYC Rem |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_8
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COISL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 - AML/KYC Review" screen
    Then user selects "Approve"
    Then user selects "Approve2"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments | DocumentPath                   | status                       |
      | COIS-02-l1@alterdomus.com | Welcome@123 | By COISL1        | \\attachments\\KYC Status.xlsx | L2 - Blocked Inv AML/KYC Rem |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_9
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COIS-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 - Blocked Investor AML/KYC Remediation Review" screen
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments       | status             |
      | COIS-03-l2@alterdomus.com | Welcome@123 | child case is resloved | Resolved-Completed |

  #investor
  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_10
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COISL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L1 Blocked Investor AML/KYC Review" screen
    Then user selects "Investor"
    Then user enter investor related information "<invescontacted>" "<invesemail>"
    Then the user should upload the "<DocumentPath>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments | invescontacted | invesemail                | DocumentPath                 | status                          |
      | COIS-02-l1@alterdomus.com | Welcome@123 | By COISL1        | Automation     | automation@alterDomus.com | \\attachments\\document1.pdf | L2 - Blocked Inv AML/KYC Review |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_11
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COIS-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations IS L2" workbasket
    Then the user select the captured case id from the Des Process Id and click the filtered case
    Then the user should land on the "L2 Blocked Investor AML/KYC Review" screen
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments       | status             |
      | COIS-03-l2@alterdomus.com | Welcome@123 | child case is resloved | Resolved-Completed |

  ##############################################child case completed#################################################################################
  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_12
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Accounting Checks" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                 |
      | Clientservices002@alterdomus.com | Welcome@123 | CSL2             | L2 - Accounting Checks |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_13
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>" by COISL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Investor Registry Confirmation" screen
    And User should click "Yes" on  frist toggle button "Investor registry is updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments   | Reason        | status                         |
      | COIS-02-l1@alterdomus.com | Welcome@123 | Automation Testing | reject reason | L2 - Inv Registry Confirmation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_14
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>" by COISL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations IS L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Investor Registry Confirmation" screen
    And User should click "Yes" on  frist toggle button "Investor registry is updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Internalcomments   | Reason        | status                         |
      | COIS-03-l2@alterdomus.com | Welcome@123 | Automation Testing | reject reason | L2 - Inv Registry Confirmation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_15
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Accounting Checks" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And User should click "Yes" on  second toggle button "Does the investor(s) need to be set up in the investor portal?"
    And User should click "Yes" on  thrid toggle button "Investor(s) is set up with all applicable access within the investor portal"
    Then user selects "Approve"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                         |
      | Clientservices001@alterdomus.com | Welcome@123 | CSL2             | L2 - Inv Registry Confirmation |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_16
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COPPL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations PP L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Investor Wire Template" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | status                      |
      | COPP-01-l1@alterdomus.com | Welcome@123 | L2 - Investor Wire Template |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_17
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by COPPL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on "FSNA Central Operations PP L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | status                   |
      | COPP-01-l2@alterdomus.com | Welcome@123 | L1 - Final Confirmations |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_18
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status                   |
      | Clientservices002@alterdomus.com | Welcome@123 | By CSL2          | L2 - Final Confirmations |

  @Tansfer_Reg_CSL1_Initiate_Done @CSL1_Initiate_19
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Final Confirmations" screen
    And User should click "Yes" on  frist toggle button "The accounting platform is updated"
    And the user provides the internal comments as "<Internalcomments>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Internalcomments | status             |
      | Clientservices001@alterdomus.com | Welcome@123 | By CSL2          | Resolved-Completed |
