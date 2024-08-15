##############################################################################################################
#Author: Pavan
#Written on: 14-Sep-2023
#Feature: FOF Captital call Reject feature
#Description:
#Test case coverage || Total TS -  | Total automated TC's - 9 ||Sanity Suite TC's-1|Time Taking for execution:
#TRA-51005
#############################################################################################################
@PER1 @RegressionFinal1 @PeriodEndReporting
Feature: Verify that Client Service L2 uploading required document from Repository

  @PERScenarioREP1234
  Scenario Outline: Verify that user "<Username>" initiate a Transfer case for "<Fund>" and other required fields
    Given User open the browser and navigate to FundServicesURL
    When the user enters value in "Username" filed with "<Username>"
    When the user enters value in "Password" filed with "<Password>"
    When the user clicks on "Sign_in"
    Then the user clicks on PortalNavHeader
    Then the user should click on process name "<ProcessName>"
    And then click on the "<ProcessName>" dropdown and select the "<Fund>" - REP
    Then the user should upload the "<DocumentPath>" for Repository
    When the user clicks on "lnkTabMasterchklist"
    Then the user should upload the "<MasterChecklistDocPath>" for Repository
    And the user clicks on hamburger menu to the left and clicks on Log off button

    Examples: 
      | Username                         | Password    | ProcessName | Fund              | Client | DocumentPath                              | MasterChecklistDocPath                   | FundChecklistDocPath                             | status          |
      | Clientservices001@alterdomus.com | Welcome@123 | Repository  | Ogilvie Midas LLC | ONNGIZ | \\attachments\\TimetableStandard0.1V.xlsx | \\attachments\\MasterCheckList_0.1V.xlsx | \\attachments\\FundLevelChecksTemplate_0.1V.xlsx | L2 - Initiation |
