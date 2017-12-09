package no.helgeby.inventory.console.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowManager;
import com.googlecode.lanterna.screen.Screen;

import no.helgeby.inventory.console.gui.window.MainMenuWindow;

public class MainGUI extends MultiWindowTextGUI {

	private BasicWindow menuWindow;

	public static MainGUI create(Screen screen) {
		MainGUI mainWindow = new MainGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.CYAN));
		return mainWindow;
	}

	public MainGUI(Screen screen, WindowManager windowManager, Component background) {
		super(screen, windowManager, background);
		menuWindow = new MainMenuWindow();
		addWindow(menuWindow);
	}

	public void showMainMenuAndWait() {
		setActiveWindow(menuWindow);
		getFocusedInteractable();
		waitForWindowToClose(menuWindow);
	}
}
