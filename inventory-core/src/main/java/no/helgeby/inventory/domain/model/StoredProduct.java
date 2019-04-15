package no.helgeby.inventory.domain.model;

public class StoredProduct extends AbstractProduct {

	public StoredProduct(ProductCode code, String description, ProductType type, Weight netWeight) {
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

}
