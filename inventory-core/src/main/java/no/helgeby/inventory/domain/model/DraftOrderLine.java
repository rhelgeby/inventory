package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

public class DraftOrderLine extends AbstractOrderLine {

	public void setCode(OrderLineCode code) {
		this.code = code;
	}

	public void setProductCode(ProductCode productCode) {
		this.productCode = productCode;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setUnitPrice(MonetaryAmount unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
