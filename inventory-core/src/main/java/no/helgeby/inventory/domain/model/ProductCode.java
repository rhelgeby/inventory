package no.helgeby.inventory.domain.model;

public class ProductCode extends CodeIdentifier {

	public ProductCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "product " + getCode();
	}
}
