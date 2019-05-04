package no.helgeby.inventory.domain.model;

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

	public void enroll() {
		// TODO: Create event in aggregate.
	}
}
