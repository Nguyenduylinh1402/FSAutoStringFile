package com.linhnguyen.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class FSSignIn {

	// Global variable

	public static void testSignIn(final String email, final String password)
			throws UiObjectNotFoundException {
		UiScrollable appView = new UiScrollable(new UiSelector().className(
				"android.view.View").scrollable(true));

		UiObject emailSignIn = new UiObject(
				new UiSelector()
						.resourceId("com.filestring.lattedouble:id/edtSignInEmail"));

		UiObject passwordSignIn = new UiObject(
				new UiSelector()
						.resourceId("com.filestring.lattedouble:id/edtSignInPassword"));

		UiObject signIn = new UiObject(
				new UiSelector()
						.resourceId("com.filestring.lattedouble:id/btnSignIn"));

		if (emailSignIn.exists()) {
			emailSignIn.click();
			emailSignIn.setText(email);
		}
		if (passwordSignIn.exists()) {
			passwordSignIn.click();
			passwordSignIn.setText(password);
		}
		if (signIn.exists()) {
			signIn.clickAndWaitForNewWindow(10000);
		}
	}
}
