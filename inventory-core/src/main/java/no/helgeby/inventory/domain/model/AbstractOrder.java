package no.helgeby.inventory.domain.model;

import java.time.Instant;

public abstract class AbstractOrder implements Order {

	protected Instant date;
	protected AccountCode fromAccount;
	protected AccountCode toAccount;
	protected String reference;
	protected String notes;

	@Override
	public Instant getDate() {
		return date;
	}

	@Override
	public AccountCode getFromAccount() {
		return fromAccount;
	}

	@Override
	public AccountCode getToAccount() {
		return toAccount;
	}

	@Override
	public String getReference() {
		return reference;
	}

	@Override
	public String getNotes() {
		return notes;
	}

}
