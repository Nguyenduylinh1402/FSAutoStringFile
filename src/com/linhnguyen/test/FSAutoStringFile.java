package com.linhnguyen.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FSAutoStringFile extends UiAutomatorTestCase {
	private final static String APP_NAME = "FileString";

	public void testFSAutoStringFile() throws UiObjectNotFoundException,
			RemoteException {
		Logger.d(FSAutoStringFile.class.getName(), "Start Testing");
		Logger.d(FSAutoStringFile.class.getName(), "Open FileString App");
		FSAtutoStringFileUtils.openApplication(this, APP_NAME);
		
	}
}
