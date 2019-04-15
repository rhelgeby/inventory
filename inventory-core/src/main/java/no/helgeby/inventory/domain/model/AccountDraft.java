package no.helgeby.inventory.domain.model;

public class AccountDraft extends AbstractAccount {

	public void setCode(AccountCode code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
