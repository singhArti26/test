package com.cucumber.framework.pageconstants;

public interface InitiationL1PageLoc {

	String username_xpath = "//input[@id='txtUserID']";
	String password_xpath = "//input[@id='txtPassword']";
	String login_btn_xpath = "//*[@id='sub']/span";
	//String plusIcon_xpath = "//*[@class='menu-item-title']";
	String plusIcon_xpath = "//ul[@role='menubar']//li//a[@class='menu-item-anchor menu-item-expand']";
	String plusIconForClient_xpath = "//ul[@data-menu-id='DataPortalpyCreateCaseMenu153cef6883']//li[1]";
	String Icon_xpath = "//*[@id='RULE_KEY']/div[1]/div[1]/span/button/img";
	String cancel_icon_xpath = "//*[@id='RULE_KEY']/div[1]/div[2]/span/button/img";
	String fof_commitment_btn_xpath = "//span[@class='menu-item-title' and contains(text(),'FOF Commitment')]";

	String create_btn_xpath = "(//span[@class='menu-item-icon-imageclass pi pi-plus'])[1]";
	String lnkcapitalactivity = "//span[@class='menu-item-title' and contains(text(),'Capital Activity')]";
	String lnkFOFDistribution = "//span[@class='menu-item-title' and contains(text(),'FOF Distribution')]";
	String lnkExpensePayment = "//span[@class='menu-item-title' and contains(text(),'Expense Payment')]";
	String lnkFOFCommitment = "//span[@class='menu-item-title' and contains(text(),'FOF Commitment')]";
	String lnkDrctInvPurchase = "//span[@class='menu-item-title' and contains(text(),'Direct Investment Purchase')]";
	String lnkFOFCapitalCall = "//span[@class='menu-item-title' and contains(text(),'FOF Capital Call')]";
	String lnkTransfer = "//span[@class='menu-item-title' and contains(text(),'Transfer')]";
	String lnkRepository = "//span[@class='menu-item-title' and contains(text(),'Repository')]";
	String lnkPeriodEndReporting = "//span[@class='menu-item-title' and contains(text(),'Period End Reporting')]";

	String txtAreaStatus = "(//span[@class='ad_case_title'])[1]";
	String initiation_screen_xpath = "(//div[@data-context='pyWorkPage']/span[1])[1]";
	String fund_dropdown_xpath = "//input[@id='da6bd55d']";
	String review_lebel_xpath = "//div[@class='content    flex  layout-content-inline content-inline stages']/div[3]";
	String search_xpath = "//*[@id='anypicker-input']";
	String list_xpath = "//li[@role='treeitem']";
	String list_xpath1 = "(//li[@class='active-row']/div/span)[1]";

	String capital_call_xpath = "(//*[contains(text(),'Capital Call')])[1]";
	String distribution_xpath = "(//h2[contains(text(),'Distribution')])[1]";
	String accounting_system_detail_xpath = "(//h2[contains(text(),'Accounting System Detail')])[1]";
	String txttransactionName = "//label[text()='Transaction name']/following-sibling::div/span/input";
	String amount_xpath = "//label[contains(text(),'Amount')]";

	String total_call_amount_xpath = "//input[@id='fcae7c03']";
	String total_distribution_amount_xpath = "//input[@id='41b38a77']";
	String net_amount_xpath = "(//span[text()='Net amount']/following-sibling::div/span/span)[1]";

	String transaction_types_xpath = "(//label[contains(text(),'Transaction type')]/following-sibling::div/div/input)[1]";
	String transaction_types_xpath2 = "(//label[contains(text(),'Transaction type')]/following-sibling::div/div/input)[2]";
	String dropDwn_Funddisbankacc = "(//label[contains(text(),'Fund distributing bank account')]/following-sibling::div/div/input)[1]";
	String inputbox_search = "(//input[@type='search'])[1]";

	String transaction_types1_xpath = "//input[@id='8042f366']";
	String transaction_types_list_xpath = "//div[@id='apresults-list']/ul/li";
	String deal_name_xpath = "//input[@id='52bfda49']";
	String deal_name_list_xpath = "//ul[@id='apresults-list']/li";
	String Position_xpath = "//input[@id='8f68d01f']";
	String Position_list_xpath = "//ul[@id='apresults-list']/li";
	String transaction_type_amount_xpath = "//input[@id='28fb48e5']";
	String allocation_rule_xpath = "//input[@id='d96105bd']";
	String allocation_rule_list_xpath = "//ul[@id='apresults-list']/li";

	String add_transaction_type_xpath = "(//a[contains(text(),'transaction type')])[1]";
	String delete_icon_xpath = "(//*[@id=\"RULE_KEY\"]/div/div[4]/div/div[2]/div/div/span/i)[2]";

	String notice_date_xpath = "//input[@id='65cffdb8']";
	String txtPeriodEndDate_xpath = "(//input[@name='$PpyWorkPage$pPeriodEndDate']/following-sibling::img)";
	String txtPeriodEndDate = "//label[text()='Period end date']/following-sibling::div/span/input";
	String txtPeriodEndDate_xpath1 = "(//button[@class='spin-button spin-down'])[1]";
	String txtPeriodEndDate_xpath2 = "//a[@data-day='26']";
	// "//label[text()='Period end date']/following-sibling::div/span/input";
	String txt_Transfereffectivedate = "//input[@id='65cffdb8']";
	String noticeDatePicker_xpath = "//*[@id='$PpyWorkPage$pTransactionData$l1$pNoticesDateSpan']/img";
	String noticeDate_xpath = "//td[@class='calcell today selected']";
	String dueDatePicker_xpath = "//*[@id='$PpyWorkPage$pTransactionData$l1$pSettlementDateSpan']/img";
	String due_date_xpath = "//td[@class='calcell today selected']/following-sibling::td[@class='calcell']";
	
	 String toDateXpath = "//tbody[@id='controlCalBody']//a[contains(@aria-label, '%s'  )]";
	 
	//String due_date_xpath = "//input[@name='$PpyWorkPage$pTransactionData$l1$pSettlementDate']";
	String lnk_clickhere_xpath = "(//a[normalize-space()='Click here'])[1]";
	String btnclose_xpath = "(//button[text()='Close'])[1]";

	String date_xpath = "//tbody[@id='controlCalBody']/tr/td";
	String month_xpath = "//tbody/tr[1]/td[1]/span[1]/input[1]";
	String month_uparrow_xpath = "//tbody/tr[1]/td[1]/span[1]/span[1]/button[1]";
	String year_xpath = "//tbody/tr[1]/td[3]/span[1]/input[1]";
	String year_uparrow_xpath = "//tbody/tr[1]/td[3]/span[1]/span[1]/button[1]";

	String save_button_xpath = "//button[contains(text(),'Save')]";
	String submit_button_xpath = "(//button[(text()='Submit')])[1]";
	String submit_button_xpath1 = "(//button[@id='ModalButtonSubmit'])[1]";
	String task_assign_xpath = "//strong[contains(text(),'Task assigned to: FSNA Client Services L2')]";

	String process_ID_search_xpath = "//label[text()='Search text']/following-sibling::div/span/input";
	String apply_xpath = "//button[contains(text(),'Apply')]";

	String CO_xpath = "(//button[@class='icons avatar name-c '])[1]";
	String log_off_xpath = "//span[@class='menu-item-title' and contains (text(),'Log off')]";

	String lnk_workbasketfilteredCaseId = "(//a[@data-ctl='Link'])[last()]";
	String work_queue_xpath = "//select[@name='$PpyPortalHarness$pWorkBasket']";

	// when case is created from client

	String lnkWorkbasket_CSL1 = "//option[contains(text(),'FSNA Client Services L1')]";
	String lnkWorkbasket_CSL2 = "//a[contains(text(),'FSNA Client Services L2')]";
	String lnkWorkbasket_COISl1 = "//a[contains(text(),'FSNA Central Operations IS L1')]";
	String lnkWorkbasket_COISl2 = "//a[contains(text(),'FSNA Central Operations IS L2')]";
	String lnkWorkbasket_COPPl1 = "//a[contains(text(),'FSNA Central Operations PP L1')]";
	String lnkWorkbasket_COPPl2 = "//a[contains(text(),'FSNA Central Operations PP L2')]";

//FOF
	String investment_dropdown_xpath = "(//input[@id='7a839f8e'])[1]";
	String investmentname_list_xpath = "//ul[@id='apresults-list']/li";
	String amount_to_commit_xpath = "//*[@id='fcae7c03']";
	String draft_xpath = "//label[contains(text(),'Draft')]";
	String executed_xpath = "//label[contains(text(),'Executed')]";
	String investment_details_preparation_pagetitle_xpath = "//span[contains(text(),'L1 - Investment Details Preparation')]";
	String transaction_name_fof_xpath = "//*[@id='66daa323']";
	String security_details_xpath = "//div[contains(text(),'Security & transaction details')]";
	String security_name_xpath = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pSecurityName']";
	String security_name_list_xpath = "//div[@id='apresults-list']/ul/li";
	String transactiontype_xpath = "//*[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l1$pType']";
	String list_transactiontype_xpath = "//div[@id='apresults-list']/ul/li";
	String amount_for_transaction_xpath = "//*[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l1$pAmount']";
	String amount_for_transactionFOF_xpath = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pAmount']";
	String amounttocommit_xpath = "//*[@name='$PpyWorkPage$pTransactionData$l1$pAmount']";
	String numberofshares_xpath = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTotalShares']";
	String tradedate_xpath = "//*[@name='$PpyWorkPage$pTransactionData$l1$pTradeDate']";
	String settlementdate_xpath = "//*[@name='$PpyWorkPage$pTransactionData$l1$pSettlementDate']";
	String securitytype_xpath = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pSecurityType']";
	String securitytype_list_xpath = "//div[@id='apresults-list']/ul/li";
	String bank_details_toggle_xpath = "(//input[@name='$PpyWorkPage$pTransactionData$l1$pValueGroup$gIsBankingDetailsProvided'])[2]";
	String bankname_xpath = "//input[@name='$PpyWorkPage$pBankAccountDetails$pBankName']";
	String bankaccount_xpath = "//input[@name='$PpyWorkPage$pBankAccountDetails$pBankaccount']";
	String country_xpath = "//input[@name='$PpyWorkPage$pBankAccountDetails$pAddress$ppyCountry']";
	String country_list_xpath = "//ul[@id='apresults-list']/li";
	String bank_swift_bic_code_xpath = "//input[@name='$PpyWorkPage$pBankAccountDetails$pSwiftNumber']";
	String securityname_xpath = "(//*[@class='anypicker-token-content'])[2]";
	String transaction_type_xpath = "(//*[@class='anypicker-token'])[3]/span";
	String PortalNavHeader_xpath = "(//button[@name='PortalNavHeader_pyPortalHarness_1'])[1]";
	String closeNavHeader_xpath = "(//button[@name='PortalNavHeader_pyPortalHarness_2'])[1]";
	String lnklogOff = "//span[contains(text(),'Log off')]";

	String pro_name = "//*[@id='RULE_KEY']/div/div[2]/div/div[5]/div";

	// FOFDisstribution Locators
	String drp_FOFDis_Distributingfund = "(//label[text()='Distributing fund']/following-sibling::div/div/input)[1]";
	String drp_FOFDis_Amountdistributed = "(//label[text()='Amount distributed']/following-sibling::div/span/input)[1]";
	String drp_FOFDis_Distributiontype = "(//label[text()='Distribution type']/following-sibling::div/div/input)[1]";
	String txt_FOFDis_Amountfortransaction = "(//label[text()='Amount per transaction']/following-sibling::div/span/input)[1]";
	String txt_FOFDis_Amountfortransaction2 = "(//label[text()='Amount per transaction']/following-sibling::div/span/input)[2]";
	String txt_FOFDis_Transactiontype = "//label[text()='Transaction type']/following-sibling::div/div/input";
	String txt_FOFDis_Duedate = "//label[text()='Due date']/following-sibling::div/span/input";
	String txt_Reject_comments = "//span[contains(text(),'Rejection comments:')]/following-sibling::div/span";
	String txt_clientReject_comments = "(//label[contains(text(),'Rejection comments:')])[1]/following-sibling::div";
	String txt_Client_Reject_comments = "//label[contains(text(),'Rejection comments:')]/following-sibling::div";
	String txt_Case360 = "//div[text()='Case 360']";
	String lnk_AuditHistory = "(//h3[text()='Audit History'])[1]";
	String txt_Inkinddistribution = "//span[contains(text(),'In-kind distribution') ]";
	String btnActions = "//button[@title='Actions']";
	String lnkTransferAss = "//span[text()='Transfer Assignment']";
	String txtTransferto = "//label[text()='Transfer To']/following-sibling::div/div/input";
	String searchInputBoxTransfer = "//input[@id='anypicker-input']";
	String btn_UseTemplate = "//span[text()='Use Template']";

	String drp_ProcessID_Select = "//label[text()='Process ID']/following-sibling::div//input";

	String drp_caseID_value = "(//label[text()='Process ID']/following-sibling::div[@class='anypicker-results']/ul//div/span)[1]";

	String btn_Search = "//button[text()='Search']";

	String txt_Description = "(//div[text()='Description']/following::tr/child::td[@data-attribute-name='Description']//span)[1]";

	String drp_Select = "//label[text()='Transaction Name']/following-sibling::div//input";

	String drp_list = "(//ul[@id='apresults-list']//span)[1]";

	String btn_Filter_Copy = "//button[text()='Copy']";

	//String txt_Status = "//label[text()='Status']/following-sibling::div/div/div/span";
	String txt_Status = "//span[contains (text(), '%s')]";

	String btn_Go = "//div[@String_type='field']/span/button[text()='Go']";

	String btn_AssignPriority = "//span[text()='Assign Priority']";

	String btn_ToggleOn = "//input[@name='$PpyWorkPage$pValueGroup$gCasePriority' and @type='checkbox']";

	String btn_CancelRequest = "//span[text()='Cancel Request']";

	String txa_CanclReqRsn = "//textarea[@name='$PpyWorkPage$pCancelRequestReason']";

	String btn_Filter_CancelCase = "//span[text()='Pending - Cancel']";

	String btn_ReviewDecision_Approve = "//label[text()='Review decision']/following-sibling::div//span/label[text()='Approve']";

	String txa_intlComments = "//textarea[@name='$PpyWorkPage$pInternalComment']";

	String btn_FinalSubmit = "//button[contains(text(),'Submit')]";
	String txt_Priority = "//div[text()='Priority']/following::tr/td[7]/span";
	String phaseandStatus_ID_xpath = "//a[@aria-label='Phase/Status Actions']";
	String phaseStatusApplyFilterButton = "(//span[text()='Apply filter'])[2]";
	String pendingCancel_xpath = "(//div[contains(text(),'Pending - Cancel')]/preceding-sibling::div/input)[2]";
	String L1CashReconciliation_xpath = "(//div[contains(text(),' L1 - Cash Reconciliation')]/preceding-sibling::div/input)[2]";
	String L1OpenCapitalActivity_xpath = "(//div[contains(text(),'L1 - Open Capital Activity')]/preceding-sibling::div/input)[2]";
	String L1Drafting_xpath = "(//div[contains(text(),'L1 - Draft Reporting')]/preceding-sibling::div/input)[2]";

	// Direct Investment Sale
	String lnk_DrctInvSale = "//span[text()='Direct Investment Sale']";
	String btn_Executed = "//label[contains(text(),'Executed')]";
	String btn_Draft = "//label[contains(text(),'Draft')]";
	String txt_DrctInvSle_L1Review = "//span[contains(text(),'L1 Sale Of Investment Review')]";
	String btn_approveXpath = "//label[contains(text(),'Approve')]";
	String txa_DrctInvSle_Transactionname = "//input[@name='$PpyWorkPage$pTransactionData$l1$pTransactionName']";
	String txa_DrctInvSle_AmtToSell = "//input[@name='$PpyWorkPage$pTransactionData$l1$pAmount']";
	String drp_DrctInvSle_SecurityName = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pSecurityName']";
	String drp_DrctInvSle_TransactionType = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l1$pType']";
	String drp_DrctInvSle_List = "//ul[@id='apresults-list']/li";
	String txt_DrctInvSle_amountForTransaction = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l1$pAmount']";
	String tradeDatepicker_xpath = "//*[@id='$PpyWorkPage$pTransactionData$l1$pTradeDateSpan']/img";
	String tradedate = "//*[@name='$PpyWorkPage$pTransactionData$l1$pTradeDate']";
	String sttlementDatepicker_xpath = "//*[@id='$PpyWorkPage$pTransactionData$l1$pSettlementDateSpan']/img";
	String settlementdate = "//*[@name='$PpyWorkPage$pTransactionData$l1$pSettlementDate']";
	String drp_DrctInvSle_Distributingfund = "//input[@name='$PpyWorkPage$pTransactionData$l1$pFund']";
	String drp_DrctInvSle_DistributingFundValues = "//ul[@role='tree']/li";
	String drp_DrctInvSle_Invstmnt_List = "//input[@name='$PpyWorkPage$pTransactionData$l1$pOperationName']";
	String drp_DrctInvSle_Invstmnt_ListValues = "//ul[@role='tree']/li";
	String drp_DrctInvSle_SecondTransactionType = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l2$pType']";
	String drp_DrctInvSle_ThirdTransactionType = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l3$pType']";
	String txt_DrctInvSle_amountForSecondTransaction = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l2$pAmount']";
	String txt_DrctInvSle_amountForThirdTransaction = "//input[@name='$PpyWorkPage$pSecurityDetails$l1$pTransactionTypes$l3$pAmount']";
	String btn_DrctInvSle_additionalTransactionType = "//a[@name='InvSaleSecurityAndTransactionDetails_pyWorkPage.SecurityDetails(1)_17']";
	String drp_SelectedTransactionType = "//label[text()='Transaction type']/following::div//span[@class='anypicker-token']/span";
	String drp_SecondSelectedTransactionType = "(//label[text()='Transaction type']/following::div//span[@class='anypicker-token']/span)[2]";
	String drp_ThirdSelectedTransactionType = "(//label[text()='Transaction type']/following::div//span[@class='anypicker-token']/span)[3]";
	String initiationPageVerify = "//span[@class='ad_primary_title']";
	String icon_Loading = "//div[@class='loader']";
	
	String drp_firstValueFunddisbankacc = "(//div[@id='apresults-list']//ul//li[@role='treeitem'])[1]";

	// FOF Capital Call
	String txt_TransactionName = "//input[@name='$PpyWorkPage$pTransactionData$l1$pTransactionName']";
	String txt_AmtToBePaid = "//input[@name='$PpyWorkPage$pTransactionData$l1$pAmount']";
	String drp_InvestmentFund = "//input[@name='$PpyWorkPage$pTransactionData$l1$pSubFund']";
	String drp_Position = "//input[@id='cfc70899']";
	String txt_accNo = "//input[@name='$PpyWorkPage$pTransactionData$l1$pBankAccountDetails$pAccountNumber']";
	String txt_ABAno = "//input[@name='$PpyWorkPage$pTransactionData$l1$pBankAccountDetails$pAbaCode']";
	String txt_SWIFTno = "//input[@name='$PpyWorkPage$pTransactionData$l1$pBankAccountDetails$pSwiftNumber']";
	String drp_FoF_TransactionType = "//input[@name='$PpyWorkPage$pTransactionTypes$l1$pType']";
	String drp_FoF_List = "//div[@id='apresults-list']/ul/li";
	String txt_FoF_amountForTransaction = "//input[@name='$PpyWorkPage$pTransactionTypes$l1$pAmount']";
	String btn_FoF_additionalTransactionType = "//a[@name='DisplayTransactionTypes_pyWorkPage_8']";
	String drp_FoF_SecondTransactionType = "//input[@name='$PpyWorkPage$pTransactionTypes$l2$pType']";
	String txt_FoF_amountForSecondTransaction = "//input[@name='$PpyWorkPage$pTransactionTypes$l2$pAmount']";
	String drp_FoF_ThirdTransactionType = "//input[@name='$PpyWorkPage$pTransactionTypes$l3$pType']";
	String txt_FoF_amountForThirdTransaction = "//input[@name='$PpyWorkPage$pTransactionTypes$l3$pAmount']";
	String drp_FOFcapcurrency = "//input[@name='$PpyWorkPage$pTransactionData$l1$pCurrency']";
	String drp_FOFissuing_account = "//input[@name='$PpyWorkPage$pTransactionData$l1$pIssuingAccount']";
	String drp_firstValueIssuingAcc = "(//div[@id='apresults-list']//ul//li[@role='treeitem'])[1]";
	String txt_FOFcapinitiationScreen = "//div[@data-context='pyWorkPage'][1]/span";

	// DIP
	String btn_DIP_additionalTransactionType = "//a[@name='SecurityAndTransactionDetails_pyWorkPage.SecurityDetails(1)_26']";

	// PER
	String dropFundRep = "(//label[text()='Fund']/following-sibling::div)[1]";
	String dropClientdRep = "(//label[text()='Client']/following-sibling::div)[1]";
	String lnkTabMasterchklist = "(//h3[text()='Master Checklist']/i)[1]";
	String lnkTabFunderchklist = "(//h3[text()='Fund Level Checklist']/i)[1]";
	String imgUpload = "(//a[text()='Upload']/img)[1]";
	String txtPeriodendreportingdes = "//label[text()='Period end reporting description']/following-sibling::div/span/input";
	String listPERFund = "(//i[@class='caret-down-img'])[1]";
	String listApplicabletimetable = "(//i[contains(@class,'caret-down')])[2]";
	String txtDescription1 = "(//label[text()='Description']/following-sibling::div/span/span/textarea)[1]";
	String txtDescription2 = "(//label[text()='Description']/following-sibling::div/span/span/textarea)[2]";
	String txtDescription3 = "(//label[text()='Description']/following-sibling::div/span/span/textarea)[3]";
	String txtDescription4 = "(//label[text()='Description']/following-sibling::div/span/span/textarea)[4]";
	String chkbxPer = "//input[@type='checkbox']/following-sibling::label[@class='chkbxCaptionRight']";
	String btn_toggle_finStatements = "//div[text()='Will the financial statements be consolidated for all funds in scope?']/following::input[@name='$PpyWorkPage$pValueGroup$gIsfinancialstatementconsolidated' and @type='checkbox']";
	String clientFinStatemnts_click_filter = "(//div[contains(text(),'Client - Financial Statements')]/preceding-sibling::div/input)[2]";
}
