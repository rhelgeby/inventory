package no.helgeby.inventory.domain.model;

public class OrderLineCode extends CodeIdentifier {

	public OrderLineCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "order line " + getCode();
	}

}
