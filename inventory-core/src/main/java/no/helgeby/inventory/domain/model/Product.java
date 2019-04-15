package no.helgeby.inventory.domain.model;

public class Product {

	private final ProductCode code;
	private final String description;
	private final ProductType type;
	private final Weight netWeight;

	public Product(ProductCode code, String description, ProductType type, Weight netWeight) {
		if (code == null) {
			throw new IllegalArgumentException("Product code must not be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Product type must not be null.");
		}

		// Note: Description and weight is optional.

		this.code = code;
		this.description = description;
		this.type = type;
		this.netWeight = netWeight;
	}

	public ProductCode getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public ProductType getType() {
		return type;
	}

	public Weight getNetWeight() {
		return netWeight;
	}

}
