package no.helgeby.inventory.console;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import no.helgeby.inventory.console.gui.MainGUI;

public class Main {

	private static final Log logger = LogFactory.getLog(Main.class);

	public static void main(String[] args) {
		try {
			logger.info("Setting up terminal.");
			Terminal terminal = new DefaultTerminalFactory().createTerminal();
			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();

			logger.info("Starting GUI.");
			MainGUI gui = MainGUI.create(screen);
			gui.showMainMenuAndWait();

			logger.info("Stopping.");
			screen.close();
			terminal.close();
		} catch (IOException e) {
			logger.error("IO error in terminal.", e);
		}
	}
}
