package no.helgeby.inventory.sandbox;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConsoleTest {

	private static final Log logger = LogFactory.getLog(ConsoleTest.class);

	public static void main(String[] args) {
		try {
			Terminal terminal;
			terminal = new DefaultTerminalFactory().createTerminal();
			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();

			Panel panel = new Panel();
			panel.setPreferredSize(new TerminalSize(30, 10));

			panel.addComponent(new Label("Name"));
			TextBox txtName = new TextBox();
			panel.addComponent(txtName);

			panel.addComponent(new Label("Password"));
			TextBox txtPassword = new TextBox();
			txtPassword.setMask('*');
			panel.addComponent(txtPassword);

			panel.addComponent(new EmptySpace());
			Button btnLogin = new Button("Login");
			panel.addComponent(btnLogin);

			Button btnExit = new Button("Exit", new Runnable() {
				@Override
				public void run() {
					System.exit(0);
				}
			});
			panel.addComponent(btnExit);

			GridLayout layout = new GridLayout(2);
			layout.setHorizontalSpacing(2);
			layout.setVerticalSpacing(1);
			panel.setLayoutManager(layout);

			BasicWindow window = new BasicWindow();
			window.setComponent(panel);

			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen,
					new DefaultWindowManager(), new EmptySpace(
							TextColor.ANSI.BLUE));
			gui.addWindowAndWait(window);
		} catch (IOException e) {
			logger.error("IO error in terminal.", e);
		}
	}
}
