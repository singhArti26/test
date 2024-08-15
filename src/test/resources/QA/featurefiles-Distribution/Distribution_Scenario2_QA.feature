##########################################################################################################################################################################3
#Author: Suneel
#Written on: 22-May-2023
#Modified By: Arun
#Modified Date: 17-Aug-2023
#Discription:
#Epicid :
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
###############################################################################################################################################################################
@Distribution_ScenarioOutline2 @RegressionDistProcess @RegressionFinal
Feature: Verify that as a Client service L1 for the Fund "Kemp Hickinbottom Co." when Notices Management is AD in charge of preparation & client in charge of sending, AllocationsManagement is As a package,Report ProIntegration is No adoption,Payments Management is AD Central Ops PP in charge of payment preparation & release,Investor Registry Management is AD Central Ops IS in charge of Investor Registry and  AMLKYC Management is AD Central Ops IS in charge of AML/KYC

  @Distribution_Scen001
  Scenario Outline: Verify that user "<Username>" initiate a case with the "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
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
    And then click on the "Transaction types" dropdown and select the "Investor Distribution" under "Accounting System Detail" sections
    Then click on the "Deal name" dropdown and select the "Brunswick Less Co."
    And the user should enter "Transaction type amount" is equal to "Net Amount"
    And click on the "Allocation rule" dropdown and select the "By Specific Allocation (Investments)" under "Accounting System Detail" sections
    Then User provides the Notice Date and Due Date from calendar
    And the user clicks on the "Submit"
    And wait for success message
    And capture the "case id"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Fund                    | Total_CallAmount | Total_DistributionAmt | ProcessName      |
      | ClientServices002@alterdomus.com | Welcome@123 | ATKemp Hickinbottom Co. |            10000 |                 15000 | Capital Activity |

  @Distribution_Scen002
  Scenario Outline: Review of intake-Approve in Client Services L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #When the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should land on the "Initiation" screen
    Then user selects "Approve"
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | ClientServices001@alterdomus.com | Welcome@123 |

  @Distribution_Scen003
  Scenario Outline: Client Services L1 preparation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display "L1 Liquidity Check" pagetitle
    Then user selected "Yes" for does your team review fund liquidty
    Then select answer for fund has sufficient liquidity as "<sufficient_liquidity>" "<liquidity_resolution>"
    And the user clicks on the "Submit"
    Then user should display the "L1 Allocation File Preparation" page
    Then the user should upload the "<allocationfile>"
    Then the user should click on "Investor List"
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user provides the external comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | sufficient_liquidity | liquidity_resolution | allocationfile                               | Intl_cmnts |
      | ClientServices002@alterdomus.com | Welcome@123 | No                   | Leverage credit line | \\attachments\\allocationfiletemplate5k.xlsx | testing    |

  @Distribution_Scen004
  Scenario Outline: Client Services L2 preparation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user should display the "L2 Allocation File Review" page and click on "Approve"
    Then approve external comments
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | ClientServices001@alterdomus.com | Welcome@123 |

  @Distribution_Scen005
  Scenario Outline: COIS L1 preparation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations IS L1" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user should land on "L1 AML/KYC & Investor Registry Review" screen
    And click "Yes" on the toggle button "All investors are AML/KYC cleared"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And click "Yes" on toggle button "The investor registry of this fund is up to date"
    Then upload documents with one supported file type "<upld_pdfFile>" - Second
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | upld_pdfFile                             |
      | COIS-02-l1@alterdomus.com | Welcome@123 | testing    | \\DirectInvestmentResources\\Invoice.pdf |

  @Distribution_Scen006
  Scenario Outline: Client Services L1 Review screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user should display the "L1 Investor Notice Preparation"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    Then the user enters "Internal comments" and "External comments"
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | upld_pdfFile                             |
      | ClientServices002@alterdomus.com | Welcome@123 | \\DirectInvestmentResources\\Invoice.pdf |

  @Distribution_Scen007
  Scenario Outline: Client Services L2 Review screen
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
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | ClientServices001@alterdomus.com | Welcome@123 |

  @Distribution_Scen008
  Scenario Outline: Client Service COPPL1 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page "L1 - Investor Wire Instruction Review" screen
    Then select answer "Yes" for question - The wire instructions are up to date
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l1@alterdomus.com | Welcome@123 |

  @Distribution_Scen009
  Scenario Outline: Client Review screen
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user should able to select Process ID under "Workbasket - Client Workgroup"
    #Then the user select the captured case id from the workbasket and click the filtered case
    Then the user should approve "Allocation file" and "Notices"
    And user should click "Yes" on the toggle button "All investor notices have been distributed to the relevant parties"
    And the user clicks on the "Submit"
    And wait for success message
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    |
      | Client001@alterdomus.com | Welcome@123 |

  @Distribution_Scen010
  Scenario Outline: Client Service L1 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then the user is able to land on the page "Additional Payment Preparation"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | upld_pdfFile                             |
      | ClientServices002@alterdomus.com | Welcome@123 | \\DirectInvestmentResources\\Invoice.pdf |

  @Distribution_Scen011
  Scenario Outline: Client Service COPPL1 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to land on the page "L1 Payment Preparation"
    Then select answer "Yes" for question - Payment(s) have been set up on banking platform
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l1@alterdomus.com | Welcome@123 |

  @Distribution_Scen012
  Scenario Outline: Client Service COPPL2 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    And wait for loading to get completed
    #When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to land on page "L2 Payment Review & Release"
    Then select answer "Yes" for question - Payment(s) have been correctly set up on banking platform
    Then select answer "Yes" for question - Payment(s) have been released via the banking platform
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    |
      | COPP-01-l2@alterdomus.com | Welcome@123 |

  @Distribution_Scen013
  Scenario Outline: Client Service L1 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to display "L1 Payment Reconciliation" page title
    Then select failed payment(s)
    Then select answer "Yes" for question - Accounting platform has been updated for payment(s)
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | ClientServices002@alterdomus.com | Welcome@123 |

  @Distribution_Scen014
  Scenario Outline: Client Service L2 Cash Reconciliation screen
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then user is able to display the "L2 Payment Reconciliation" page title
    Then select answer "Yes" for question - Accounting platform has been reviewed for payment(s) update
    Then the user enters "Internal comments" filed
    And the user clicks on the "Submit"
    And wait for success message
    And the user should able to see case status as "Resolved-Completed"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    |
      | ClientServices001@alterdomus.com | Welcome@123 |
