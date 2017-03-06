package no.helgeby.inventory.parser;

public class ColumnDefinition {

	private String name;
	private ColumnType type;

	public ColumnDefinition() {

	}

	public ColumnDefinition(String name, ColumnType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ColumnType getType() {
		return type;
	}

	public void setType(ColumnType type) {
		this.type = type;
	}

}
