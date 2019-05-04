package no.helgeby.inventory.service;

import no.helgeby.inventory.domain.EventStore;
import no.helgeby.inventory.domain.event.AccountCreatedEvent;
import no.helgeby.inventory.domain.model.Account;
import no.helgeby.inventory.domain.model.AccountCode;
import no.helgeby.inventory.domain.model.DraftAccount;

public class AccountService {

	private final EventStore eventStore;

	public AccountService(EventStore eventStore) {
		if (eventStore == null) {
			throw new IllegalArgumentException("Event store must not be null.");
		}
		this.eventStore = eventStore;
	}

	public Account loadAccount(AccountCode code) {
		return null;
	}

	public Account process(CreateAccountCommand command) {
		AccountCode accountCode = AccountCode.generate();
		DraftAccount draftAccount = new DraftAccount();
		draftAccount.setCode(accountCode);
		draftAccount.setName(command.getName());
		draftAccount.setDescription(command.getDescription());
		AccountCreatedEvent event = draftAccount.enroll();
		eventStore.store(event);
		return draftAccount;
	}
}
