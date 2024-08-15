##########################################################################################3
#Author: Arun
#Written on: 07-Sep-2023
#Feature: FOF Captital call Cancel Request Accept feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#############################################################################################################
@RegressionFOFCapital @FOFCapitalBulk2 @RegressionFinal
Feature: Verify that CS L1 initiates the case and submits cancel request, CS L2 accepts cancel request

  @FOFCapital_CancelAcpt_001
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
    Then add multiple transaction types FOF CapCall "<Transaction_type1>" - "<Amount1>"
    And the user provides the internal comments as "<Intl_cmnts>"
    Then the user provides the external comments as "<Extl_cmnts>"
    And click on Submit button
    Then User cancels the request "<Cancel_Rsn>"
    And click on Submit button
    And wait for success message
    Then verify the status change - "L2 - FoF Capital Call Review"
    And capture the "case id"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | ProcessName      | Fund                | transaction_name | upld_pdfFile                             | amt   | Currency | issuing_account | Investment_Fund       | Position            | Account_number | r_number | SWIFT_number | Transaction_type1 | Amount1 | Intl_cmnts | Extl_cmnts | Cancel_Rsn |
      | ATClientservices002@alterdomus.com | Welcome@123 | FOF Capital Call | ATOgilvie Midas LLC | TATA             | \\DirectInvestmentResources\\Invoice.pdf | 15000 | USD      | ICICI 1         | Glaswegian Slone Inc. | Aire Irvine (Units) |         876567 |     6765 |         7658 | Asset: Inventory  |   15000 | Testing    | Testing    | Testing    |

  @FOFCapital_CancelAcpt_002
  Scenario Outline: "<Username>" accepts the cancel request
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then click on Cases To Be Processed
    Then click on "FSNA Client Services L2" workbasket
    #Then the user clicks on the the workbasket "FSNA Client Services L2"
    Then the user filters the cancelled case""
    Then operator approves the cancel request "<Cancel_Rsn>" "<Status_Cancel>"
    Then validate the comments section "<Action_name>" "<Cancel_Rsn>" "<Action_By>"
    Then the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                           | Password    | Intl_cmnts | Action_name                    | Action_By              | Cancel_Rsn | Status_Cancel      |
      | ATClientservices001@alterdomus.com | Welcome@123 | Testing    | Review Cancel Request Decision | Client Services 001 AT | invalid    | Resolved-Cancelled |
