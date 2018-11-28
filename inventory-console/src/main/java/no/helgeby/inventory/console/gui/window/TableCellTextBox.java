package no.helgeby.inventory.console.gui.window;

import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.input.KeyStroke;

public class TableCellTextBox extends TextBox {

	private TextBoxListener listener;

	public TableCellTextBox() {
		setVerticalFocusSwitching(false);
		setHorizontalFocusSwitching(false);
	}

	@Override
	public synchronized Result handleKeyStroke(KeyStroke keyStroke) {
		switch (keyStroke.getKeyType()) {
		case Enter:
			if (listener != null) {
				listener.onUpdate(getText());
				return Result.HANDLED;
			}
		case Escape:
			if (listener != null) {
				listener.onCancel();
				return Result.HANDLED;
			}
		case Tab:
		case ReverseTab:
			return Result.HANDLED;
		default:
		}
		return super.handleKeyStroke(keyStroke);
	}

	public void setListener(TextBoxListener listener) {
		this.listener = listener;
	}
}
