package no.helgeby.inventory.domain.model;

import java.time.Instant;

public class DraftOrder extends AbstractOrder {

	public void setDate(Instant date) {
		this.date = date;
	}

	public void setFromAccount(AccountCode fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setToAccount(AccountCode toAccount) {
		this.toAccount = toAccount;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
