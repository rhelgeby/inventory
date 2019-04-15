package no.helgeby.inventory.domain.model;

public abstract class AbstractProduct implements Product {

	protected ProductCode code;
	protected String description;
	protected ProductType type;
	protected Weight netWeight;

	@Override
	public ProductCode getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public ProductType getType() {
		return type;
	}

	@Override
	public Weight getNetWeight() {
		return netWeight;
	}

}
