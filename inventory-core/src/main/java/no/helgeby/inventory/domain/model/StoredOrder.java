package no.helgeby.inventory.domain.model;

import java.time.Instant;

public class StoredOrder extends AbstractOrder {

	public StoredOrder(Instant date, AccountCode fromAccount, AccountCode toAccount, String reference, String notes) {
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

}
