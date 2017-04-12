package no.helgeby.inventory.parser;

public class TransactionColumn {

	private String name;
	private TransactionColumnType type;

	public TransactionColumn() {

	}

	public TransactionColumn(String name, TransactionColumnType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TransactionColumnType getType() {
		return type;
	}

	public void setType(TransactionColumnType type) {
		this.type = type;
	}

}
