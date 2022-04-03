package com.broken_e.ui.testapp.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.broken_e.ui.testapp.TestApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
	    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		new Lwjgl3Application(new TestApp(), config);
	}
}
