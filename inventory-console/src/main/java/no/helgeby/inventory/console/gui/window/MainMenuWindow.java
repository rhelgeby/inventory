package no.helgeby.inventory.console.gui.window;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainMenuWindow extends MenuWindow implements MenuAction {

	private static final Log logger = LogFactory.getLog(MainMenuWindow.class);

	public MainMenuWindow() {
		this.setTitle("Inventory Main Menu");

		addMenuItem("New", "Creates a new inventory database.", "new");
		addMenuItem("Open", "Opens an inventory database.", "open");
		addMenuItem("Exit", "Terminates the application.", "exit");

		setFocusedInteractable(buttons.get(0));
		setActionListener(this);
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
	}

	private void onOpenClicked() {
		logger.info("Open clicked.");
	}

	private void onExitClicked() {
		MainMenuWindow.this.close();
	}
}
