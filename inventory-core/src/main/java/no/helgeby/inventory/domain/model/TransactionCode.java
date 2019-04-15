package no.helgeby.inventory.domain.model;

/**
 * Identifies a transaction.
 * <p>
 * The same transaction code is used on all items involved in a specific
 * transaction. It is otherwise unique.
 */
public class TransactionCode extends CodeIdentifier {

	public TransactionCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "transaction " + getCode();
	}

}
