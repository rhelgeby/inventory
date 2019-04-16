package no.helgeby.inventory.domain.model;

import java.time.Instant;
import java.util.List;

public abstract class StoredTransaction extends AbstractTransaction<StoredTransactionItem> {

	public StoredTransaction(TransactionCode code, Instant date, List<StoredTransactionItem> items) {
		if (code == null) {
			throw new IllegalArgumentException("Code must not be null.");
		}
		if (date == null) {
			throw new IllegalArgumentException("Date must not be null.");
		}
		if (items == null || items.isEmpty()) {
			throw new IllegalArgumentException("Items must not be null or empty.");
		}
		this.code = code;
		this.date = date;
		this.items = items;
	}

}
