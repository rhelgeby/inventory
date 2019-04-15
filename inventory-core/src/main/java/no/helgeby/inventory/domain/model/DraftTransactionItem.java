package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public class DraftTransactionItem extends AbstractTransactionItem {

	public void setCode(TransactionCode code) {
		this.code = code;
	}

	public void setAccountCode(AccountCode accountCode) {
		this.accountCode = accountCode;
	}

	public void setProductCode(ProductCode productCode) {
		this.productCode = productCode;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setOrderLineCode(OrderLineCode orderLineCode) {
		this.orderLineCode = orderLineCode;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
