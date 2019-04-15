package no.helgeby.inventory.domain.model;

public abstract class AbstractAccount implements Account {

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
