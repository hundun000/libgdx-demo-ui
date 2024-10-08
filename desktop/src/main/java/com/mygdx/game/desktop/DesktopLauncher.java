package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.core.MyHundunGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
	    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		new Lwjgl3Application(new MyHundunGame(640, 480, new DesktopPreferencesSaveTool("libgdx-demo-desktop-save.xml")), config);
	}
}
