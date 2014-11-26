package com.linhnguyen.test;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class CheckNotification {
	public static void openNotificationPanel() {
		UiDevice.getInstance().openNotification();
	}

	public static void checkNotificationFileUploaded(final UiAutomatorTestCase test,final String fileName) {
		UiScrollable notiPanel = new UiScrollable(new UiSelector()
				.className("android.widget.ScrollView")
				.resourceId("com.android.systemui:id/scroll").scrollable(false));

		UiSelector notiSelector;
		notiSelector = new UiSelector().className(
				android.widget.TextView.class.getName()).resourceId(
				"android:id/title");

		UiObject notiFileUploaded;

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(5000);
				notiFileUploaded = notiPanel.getChildByText(notiSelector,
						fileName);
				
				if(notiFileUploaded != null){
					test.getUiDevice().pressBack();
					break;
				}
			} catch (Exception e) {
				System.out.println("Did not find match for "
						+ e.getLocalizedMessage());
				test.getUiDevice().pressBack();
			}
		}
		// if(i == 5) && notiFileUploaded == null ==> stop testing
	}

}
