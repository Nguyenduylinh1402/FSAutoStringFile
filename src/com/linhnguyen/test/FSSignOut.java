package com.linhnguyen.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSSignOut {
	public static void signOut(final UiAutomatorTestCase test)
			throws UiObjectNotFoundException {
		UiObject hamberger = new UiObject(new UiSelector().resourceId(
				"android:id/up").className("android.widget.ImageView"));
		hamberger.click();

		UiObject info = new UiObject(new UiSelector().resourceId(
				"com.filestring.lattedouble:id/drawer_email").className(
				"android.widget.TextView"));
		info.clickAndWaitForNewWindow();

		UiObject signout = new UiObject(
				new UiSelector().text("Sign Out from FileString"));
		signout.clickAndWaitForNewWindow();
	}
}
