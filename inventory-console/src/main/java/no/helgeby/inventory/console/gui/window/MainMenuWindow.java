package no.helgeby.inventory.console.gui.window;

import java.util.Arrays;

public class MainMenuWindow extends MenuWindow {

	public MainMenuWindow(MenuAction actionListener) {
		this.setTitle("Inventory Main Menu");

		addMenuItem("New", "Creates a new inventory database.", "new");
		addMenuItem("Open", "Opens an inventory database.", "open");
		addMenuItem("Exit", "Terminates the application.", "exit");

		setFocusedInteractable(buttons.get(0));
		setActionListener(actionListener);
		setHints(Arrays.asList(Hint.CENTERED));
	}

}
