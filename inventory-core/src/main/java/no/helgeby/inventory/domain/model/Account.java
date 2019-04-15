package no.helgeby.inventory.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Account {

	private final AccountCode code;
	private final String name;
	private final String description;

	public Account(AccountCode code, String name) {
		this(code, name, null);
	}

	public Account(AccountCode code, String name, String description) {
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
