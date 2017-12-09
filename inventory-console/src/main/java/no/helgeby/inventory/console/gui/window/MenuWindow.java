package no.helgeby.inventory.console.gui.window;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

public abstract class MenuWindow extends BasicWindow {

	protected Panel panel;
	protected List<Button> buttons;

	private MenuAction actionListener;

	public MenuWindow() {
		super();
		panel = new Panel();
		
		GridLayout layout = new GridLayout(2);
		layout.setTopMarginSize(1);
		layout.setBottomMarginSize(1);
		layout.setLeftMarginSize(2);
		layout.setRightMarginSize(2);
		layout.setHorizontalSpacing(2);
		layout.setVerticalSpacing(1);
		panel.setLayoutManager(layout);
		
		this.setComponent(panel);
		buttons = new ArrayList<>();
	}

	public void addMenuItem(String title, String description, String actionName) {
		Button button = new Button(title, new MenuActionListener(actionName));
		buttons.add(button);
		panel.addComponent(button);
		Label label = new Label(description);
		label.setForegroundColor(TextColor.ANSI.BLUE);
		panel.addComponent(label);
	}

	private class MenuActionListener implements Runnable {

		private String actionName;
		private MenuActionListener(String actionName) {
			this.actionName = actionName;
		}

		@Override
		public void run() {
			actionListener.onMenuAction(actionName);
		}
		
	}

	public void setActionListener(MenuAction actionListener) {
		this.actionListener = actionListener;
	}

}