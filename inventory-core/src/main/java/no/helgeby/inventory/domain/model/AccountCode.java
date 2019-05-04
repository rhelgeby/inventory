package no.helgeby.inventory.domain.model;

import java.util.UUID;

public class AccountCode extends CodeIdentifier {

	public static final String prefix = "ACC-";

	public AccountCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "account " + getCode();
	}

	public static AccountCode generate() {
		UUID uuid = UUID.randomUUID();
		return new AccountCode(prefix + uuid);
	}
}
