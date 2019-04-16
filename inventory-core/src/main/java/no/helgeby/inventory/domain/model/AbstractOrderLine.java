package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public abstract class AbstractOrderLine implements OrderLine {

	protected OrderLineCode code;
	protected ProductCode productCode;
	protected BigDecimal amount;
	protected SimpleMonetaryAmount unitPrice;
	protected String notes;

	@Override
	public OrderLineCode getCode() {
		return code;
	}

	@Override
	public ProductCode getProductCode() {
		return productCode;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public SimpleMonetaryAmount getUnitPrice() {
		return unitPrice;
	}

	@Override
	public String getNotes() {
		return notes;
	}

}
