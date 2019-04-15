package no.helgeby.inventory.domain.model;

import java.time.Instant;
import java.util.List;

public class Transaction {

	private final TransactionCode code;
	private final Instant date;
	private final List<TransactionItem> items;

	public Transaction(TransactionCode code, Instant date, List<TransactionItem> items) {
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

	public TransactionCode getCode() {
		return code;
	}

	public Instant getDate() {
		return date;
	}

	public List<TransactionItem> getItems() {
		return items;
	}

}
