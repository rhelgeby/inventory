package no.helgeby.inventory.domain.model;

import java.time.Instant;

public class Order {

	private final Instant date;
	private final AccountCode fromAccount;
	private final AccountCode toAccount;
	private final String reference;
	private final String notes;

	public Order(Instant date, AccountCode fromAccount, AccountCode toAccount, String reference, String notes) {
		if (date == null) {
			throw new IllegalArgumentException("Order date must not be null.");
		}
		if (fromAccount == null) {
			throw new IllegalArgumentException("From account code must not be null.");
		}
		if (toAccount == null) {
			throw new IllegalArgumentException("To account code must not be null.");
		}
		this.date = date;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.reference = reference;
		this.notes = notes;
	}

	public Instant getDate() {
		return date;
	}

	public AccountCode getFromAccount() {
		return fromAccount;
	}

	public AccountCode getToAccount() {
		return toAccount;
	}

	public String getReference() {
		return reference;
	}

	public String getNotes() {
		return notes;
	}

}
