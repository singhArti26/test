##########################################################################################################################################################################3
#Author: Suneel
#Written on: 22-May-2023
#Modified By: Arun
#Modified Date: 17-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's -  ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Distribution_Scenario1_Auto @RegressionDistProcess @RegressionFinal @RegressionDistProcessAUTO
Feature: Verify that as a Client  for the Fund "Marketing Bryden LLC" when Notices Management is Client in charge of preparation & sending, Allocations Management is As a package,Report ProIntegration is No adoption,Payments Management is AD Central Ops PP in charge of payment preparation & release,Investor Registry Management is AD Central Ops IS in charge of Investor Registry and  AMLKYC Management is AD Central Ops IS in charge of AML/KYC

  @Dis_001_Auto
  Scenario Outline: Verify that user "<Username>" initiate a case with the "<Fund>" and other required fields
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Initiation" screen
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then the user enters "Transaction name"
    Then the user provides the "<Total_CallAmount>" and "<Total_DistributionAmt>"
    Then the user enters "<Comments>" on Initiation Page
    Then User provides the Notice Date and Due Date from calendar
    And the user clicks on the "Submit"
    Then the user clicks on the "Submit" button in "Summary - Initiation" page
    And wait for success message
    And capture the "case id"
    And the user should able to see case status as "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | ProcessName      | Fund                   | Comments | status                           | Total_CallAmount | Total_DistributionAmt |
      | ATClient002@alterdomus.com | Welcome@123 | Capital Activity | ATMarketing Bryden LLC | Testing  | L1 - Capital Activity Enrichment |            10000 |                 15000 |

  @Dis_002
  Scenario Outline: Verify that user "<Username>" select the transaction type as "<transctionType>"  and "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L1" workbasket
    #Then click on "FSNA Client Services L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    And then click on the "Transaction types" dropdown and select the "<transctionType>" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "Dingwall Images LLC"
    And the user should enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | transctionType        | status                       |
      | ATClientServices008@alterdomus.com | Welcome@123 | Investor Distribution | L2 - Capital Activity Review |

  @Dis_003
  Scenario Outline: Verify that user "<Username>" approve case and validate the "<status>" by Client Services L2
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
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status               |
      | ATClientServices007@alterdomus.com | Welcome@123 | L1 - Liquidity Check |

  @Dis_004
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L1 Liquidity Check" pagetitle
    Then user selected "Yes" for does your team review fund liquidty
    Then select answer for fund has sufficient liquidity as "<sufficient_liquidity>" ""
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    Then user should display the "L1 Allocation File Preparation" page
    Then the user should upload the "<allocationfile>"
    Then the user should click on "Investor List"
    And the user should click "Yes" on the toggle button "The investor registry of this fund is up to date"
    Then the user can upload Documents
    Then the user clicks on "Submit" button on the internal window
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | sufficient_liquidity | status                      | allocationfile                               | Intl_cmnts        |
      | ATClientServices008@alterdomus.com | Welcome@123 | Yes                  | L2 - Allocation File Review | \\attachments\\allocationfiletemplate5k.xlsx | internal comments |

  @Dis_005
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the "L2 Allocation File Review" page and click on "Approve"
    And the user provides the internal comments as "<Intl_cmnts>"
    Then the user clicks on "Approve" toggle button
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                     | Intl_cmnts |
      | ATClientServices007@alterdomus.com | Welcome@123 | Client - Allocation Review | testing    |

  @Dis_006
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by COIS L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L1" workbasket
    #Then the user click on "FSNA:COISL1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user should land on the "L1 - AML/KYC Review" screen
    And click "Yes" on the toggle button "All investors are AML/KYC cleared"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                     | Intl_cmnts | upld_pdfFile                             |
      | ATCOIS-03-l1@alterdomus.com | Welcome@123 | Client - Allocation Review | testing    | \\DirectInvestmentResources\\Invoice.pdf |

  @Dis_007
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by COPPL1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L1 - Investor Wire Instruction Review" page
    Then select answer "Yes" for question - The wire instructions are up to date
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                     |
      | ATCOPP-02-l1@alterdomus.com | Welcome@123 | Client - Allocation Review |

  @Dis_008
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by Client
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then the user is able to land on the page - "Investor Allocation Review & Notice Distribution"
    Then the user should approve "Allocation file" - Distribution
    Then select answer "Yes" for question - All investor notices have been prepared for the relevant parties
    Then select answer "Yes" for question - All investor notices have been distributed to the relevant parties
    And the user clicks on the "Submit"
    And wait for success message
    Then verify the status change - "<status>"
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                   | Password    | status                   |
      | ATClient002@alterdomus.com | Welcome@123 | L1 - Payment Preparation |

  @Dis_009
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page "Additional Payment Preparation"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                   | Intl_cmnts | upld_pdfFile                             |
      | ATClientServices008@alterdomus.com | Welcome@123 | L1 - Payment Preparation | testing    | \\DirectInvestmentResources\\Invoice.pdf |

  @Dis_010
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by COPP02L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to land on the page "L1 Payment Preparation"
    Then select answer "Yes" for question - Payment(s) have been set up on banking platform
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status               | Intl_cmnts |
      | ATCOPP-02-l1@alterdomus.com | Welcome@123 | L2 - Payment Release | testing    |

  @Dis_011
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by COPPL2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    And wait for loading to get completed
    #When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to land on page "L2 Payment Review & Release"
    Then select answer "Yes" for question - Payment(s) have been correctly set up on banking platform
    Then select answer "Yes" for question - Payment(s) have been released via the banking platform
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                    | Password    | status                      | Intl_cmnts        |
      | ATCOPP-02-l2@alterdomus.com | Welcome@123 | L1 - Payment Reconciliation | internal comments |

  @Dis_012
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by ClientServices-L1
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to display "L1 Payment Reconciliation" page title
    Then select answer "Yes" for question - Payment(s) have been executed
    Then select answer "Yes" for question - Accounting platform has been updated for payment(s)
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status                      | Intl_cmnts |
      | ATClientServices008@alterdomus.com | Welcome@123 | L2 - Payment Reconciliation | testing    |

  @Dis_013
  Scenario Outline: Verify that user "<Username>" submit the case and validate "<status>" by ClientServices-L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to display the "L2 Payment Reconciliation" page title
    Then select answer "Yes" for question - Payment(s) have been executed
    Then select answer "Yes" for question - Accounting platform has been reviewed for payment(s) update
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "<status>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | status             | Intl_cmnts |
      | ATClientServices007@alterdomus.com | Welcome@123 | Resolved-Completed | testing    |
