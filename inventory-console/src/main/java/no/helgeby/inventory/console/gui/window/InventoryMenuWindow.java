package no.helgeby.inventory.console.gui.window;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InventoryMenuWindow extends MenuWindow implements MenuAction {

	private static final Log logger = LogFactory.getLog(InventoryMenuWindow.class);

	public InventoryMenuWindow() {
		this.setTitle("Inventory");

		addMenuItem("Product types", "Manage product types.", "productTypes");
		addMenuItem("Close", "Closes the inventory.", "close");

		setFocusedInteractable(buttons.get(0));
		setActionListener(this);
		setCloseWindowWithEscape(true);
	}

	@Override
	public void onMenuAction(String actionName) {
		switch (actionName) {
		case "productTypes":
			onProductTypesClicked();
			break;
		case "close":
			onCloseClicked();
			break;
		default:
			throw new IllegalArgumentException("Unexpected action name: " + actionName);
		}
	}

	private void onProductTypesClicked() {
		logger.info("Product types clicked.");
	}

	private void onCloseClicked() {
		this.close();
	}
}
