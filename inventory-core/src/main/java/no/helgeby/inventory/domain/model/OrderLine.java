package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public class OrderLine {

	private final OrderLineCode code;
	private final ProductCode productCode;
	private final BigDecimal amount;
	private final MonetaryAmount unitPrice;
	private final String notes;

	public OrderLine(OrderLineCode code, ProductCode productCode, BigDecimal amount,
			MonetaryAmount unitPrice, String notes) {
		if (code == null) {
			throw new IllegalArgumentException("Code must not be null.");
		}
		if (productCode == null) {
			throw new IllegalArgumentException("Product code must not be null.");
		}
		if (amount == null) {
			throw new IllegalArgumentException("Amount must not be null.");
		}
		if (unitPrice == null) {
			throw new IllegalArgumentException("Unit price must not be null.");
		}
		this.code = code;
		this.productCode = productCode;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.notes = notes;
	}

	public OrderLineCode getCode() {
		return code;
	}

	public ProductCode getProductCode() {
		return productCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public MonetaryAmount getUnitPrice() {
		return unitPrice;
	}

	public String getNotes() {
		return notes;
	}

}
