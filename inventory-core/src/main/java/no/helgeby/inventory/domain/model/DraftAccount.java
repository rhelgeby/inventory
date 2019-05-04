package no.helgeby.inventory.domain.model;

import java.time.Instant;

import no.helgeby.inventory.domain.event.AccountCreatedEvent;

public class DraftAccount extends AbstractAccount {

	public void setCode(AccountCode code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountCreatedEvent enroll() {
		// TODO: Validate what's needed to go from DraftAccount to a StoredAccount.
		AccountCreatedEvent event = new AccountCreatedEvent(Instant.now(), this);
		applyEvent(event);
		return event;
	}
}
