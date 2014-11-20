package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSAtutoStringFileUtils {
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

		UiObject appTray = new UiObject(new UiSelector().description("Apps"));
		appTray.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
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
		UiObject menuStringFile = new UiObject(new UiSelector().resourceId(
				"com.filestring.lattedouble:id/menu_files_list_action_add")
				.description("Add"));
		menuStringFile.clickAndWaitForNewWindow();
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
				new UiSelector().className("android.widget.TextView"), text);
		folderResource.clickAndWaitForNewWindow();

	}

	public static void findFileResource(final String text)
			throws UiObjectNotFoundException {
		folderResourceScrollable.setAsVerticalList();
		UiObject file = folderResourceScrollable.getChildByText(
				new UiSelector(), text);
		file.clickAndWaitForNewWindow();
	}

	public static void clickEnterEmail(final String emailAdressID,
			final String emailAdress) throws UiObjectNotFoundException {
		UiScrollable clickEnterEmailScrollable = new UiScrollable(
				new UiSelector());
		UiObject emailEditText = clickEnterEmailScrollable.getChildByText(
				new UiSelector().className("android.widget.EditText"),
				emailAdressID);
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

		for (int i = 0; i < 5; i++) {

			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fileCatch = scrollableAllFile.getChildByText(fileSelector,
						fileName, true);

				if (fileCatch != null) {
					fileCatch.clickAndWaitForNewWindow();
					break;
				}
			} catch (UiObjectNotFoundException e) {
				System.out.println("Did not find match for "
						+ e.getLocalizedMessage());
				//test.getUiDevice().pressBack();
			}

		}

	}

}
