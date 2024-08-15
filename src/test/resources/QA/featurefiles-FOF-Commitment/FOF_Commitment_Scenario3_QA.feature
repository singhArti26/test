##########################################################################################
#Author: Suneel
#Written on: 31-Aug-2023
#Modified by: Arun
#Modified date: 19-Sep-2023
#Feature:
#Discription:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionFOFcommitment_QA @FOFcommitmentBulkRun3_QA @FOFCOmmint123_QA @Reg_Areteans__AlterDomus_QA @Reg_Areteans__AlterDomusFOFC_QA @RegressionRunQA
Feature: As a client operator for Fund Rickwood Handbook Co.. with toggle as "Yes "for "Is this a new Investment and user marks "Executed" for purchase Agreement with banking details for this investment

  @FOFcommitment_Pymnt_Scenario_001_QA
  Scenario Outline: Create a case in Client
    Given User open the browser and navigate to CorproURL
    Given the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon for client
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>" for FOFcommitment
    Then select answer "Yes" for question - Is this a new investment?
    Then the user enter "<InvestmntName>"
    Then the user provide "<AmountToCommit>"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    Then the user click on "Executed" in Purchase Agreement
    And click on Submit button
    Then verify summary page title "Summary - Initiation"
    And click on Submit button
    And wait for success message
    And capture the "case id"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | ProcessName    | Fund                    | InvestmntName | AmountToCommit | upld_pdfFile                             |
      | Client001@alterdomus.com | Welcome@123 | FOF Commitment | ATRickwood Handbook Co. | testname      |          10000 | \\DirectInvestmentResources\\Invoice.pdf |

  @FOFcommitment_Pymnt_Scenario_002_QA
  Scenario Outline: Create a case in ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    Given the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case ""
    Then the user land on "L1 - Investment Details Preparation" screen
    Then user selects "Approve"
    Then user enters "<TransactionName>"
    Then provide "<Security_Name>"
    Then select "<Security_Type>" from security type dropdown
    And user enter "<Amount1>" is equal to Amount to commit - FOF
    And user enter "<No_Of_Shares>" under Security & transaction details
    Then User provides the Trade date and Settlement date from calendar
    Then select answer "Yes" for question - Did the client provide banking details for this investment?
    Then the user provide "<BankName>" and "<BankAccount>"
    Then select "<Country>" from country dropdown
    And enter "Bank SWIFT/BIC code"
    And click on Submit button
    And wait for success message
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | TransactionName | Security_Name | Security_Type    | Amount1 | No_Of_Shares | BankName | BankAccount | Country |
      | Clientservices002@alterdomus.com | Welcome@123 | testname        | John          | Convertible Loan |   10000 |            1 | testBank |       12345 | Canada  |

  @FOFcommitment_Pymnt_Scenario_003_QA
  Scenario Outline: Review of intake-Approve in Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #When the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user should land on the "L2 - Investment Review" initiation screen
    Then the user selects "Approve"
    And click on Submit button
    And wait for success message
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | Clientservices001@alterdomus.com | Welcome@123 |

  @FOFcommitment_Pymnt_Scenario_004_QA
  Scenario Outline: provide call back details in COPPL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page "Call Back" pagetitle
    #Then select answer "Yes" for question - Are the banking details for this investment present in the banking platform?
    And enter client representative call name "<representative>" - "<Process>"
    Then enter call completed time "<call_Completed_Time>" - "<Process>"
    And enter no of client representative as "<representative_no>" - "<Process>"
    And User should select "Yes" for client call successful - "<Process>"
    And enter template name "<template_name>" - "<Process>"
    And enter template bank as "<template_bank>" - "<Process>"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And wait for success message
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | representative | call_Completed_Time | representative_no | template_name | template_bank | Process | upld_pdfFile                             |
      | COPP-01-l1@alterdomus.com | Welcome@123 | John           | 9/20/2023 10:52 PM  |        1234567890 | testName      | tmplteBank    | FOF     | \\DirectInvestmentResources\\Invoice.pdf |

  @FOFcommitment_Pymnt_Scenario_005_QA
  Scenario Outline: Call Back Review in COPP-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    #When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to display the "L2 Call Back Review" page title
    Then user selects "Approve"
    And click on Submit button
    And wait for success message
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l2@alterdomus.com | Welcome@123 |

  @FOFcommitment_Pymnt_Scenario_006_QA
  Scenario Outline: L1 Reconciliation in ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should land on pagetitle "L1 Reconciliation" screen
    Then select answer "Yes" for question - Accounting platform has been updated for investment
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    And wait for success message
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | upld_pdfFile                             |
      | Clientservices002@alterdomus.com | Welcome@123 | \\DirectInvestmentResources\\Invoice.pdf |

  @FOFcommitment_Pymnt_Scenario_007_QA
  Scenario Outline: L2 Reconciliation Review in ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should land on the "L2 Reconciliation Review" page
    Then select answer "Yes" for question - Accounting platform has been reviewed for investment
    And click on Submit button
    And wait for success message
    And the user should able to see case status as "Resolved-Completed"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | Clientservices001@alterdomus.com | Welcome@123 |
