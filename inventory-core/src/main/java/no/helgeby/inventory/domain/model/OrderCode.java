package no.helgeby.inventory.domain.model;

public class OrderCode extends CodeIdentifier {

	public OrderCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "order " + getCode();
	}

}
