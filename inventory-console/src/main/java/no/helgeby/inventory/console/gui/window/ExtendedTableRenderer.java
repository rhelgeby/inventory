package no.helgeby.inventory.console.gui.window;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableRenderer;

/**
 * Exposes some internal fields in the renderer using reflection.
 */
public class ExtendedTableRenderer<V> implements TableRenderer<V> {

	private static final Log logger = LogFactory.getLog(ExtendedTableRenderer.class);

	private final TableRenderer<V> renderer;
	private final Field columnSizesField;
	private final Field rowSizesField;

	public ExtendedTableRenderer(TableRenderer<V> tableRenderer) {
		this.renderer = tableRenderer;

		columnSizesField = FieldUtils.getField(renderer.getClass(), "columnSizes", true);
		if (columnSizesField == null) {
			throw new IllegalArgumentException("Could not find columnSizes field in the source class.");
		}
		rowSizesField = FieldUtils.getField(renderer.getClass(), "rowSizes", true);
		if (rowSizesField == null) {
			throw new IllegalArgumentException("Could not find rowSizes field in the source class.");
		}
	}

	@Override
	public TerminalPosition getCursorLocation(Table<V> component) {
		return renderer.getCursorLocation(component);
	}

	@Override
	public void drawComponent(TextGUIGraphics graphics, Table<V> component) {
		renderer.drawComponent(graphics, component);
	}

	@Override
	public TerminalSize getPreferredSize(Table<V> component) {
		return renderer.getPreferredSize(component);
	}

	public List<Integer> getColumnSizes() {
		try {
			@SuppressWarnings("unchecked")
			List<Integer> value = (List<Integer>) columnSizesField.get(renderer);
			return Collections.unmodifiableList(value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error("Could not get columnSizes field in renderer.", e);
			return null;
		}
	}

	public List<Integer> getRowSizes() {
		try {
			@SuppressWarnings("unchecked")
			List<Integer> value = (List<Integer>) rowSizesField.get(renderer);
			return Collections.unmodifiableList(value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error("Could not get columnSizes field in renderer.", e);
			return null;
		}
	}
}
