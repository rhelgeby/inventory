package no.helgeby.inventory.console.gui.window;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.AbsoluteLayout;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.BorderLayout.Location;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;
import com.googlecode.lanterna.gui2.table.TableModel.Listener;

import no.helgeby.inventory.model.ProductType;

public class ProductTypeWindow extends BasicWindow {

	private static final Log logger = LogFactory.getLog(ProductTypeWindow.class);

	private Panel mainPanel;
	private Panel buttonPanel;

	public ProductTypeWindow() {
		super("Product Types");
		mainPanel = new Panel();
		buttonPanel = new Panel();

		//BorderLayout layout = new BorderLayout();
		AbsoluteLayout layout = new AbsoluteLayout();
		mainPanel.setLayoutManager(layout);

		Table<String> table = new Table<>("ID", "Name", "Description");
		// Wrap the renderer with our own extensions.
		ExtendedTableRenderer<String> tableRenderer = new ExtendedTableRenderer<>(table.getRenderer());
		table.setRenderer(tableRenderer);
		table.setSize(new TerminalSize(40, 5));
		table.setPreferredSize(new TerminalSize(40, 5));
		table.setPosition(new TerminalPosition(0, 0));
		TableModel<String> model = table.getTableModel();
		table.setCellSelection(true);

		ProductType type1 = getDummyProductType(1);
		ProductType type2 = getDummyProductType(2);
		ProductType type3 = getDummyProductType(3);

		model.addRow(getProductTypeValues(type1));
		model.addRow(getProductTypeValues(type2));
		model.addRow(getProductTypeValues(type3));

		model.addListener(new Listener<String>() {

			@Override
			public void onRowAdded(TableModel<String> model, int index) {
			}

			@Override
			public void onRowRemoved(TableModel<String> model, int index, List<String> oldRow) {
			}

			@Override
			public void onColumnAdded(TableModel<String> model, int index) {
			}

			@Override
			public void onColumnRemoved(TableModel<String> model, int index, String oldHeader, List<String> oldColumn) {
			}

			@Override
			public void onCellChanged(TableModel<String> model, int row, int column, String oldValue, String newValue) {
				logger.info("onCellChanged: row=" + row + ", column=" + column + ", oldValue=" + oldValue + ", newValue=" + newValue);
			}
		});
		
		table.setSelectAction(() -> {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			int x = 0;
			
			List<Integer> columnSizes = tableRenderer.getColumnSizes();
			int viewLeftColumn = table.getViewLeftColumn();
			int width = columnSizes.get(column - viewLeftColumn);

			for (int i = 0; i < (column - viewLeftColumn); i++) {
				x += columnSizes.get(i);
				x++;
			}

			TableCellTextBox txtCell = new TableCellTextBox();
			txtCell.setPosition(new TerminalPosition(x, row + 1));
			txtCell.setSize(new TerminalSize(width, 1));
			txtCell.setText(model.getRow(row).get(column));

			txtCell.setListener(new TextBoxListener() {
				@Override
				public void onUpdate(String value) {
					logger.info("Cell [" + row + ", " + column +"] updated: " + value);
					model.setCell(column, row, value);
					mainPanel.removeComponent(txtCell);
					table.takeFocus();
				}
				@Override
				public void onCancel() {
					mainPanel.removeComponent(txtCell);
					table.takeFocus();
				}
			});
			mainPanel.addComponent(txtCell);
			txtCell.takeFocus();
		});
		
		mainPanel.addComponent(table, Location.CENTER);
		mainPanel.addComponent(buttonPanel, Location.BOTTOM);

		this.setComponent(mainPanel);
		this.setCloseWindowWithEscape(true);
	}

	private ProductType getDummyProductType(int number) {
		ProductType productType = new ProductType();
		productType.setId(number);
		productType.setName("dummy" + number);
		productType.setDescription("A dummy product type.");
		return productType;
	}

	private String[] getProductTypeValues(ProductType type) {
		return new String[] { String.valueOf(type.getId()), type.getName(), type.getDescription() };
	}
}
