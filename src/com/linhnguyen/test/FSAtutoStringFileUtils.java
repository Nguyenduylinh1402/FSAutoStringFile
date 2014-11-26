package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSAtutoStringFileUtils {

	private final static String APPTRAY_MOTOROLA = "Apps";
	private final static String APPTRAY_SAMSUNG_TAB = "Applications";
	private final static String APPTAB_MOTOROLA = "Apps";
	private final static String APPTAB_SAMSUNG_TAB = "Apps";
	// Scroll không có className không scroll list nhé
	public static UiScrollable folderResourceScrollable = new UiScrollable(
			new UiSelector().className("android.widget.ListView").scrollable(
					true));

	public static void clickHomeButton(final UiAutomatorTestCase test) {
		test.getUiDevice().pressHome();
	}

	public static void wakeUpDevice(final UiAutomatorTestCase test) {
		try {
			if (!test.getUiDevice().isScreenOn()) {
				test.getUiDevice().wakeUp();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void openApplication(final UiAutomatorTestCase test,
			final String appName) throws UiObjectNotFoundException {
		wakeUpDevice(test);
		clickHomeButton(test);

		UiObject appTray = new UiObject(
				new UiSelector().description(APPTRAY_MOTOROLA));
		appTray.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector().text(APPTAB_MOTOROLA));
		appsTab.clickAndWaitForNewWindow();

		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();

		int maxSearchSwipes = appViews.getMaxSearchSwipes();
		UiSelector selector;
		selector = new UiSelector().className(android.widget.TextView.class
				.getName());
		UiObject appToLaunch;

		for (int i = 0; i < maxSearchSwipes; i++) {
			appToLaunch = appViews.getChildByText(selector, appName);
			if (appToLaunch != null) {
				appToLaunch.clickAndWaitForNewWindow();
				break;
			}

			for (int j = 0; j < i; j++) {
				appViews.scrollForward();
			}
		}
	}

	public static void clickMenuStringFile(final String text)
			throws UiObjectNotFoundException {
		// Menu String file
		UiObject menuStringFile = new UiObject(
				new UiSelector()
						.className("android.widget.TextView")
						.resourceId(
								"com.filestring.lattedouble:id/menu_files_list_action_add")
						.description("Add"));
		menuStringFile.clickAndWaitForNewWindow();
	}

	// Test with samsung
	public static void clickMenuStringFileSamSung(final String text)
			throws UiObjectNotFoundException {
		// UiDevice.getInstance().openNotification();
		// Menu String file
		UiObject menuStringFile = new UiObject(new UiSelector().className(
				"android.view.View").resourceId("android:id/action_bar"));

		UiObject menu = menuStringFile.getChild(new UiSelector().resourceId(
				"com.filestring.lattedouble:id/menu_files_list_action_add")
				.className("android.widget.TextView"));
		menu.clickAndWaitForNewWindow();
	}

	public static void clickStringAfile(final String text)
			throws UiObjectNotFoundException {
		UiObject stringAFile = new UiObject(new UiSelector().resourceId(
				"com.filestring.lattedouble:id/string_file").text(text));
		stringAFile.clickAndWaitForNewWindow();
	}

	public static void clickFileManager(final String text)
			throws UiObjectNotFoundException {
		// File Manager
		UiObject fileManager = new UiObject(new UiSelector().resourceId(
				"com.filestring.lattedouble:id/source_title").text(text));
		fileManager.clickAndWaitForNewWindow();
	}

	// get Folder container//scroll add more
	public static void findFolderResource(final String text)
			throws UiObjectNotFoundException {

		folderResourceScrollable.setAsVerticalList();

		UiObject folderResource = folderResourceScrollable.getChildByText(
				new UiSelector().className("android.widget.TextView")
						.resourceId("com.rhmsoft.fm:id/name"), text);
		folderResource.clickAndWaitForNewWindow();

	}

	public static void findFileResource(final String text)
			throws UiObjectNotFoundException {
		folderResourceScrollable.setAsVerticalList();
		UiObject file = folderResourceScrollable.getChildByText(
				new UiSelector().className("android.widget.TextView")
						.resourceId("com.rhmsoft.fm:id/name"), text);
		file.clickAndWaitForNewWindow();
	}

	public static void clickEnterEmail(final String emailAdressID,
			final String emailAdress) throws UiObjectNotFoundException {
		UiObject stringfileParent = new UiObject(
				new UiSelector().className("android.view.View"));
		UiObject emailEditText = stringfileParent.getChild(new UiSelector()
				.className("android.widget.EditText").text(emailAdressID));

		int x = stringfileParent.getChildCount();
		// UiScrollable clickEnterEmailScrollable = new UiScrollable(
		// new UiSelector());
		// UiObject emailEditText = clickEnterEmailScrollable.getChildByText(
		// new UiSelector().className("android.widget.EditText"),
		// emailAdressID);
		emailEditText.clickAndWaitForNewWindow();
		emailEditText.setText(emailAdress);
	}

	public static void clickSendStringFile(final String text)
			throws UiObjectNotFoundException {
		// Send String File
		UiObject sendStringFile = new UiObject(
				new UiSelector().description(text));
		sendStringFile.clickAndWaitForNewWindow();
	}

	public static void checkFileInAllFile(final UiAutomatorTestCase test,
			final String fileName) {

		UiScrollable scrollableAllFile = new UiScrollable(new UiSelector()
				.className("android.widget.ListView").scrollable(true));

		UiSelector fileSelector;
		fileSelector = new UiSelector().className(android.widget.TextView.class
				.getName());
		UiObject fileCatch;

		for (int i = 0; i < 10; i++) {

			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fileCatch = scrollableAllFile.getChildByText(fileSelector,
						fileName, true);

				if (fileCatch != null) {
					Logger.d(FSAtutoStringFileUtils.class.getName(), "File: "
							+ fileName + " Here");
					// fileCatch.clickAndWaitForNewWindow();
					break;
				}
			} catch (UiObjectNotFoundException e) {
				System.out.println("Did not find match for "
						+ e.getLocalizedMessage());
				// test.getUiDevice().pressBack();
			}

		}

	}

}
