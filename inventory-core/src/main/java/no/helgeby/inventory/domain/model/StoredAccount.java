package no.helgeby.inventory.domain.model;

import org.apache.commons.lang3.StringUtils;

public class StoredAccount extends AbstractAccount {

	public StoredAccount(AccountCode code, String name) {
		this(code, name, null);
	}

	public StoredAccount(AccountCode code, String name, String description) {
		if (code == null) {
			throw new IllegalArgumentException("Account code must not be null.");
		}
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Name must not be null or blank.");
		}
		this.code = code;
		this.name = name;
		this.description = description;
	}

}
