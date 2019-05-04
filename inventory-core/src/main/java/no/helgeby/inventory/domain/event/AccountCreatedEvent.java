package no.helgeby.inventory.domain.event;

import java.time.Instant;

import no.helgeby.inventory.domain.model.Account;
import no.helgeby.inventory.domain.model.AccountCode;

public class AccountCreatedEvent extends Event {

	public static final String EVENT_NAME = "accountCreated";

	private final AccountCode code;

	private final String name;

	private final String description;

	public AccountCreatedEvent(Instant time, Account account) {
		super(time);
		this.code = account.getCode();
		this.name = account.getName();
		this.description = account.getDescription();
	}

	@Override
	public String getEventName() {
		return EVENT_NAME;
	}

	public AccountCode getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
