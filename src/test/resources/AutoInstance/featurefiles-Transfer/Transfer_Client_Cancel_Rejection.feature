##########################################################################################3
#Author: Pavan
#Written on: 14-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
#Client will initiate the case and submit itCS L1 will enrich the caseCS L2 will Review the case.
@Reg_Areteans__AlterDomusTT @RegressionFinal1 @TransferAuto1
Feature: Verify that as a client with fund "<Fund>" where AD is in charge of prepartion and client is in charge of Review and Release

  @Tansfer_Reject_001
  Scenario Outline: Verify that user "<Username>" initiate a Transfer case for "<Fund>" and other required fields
    Given User open the browser and navigate to CorproURL
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
    Then the user should upload the "<DocumentPath>"
    And The user clicks on the "Submit" button
    And The user clicks on the "Submit" button
    Then the user can get the "Case ID"
    And User wants to cancel the request "<cancelreqcomments>" for that select "<Crossprocess>" from actions dropdown
    And The user clicks on the "Submit" button
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | ProcessName | Fund                | transaction_name   | DocumentPath                 | status               | cancelreqcomments | Crossprocess   |
      | ATClient001@alterdomus.com | Welcome@123 | Transfer    | ATOgilvie Midas LLC | Automation Testing | \\attachments\\document1.pdf | L1 - Transfer Review | AutoTest          | Cancel Request |

  @Tansfer_Reject_002
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
    And User selects the "<Funddisbankacc>" for Fund distributing bank account
    Then User provides the Target date from calendar
    Then user selects "Approve"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    And the user clicks on the "Submit" button
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Funddisbankacc | status               |
      | ATClientservices002@alterdomus.com | Welcome@123 |  8763245435535 | L2 - Transfer Review |

  @Tansfer_Reject_003
  Scenario Outline: Verify that user "<Username>" approve the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user filters the cancelled case""
    #And User selects the pending cancel option from phase-status
    Then the user should land on the "Initiation" screen
    Then user selects "Reject"
    And User enters Reason for rejection "<Reason>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Reason                 | status               |
      | ATClientservices001@alterdomus.com | Welcome@123 | Automation Test Reject | L2 - Transfer Review |

  @Tansfer_Reject_004
  Scenario Outline: Verify that user "<Username>" assign Priority and Approve case by CSL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then click on "FSNA Client Services L2" work basket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User can assign the Priority selected case using the option like "<Crossprocess>" from actions dropdown
    Then user selects "Reject"
    And User enters Reason for rejection "<Reason>"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess    | Reason                        | status                       |
      | ATClientservices001@alterdomus.com | Welcome@123 | Assign Priority | Reject the through automating | Client - Transfer Initiation |

  @Tansfer_Reject_005
  Scenario Outline: Verify that user "<Username>" submit the case and "<status>" by client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should land on the "Initiation" screen
    And User verify the rejects comments from CSL2 "<Rejectcomments>"
    Then the user should upload the "<DocumentPath>"
    Then the user enters "<Comments>" on Initiation Page
    And the user clicks on the "Submit"
    And User validate status "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | Rejectcomments                | DocumentPath                 | Comments         | status               |
      | ATClient001@alterdomus.com | Welcome@123 | Reject the through automating | \\attachments\\document1.pdf | uploaded new doc | L1 - Transfer Review |

  @Tansfer_Reject_006
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess        | status               |
      | ATClientservices002@alterdomus.com | Welcome@123 | Transfer Assignment | L2 - Transfer Review |

  @Tansfer_Reject_007
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And User should click "Yes" on  frist toggle button "Banking details were collected for all investors"
    Then user selects "Approve"
    Then user selects "Approve2"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess        | status                      |
      | ATClientservices001@alterdomus.com | Welcome@123 | Transfer Assignment | L1 - AML/KYC Comfort Letter |

  #
  @Tansfer_Reject_008
  Scenario Outline: Verify that user "<Username>" reject the case and "<status>" by ClientServices-L1
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
      | Username                           | Password    | Crossprocess        | status                 |
      | ATClientservices002@alterdomus.com | Welcome@123 | Transfer Assignment | L2 - Accounting Checks |

  @Tansfer_Reject_009
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
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
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Crossprocess        | status                 |
      | ATClientservices001@alterdomus.com | Welcome@123 | Transfer Assignment | L2 - Accounting Checks |

  @Tansfer_Reject_010
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L1" workbasket
    #Then click on "FSNA Central Operations IS L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 AML/KYC Comfort Letter Review" screen
    And User should click "Yes" on  frist toggle button "Comfort Letter is still valid"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | Crossprocess        | status                 |
      | ATCOIS-02-l1@alterdomus.com | Welcome@123 | Transfer Assignment | L2 - Accounting Checks |

  @Tansfer_0111
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L1 Investor Wire Template" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                      |
      | ATCOPP-01-l1@alterdomus.com | Welcome@123 | L2 - Investor Wire Template |

  @Tansfer_012
  Scenario Outline: Verify that user "<Username>" sumit the case and "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "L2 Investor Wire Template" screen
    And User should click "Yes" on  frist toggle button "Accounting platform has been updated for transfer"
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                   |
      | ATCOPP-01-l2@alterdomus.com | Welcome@123 | L1 - Final Confirmations |

  @Tansfer_013
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
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                   |
      | ATClientservices002@alterdomus.com | Welcome@123 | L2 - Final Confirmations |

  @Tansfer_014
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
    And the user clicks on the "Submit"
    And User validate status "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status             |
      | ATClientservices001@alterdomus.com | Welcome@123 | Resolved-Completed |
