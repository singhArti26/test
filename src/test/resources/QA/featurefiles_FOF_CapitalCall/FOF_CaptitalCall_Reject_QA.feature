##########################################################################################3
#Author: Arun
#Written on: 07-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionFOFCapital_QA @FOFCapitalCall_4QA @RegressionRunQA
Feature: Verify that CS L1 initiates the case, AD rejects the case, later accepts and resolves the case

  @FOFCapital_001_QA
  Scenario Outline: Verify that user "<Username>" initiate case for FOF Capital Call with required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user should land on the "Fund Of Fund Capital Call Initiation" screen FOF
    And then click on the "Fund" dropdown and select the "<Fund>"
    Then enter the transaction name as "<transaction_name>"
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify the status change - "L1 - FoF Capital Call Enrichment"
    Then enter the total amount to be paid "<amt>"
    And then user click on the "Currency" dropdown and select the currency "<Currency>" - FOF CapitalCall
    And then user click on the "Issuing account" dropdown and select the issuing account "<issuing_account>" - FOF CapitalCall
    Then the user clicks on the Investment fund dropdown and select the "<Investment_Fund>"
    Then select the "<Position>" from Position dropdown
    Then enter Notice date and Payment date
    Then the user is able to add Account number as "<Account_number>" - FOF Capital Call
    Then the user should be able to provide the ABA routing number as "<r_number>" - FOF Capital Call
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>" - FOF Capital Call
    Then add multiple transaction types FOF CapCall "<Transaction_type1>" - "<Amount1>" "<Transaction_type2>" - "<Amount2>" "<Transaction_type3>" - "<Amount3>"
    And the user provides the internal comments as "<Intl_cmnts>"
    Then the user provides the external comments as "<Extl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | ProcessName      | Fund                | transaction_name | upld_pdfFile                             | amt   | Currency | issuing_account | Investment_Fund       | Position            | Account_number | r_number | SWIFT_number | Transaction_type1 | Amount1 | Transaction_type2          | Amount2 | Transaction_type3             | Amount3 | Intl_cmnts | Extl_cmnts | Action_name                             | Action_By           |
      | Clientservices002@alterdomus.com | Welcome@123 | FOF Capital Call | ATOgilvie Midas LLC | TATA             | \\DirectInvestmentResources\\Invoice.pdf | 15000 | USD      | ICICI 1         | Glaswegian Slone Inc. | Aire Irvine (Units) |         876567 |     6765 |         7658 | Asset: Inventory  |    5000 | Asset: Goodwill/Intangible |    5000 | Asset: Property and Equipment |    5000 | Testing    | Testing    | L1 Fund Of Fund Capital Call Enrichment | Client Services 002 |

  @FOFCapital_002_QA
  Scenario Outline: "<Username>" rejects the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then the user assigns priority
    And wait for loading to get completed
    Then the operator rejects the outcome of review - FOFcp
    Then provide the reject reason as "<RejectReason>"
    Then Assign to Client Services L1 operator
    And the user provides the internal comments as "<Intl_cmnts>"
    Then approve external comments
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - FoF Capital Call Enrichment"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                | Action_By           | RejectReason |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing    | L2 FOF Capital Call Review | Client Services 001 | Testing      |

  @FOFCapital_003_QA
  Scenario Outline: "<Username>" checks the rejected case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id and click the filtered case - Priority check "<Priority_chk>"
    Then verify the status change - "L1 - FoF Capital Call Enrichment"
    Then verify the reject reason comments submitted by previous operator is displayed or not "<Intl_cmnts>"
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                             | Action_By           | Priority_chk |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing    | L1 Fund Of Fund Capital Call Enrichment | Client Services 002 | Priority     |

  @FOFCapital_004_QA
  Scenario Outline: "<Username>" accepts the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    Then the user provides the external comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Call Back"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                | Action_By           |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing    | L2 FOF Capital Call Review | Client Services 001 |

  @FOFCapital_005_QA
  Scenario Outline: "<Username>" performs L1 Liquidity Review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Call Back"
    Then select answer for fund has sufficient liquidity as "<sufficient_liquidity>" "<liquidity_resolution>"
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Call Back"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name         | Action_By           | sufficient_liquidity | liquidity_resolution |
      | Clientservices002@alterdomus.com | Welcome@123 | Testing    | L1 Liquidity Review | Client Services 002 | No                   | Leverage credit line |

  @FOFCapital_006_QA
  Scenario Outline: "<Username>" performs L1 Call back
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L1" workbasket
    #Then the user clicks on the COPPL1 workbasket "FSNA Central Operations PP L1"
    Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Call Back"
    And enter client representative call name "<representative>" - "<Process>"
    Then enter call completed time "<call_Completed_Time>" - "<Process>"
    And enter no of client representative as "<representative_no>" - "<Process>"
    And User should select "Yes" for client call successful - "<Process>"
    And enter template name "<template_name>" - "<Process>"
    And enter template bank as "<template_bank>" - "<Process>"
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Call Back Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Supporting documents             | template_name | template_bank | representative | call_Completed_Time | representative_no | Intl_cmnts | Action_name  | Action_By     | Process |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Supporting documents - Call back | template name | template bank | John           | 9/14/2023 10:52 PM  |        1234567890 | Testing    | L1 Call Back | CO PP 01 - L1 | FOF     |

  @FOFCapital_007_QA
  Scenario Outline: "<Username>" performs L2 Call back review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then click on Cases To Be Processed
    Then click on "FSNA Central Operations PP L2" workbasket
    #When the user clicks on the the workbasket "FSNA:COPPL2" option
    Then the user select the captured case id from the Process Id and click the filtered case
    Then check the toggles if they are disabled
    Then verify the status change - "L2 - Call Back Review"
    And wait for loading to get completed
    Then the operator rejects the outcome of review - FOFclbck
    Then provide the reason as "<Intl_cmnts>" - "<Process>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Call Back"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Supporting documents             | Intl_cmnts | Action_name         | Action_By     | Process |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Supporting documents - Call back | Testing    | L2 Call Back Review | CO PP 01 - L2 | FOF     |

  @FOFCapital_008_QA
  Scenario Outline: "<Username>" performs L1 Call back again as case rejected by CS L2
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Call Back"
    Then check if toggle is disabled for banking platform
    Then verify reject comments "<Intl_cmnts>" provided by previous operator
    And User should select "Yes" for client call successful - "<Process>"
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Call Back Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name  | Action_By     | Process |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Testing    | L1 Call Back | CO PP 01 - L1 | FOF     |

  @FOFCapital_009_QA
  Scenario Outline: "<Username>" performs L2 Call back review
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then check the toggles if they are disabled
    Then verify the status change - "L2 - Call Back Review"
    Then the operator accepts the outcome of review
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Notice Payment Processing"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name  | Action_By     |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Testing    | L1 Call Back | CO PP 01 - L1 |

  @FOFCapital_010_QA
  Scenario Outline: "<Username>" performs L1 - Notice Payment Processing activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Notice Payment Processing"
    Then select answer "Yes" for question - All the payments above were set up on the banking platform
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user provides the external comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Notice Payment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name                  | Action_By     |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Testing    | L1 Notice Payment Processing | CO PP 01 - L1 |

  @FOFCapital_011_QA
  Scenario Outline: "<Username>" performs L2 - Notice Payment Processing activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Notice Payment Review"
    Then provide the payment reject reason as "<Intl_cmnts>" - FOF Capital
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Notice Payment Processing"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name              | Action_By     |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Testing    | L2 Notice Payment Review | CO PP 01 - L2 |

  @FOFCapital_012_QA
  Scenario Outline: "<Username>" performs L1 - Notice Payment Processing activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Notice Payment Processing"
    Then verify the reject reason comments submitted by previous operator is displayed or not "<Intl_cmnts>"
    Then select answer "Yes" for question - All the payments above were set up on the banking platform
    Then upload the "Supporting documents" and change file type to "<Supporting documents>"
    And the user should clicks on the Submit button in upload popup
    And the user provides the internal comments as "<Intl_cmnts>"
    And the user provides the external comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Notice Payment Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts | Action_name                  | Action_By     |
      | COPP-01-l1@alterdomus.com | Welcome@123 | Testing    | L1 Notice Payment Processing | CO PP 01 - L1 |

  @FOFCapital_013_QA
  Scenario Outline: "<Username>" performs L2 - Notice Payment Processing activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Notice Payment Review"
    Then select answer Yes for question - Please review that all the payments above were correctly set up on the banking platform
    And the user provides the internal comments as "<Intl_cmnts>"
    Then approve external comments
    And click on Submit button
    And wait for success message
    Then verify the status change - "Notice Payment Review & Release"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                  | Password    | Intl_cmnts |
      | COPP-01-l2@alterdomus.com | Welcome@123 | Testing    |

  #check for status and comments under "case 360" once case is submitted
  @FOFCapital_014_QA
  Scenario Outline: "<Username>" performs Notice Payment Review
    Given User open the browser and navigate to CorproURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id and click the filtered case for client
    #Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the workbasket and click the filtered case ""
    Then select answer Yes for the question - All payments were released on the banking platform
    And click on Submit button
    And wait for success message
    Then the user should get logout successfully by clicking on "LogOff" button

    Examples: 
      | Username                 | Password    | Supporting document                    | Intl_cmnts | Action_name              | Action_By     |
      | Client002@alterdomus.com | Welcome@123 | Supporting documents - Payment release | Testing    | L2 Notice Payment Review | CO PP 01 - L2 |

  @FOFCapital_015_QA
  Scenario Outline: "<Username>" performs "L1 - Notice Pay. Cash Recon." activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L1 - Notice Pay. Cash Recon."
    Then select Yes - All the payments were successfully released
    Then select Yes - The accounting platform has been updated to reflect the payments
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - Notice Pay. Recon. Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Action_name                           | Intl_cmnts | Action_By           |
      | Clientservices002@alterdomus.com | Welcome@123 | L1 Notice Payment Cash Reconciliation | Testing    | Client Services 002 |

  @FOFCapital_016_QA
  Scenario Outline: "<Username>" performs "L2 - Notice Pay. Recon. Review" activity
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign in" button
    Then the user select the captured case id from the Process Id in worklist and click the filtered case
    #Then the user select the captured case id from the Process Id and click the filtered case
    Then verify the status change - "L2 - Notice Pay. Recon. Review"
    And the user provides the internal comments as "<Intl_cmnts>"
    And click on Submit button
    Then verify payment error message - "<Error_message>"
    Then select Yes - All the payments were successfully released
    Then select Yes - The accounting platform has been updated to reflect the payments
    And click on Submit button
    And wait for success message
    Then verify the status change - "Resolved-Completed"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                                  | Action_By           | Error_message                                                                    |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing    | L2 Notice Payment Cash Reconciliation Review | Client Services 001 | **Please select the accounting platform has been updated to reflect the payments |
