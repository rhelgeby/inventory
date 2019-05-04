package no.helgeby.inventory.service;

import org.apache.commons.lang3.StringUtils;

public class CreateAccountCommand {

	private final String name;
	private final String description;

	public CreateAccountCommand(String name, String description) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Name must not be null or blank.");
		}
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
