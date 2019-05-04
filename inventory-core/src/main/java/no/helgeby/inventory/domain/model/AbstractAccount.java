package no.helgeby.inventory.domain.model;

import no.helgeby.inventory.domain.Aggregate;

public abstract class AbstractAccount extends Aggregate<AccountCode> implements Account {

	protected AccountCode code;
	protected String name;
	protected String description;

	@Override
	public AccountCode getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
