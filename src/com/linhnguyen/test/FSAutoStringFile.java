package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSAutoStringFile extends UiAutomatorTestCase {
	private final static String APP_NAME = "FileString";
	private final static String EMAIL_1 = "sta003@yopmail.com";
	private final static String EMAIL_2 = "sta004@yopmail.com";
	private final static String PASSWORD = "1234";
	private final static String MENU_STRING_FILE = "Add";
	private final static String STRING_A_FILE = "String a File";
	private final static String FILE_MANAGER = "File Manager";
	private final static String FOLDER_RESOURCE = "data";
	private final static String FOLDER_RESOURCE_SAMSUNG = "Download";
	private final static String EMAIL_ADRESS_ID = "Type Names or Email Addresses";
	private final static String FILE_NAME_0 = "Screenshot taosua4.png";
	private final static String FILE_NAME_1 = "Chuyen Mua - Trung Quan Idol.mp3";
	private final static String FILE_NAME_2 = "Can do list_softskills.docx";
	private final static String FILE_NAME_3 = "PL_09_Presentation_skill - VN.pptx";
	private final static String FILE_NAME_4 = "PL_14_Dealing with customer_Client relation.pptx";
	private final static String FILE_NAME_5 = "timetable-PNV2M & 2T_week 36.xls";
	private final static String FILE_NAME_6 = "PL_20_Task priority planning.pptx";
	private final static String FILE_NAME_7="Avtivities.pdf";
	private final static String FILE_NAME_8 = "Ca phe cung Tony - Tony Buoi Sang.pdf";
	private final static String FILE_NAME_9 = "English Classes-Elementary.pdf";
	
	private final static String FILE_NAME_10 = "Lam_the_nao_de_dich_chuyen_nui_Phu_Si.pdf";
	
	private final static String SEND_STRING_FILE = "Send";
	private final static String FILE_UPLOADED_SUCCESSFUL = "File uploaded";
	private final static String FILE_UPLOADED_FAILED = "Upload file failed";

	public void testFSAutoStringFile() throws UiObjectNotFoundException,
			RemoteException {
		Logger.d(FSAutoStringFile.class.getName(), "Start Testing");
		Logger.d(FSAutoStringFile.class.getName(), "Open FileString App");
		FSAtutoStringFileUtils.openApplication(this, APP_NAME);
		Logger.d(FSSignIn.class.getName(), "Sign In");
		FSSignIn.testSignIn("sta003@yopmail.com", "1234");
		FSAtutoStringFileUtils.clickMenuStringFile(MENU_STRING_FILE);
		FSAtutoStringFileUtils.clickStringAfile(STRING_A_FILE);
		FSAtutoStringFileUtils.clickFileManager(FILE_MANAGER);
		Logger.d(FSAtutoStringFileUtils.class.getName(), "Find Folder Resource :" + "data");
		FSAtutoStringFileUtils.findFolderResource(FOLDER_RESOURCE);
		Logger.d(FSAtutoStringFileUtils.class.getName(), "Find File Resource :" + FILE_NAME_0);
		FSAtutoStringFileUtils.findFileResource(FILE_NAME_0);
		Logger.d(FSAtutoStringFileUtils.class.getName(), "Enter Email Recipient :" + EMAIL_2);
		FSAtutoStringFileUtils.clickEnterEmail(EMAIL_ADRESS_ID, EMAIL_2);
		FSAtutoStringFileUtils.clickSendStringFile(SEND_STRING_FILE);
		Logger.d(FSAutoStringFile.class.getName(), "Open Notification Bar");
		CheckNotification.openNotificationPanel();
		Logger.d(FSAutoStringFile.class.getName(), "Check File Uploaded");
		CheckNotification.checkNotificationFileUploaded(this, FILE_UPLOADED_SUCCESSFUL);
		Logger.d(FSAutoStringFile.class.getName(), "File Uploaded");
		Logger.d(FSAutoStringFile.class.getName(),
				"Check File Upload in All File");
		FSAtutoStringFileUtils.checkFileInAllFile(this, FILE_NAME_0);
		Logger.d(FSAtutoStringFileUtils.class.getName(), "Sign Out");
		FSSignOut.signOut(this);
		Logger.d(FSAtutoStringFileUtils.class.getName(), "Sign Out Success");
	

	}
}
