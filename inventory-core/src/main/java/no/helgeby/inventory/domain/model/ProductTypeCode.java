package no.helgeby.inventory.domain.model;

public class ProductTypeCode extends CodeIdentifier {

	public ProductTypeCode(String code) {
		super(code);
	}

	@Override
	public String describe() {
		return "product type " + getCode();
	}
}
