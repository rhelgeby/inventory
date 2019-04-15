package no.helgeby.inventory.domain.model;

public class AccountCode extends CodeIdentifier {

	public AccountCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "account " + getCode();
	}

}
