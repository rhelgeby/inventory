package no.helgeby.inventory.console.gui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowManager;
import com.googlecode.lanterna.screen.Screen;

import no.helgeby.inventory.console.gui.window.InventoryMenuWindow;
import no.helgeby.inventory.console.gui.window.MainMenuWindow;
import no.helgeby.inventory.console.gui.window.MenuAction;

public class MainGUI extends MultiWindowTextGUI implements MenuAction {

	private static final Log logger = LogFactory.getLog(MainMenuWindow.class);

	private BasicWindow menuWindow;

	public static MainGUI create(Screen screen) {
		MainGUI mainWindow = new MainGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.CYAN));
		return mainWindow;
	}

	public MainGUI(Screen screen, WindowManager windowManager, Component background) {
		super(screen, windowManager, background);
		menuWindow = new MainMenuWindow(this);

	}

	public void showMainMenuAndWait() {
		addWindow(menuWindow);
		setActiveWindow(menuWindow);
		waitForWindowToClose(menuWindow);
	}

	@Override
	public void onMenuAction(String actionName) {
		switch (actionName) {
		case "new":
			onNewClicked();
			break;
		case "open":
			onOpenClicked();
			break;
		case "exit":
			onExitClicked();
			break;
		default:
			throw new IllegalArgumentException("Unexpected action name: " + actionName);
		}
	}

	private void onNewClicked() {
		logger.info("New clicked.");
		InventoryMenuWindow inventoryMenuWindow = new InventoryMenuWindow();
		addWindow(inventoryMenuWindow);
	}

	private void onOpenClicked() {
		logger.info("Open clicked.");
	}

	private void onExitClicked() {
		menuWindow.close();
	}
}
