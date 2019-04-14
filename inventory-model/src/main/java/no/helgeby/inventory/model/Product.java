package no.helgeby.inventory.model;

import java.math.BigDecimal;

public class Product {

	private long id;
	private long productTypeId;
	private String description;
	private BigDecimal netWeight;
	private String weightUnit;

	public long getProductId() {
		return id;
	}

	public void setProductId(long productId) {
		this.id = productId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getWeightUnit() {
		return weightUnit;
	}
}
