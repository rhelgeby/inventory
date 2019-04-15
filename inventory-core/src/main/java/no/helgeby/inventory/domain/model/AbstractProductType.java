package no.helgeby.inventory.domain.model;

public abstract class AbstractProductType implements ProductType {

	protected ProductTypeCode code;
	protected String description;

	@Override
	public ProductTypeCode getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
