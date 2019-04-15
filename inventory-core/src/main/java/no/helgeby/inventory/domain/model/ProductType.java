package no.helgeby.inventory.domain.model;

import org.apache.commons.lang3.StringUtils;

public class ProductType {

	private final ProductTypeCode code;
	private final String description;

	public ProductType(ProductTypeCode code, String description) {
		if (code == null) {
			throw new IllegalArgumentException("Product code must not be null.");
		}
		if (StringUtils.isBlank(description)) {
			throw new IllegalArgumentException("Description must not be null or blank.");
		}
		this.code = code;
		this.description = description;
	}

	public ProductTypeCode getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
