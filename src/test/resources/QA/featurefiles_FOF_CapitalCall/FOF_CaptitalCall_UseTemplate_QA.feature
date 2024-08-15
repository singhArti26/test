##########################################################################################3
#Author: Arun
#Written on: 07-Sep-2023
#Feature: FOF Captital Use Template feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionFOFCapital_QA @FOFCapitalCall_6QA @RegressionRunQA
Feature: Verify that CS L1 initiates the case using template and CS L2 picks the case

  @FOFCapital_useTemplte_001_QA
  Scenario Outline: Verify that user "<Username>" initiate case for FOF Capital Call with required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    #Then the user clicks on PortalNavHeader
    Then the user clicks on "+" plusIcon
    Then the user should click on process name "<ProcessName>"
    Then the user selects use template option from Actions "<Status>"
    Then the user should land on the "Fund Of Fund Capital Call Initiation" screen FOF
    Then upload documents with one supported file type "<upld_pdfFile>"
    And the user should clicks on the Submit button in upload popup
    And click on Submit button
    Then verify the status change - "L1 - FoF Capital Call Enrichment"
    Then enter the total amount to be paid "<amt>"
    And then user click on the "Currency" dropdown and select the currency "<Currency>" - FOF CapitalCall
    And then user click on the "Issuing account" dropdown and select the issuing account
    Then the user clicks on the Investment fund dropdown and select the investment fund
    #Then select the "<Position>" from Position dropdown
    Then enter Notice date and Payment date
    Then the user is able to add Account number as "<Account_number>" - FOF Capital Call
    Then the user should be able to provide the ABA routing number as "<r_number>" - FOF Capital Call
    Then the user should be able to provide the SWIFT number as "<SWIFT_number>" - FOF Capital Call
    Then add multiple transaction types FOF CapCall "<Transaction_type1>" - "<Amount1>"
    And the user provides the internal comments as "<Intl_cmnts>"
    Then the user provides the external comments as "<Extl_cmnts>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | ProcessName      | Fund                | transaction_name | upld_pdfFile                             | amt   | Currency | Account_number | r_number | SWIFT_number | Transaction_type1 | Amount1 | Intl_cmnts | Extl_cmnts | Action_name                             | Action_By           | Status                      |
      | Clientservices002@alterdomus.com | Welcome@123 | FOF Capital Call | ATOgilvie Midas LLC | TATA             | \\DirectInvestmentResources\\Invoice.pdf | 15000 | USD      |         876567 |     6765 |         7658 | Asset: Inventory  |   15000 | Testing    | Testing    | L1 Fund Of Fund Capital Call Enrichment | Client Services 002 | FoF Capital Call Initiation |

  @FOFCapital_useTemplte_002_QA
  Scenario Outline: "<Username>" picks the case
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    Then the user select the captured case id from the Process Id and click the filtered case
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    #Then the user select the captured case id from the Process Id and click the filtered case ""
    Then verify the status change - "L2 - FoF Capital Call Review"
    Then the operator accepts the outcome of review
    And the user provides the internal comments as "<Intl_cmnts>"
    Then approve external comments
    And click on Submit button
    And wait for success message
    Then verify the status change - "L1 - Call Back"
    Then validate the comments section "<Action_name>" "<Intl_cmnts>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | Intl_cmnts | Action_name                | Action_By           |
      | Clientservices001@alterdomus.com | Welcome@123 | Testing    | L2 FOF Capital Call Review | Client Services 001 |
