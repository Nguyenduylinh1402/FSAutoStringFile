package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSAtutoStringFileUtils {
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

	public final static void openApplication(final UiAutomatorTestCase test,
			final String appName) throws UiObjectNotFoundException {
		wakeUpDevice(test);
		clickHomeButton(test);
		
		UiObject appTray = new UiObject(new UiSelector().description("Apps"));
		appTray.clickAndWaitForNewWindow();
		
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.clickAndWaitForNewWindow();
		
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		
		int maxSearchSwipes = appViews.getMaxSearchSwipes();
		UiSelector selector;
		selector = new UiSelector().className(android.widget.TextView.class.getName());
		UiObject appToLaunch;
		
		for(int i = 0; i < maxSearchSwipes; i ++){
			appToLaunch = appViews.getChildByText(selector, appName);
			if(appToLaunch != null){
				appToLaunch.clickAndWaitForNewWindow();
				break;
			}
			
			for(int j = 0; j < i; j ++){
				appViews.scrollForward();
			}
		}
	}

}
