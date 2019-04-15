package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public abstract class AbstractTransactionItem implements TransactionItem {

	protected TransactionCode code;
	protected AccountCode accountCode;
	protected ProductCode productCode;
	protected BigDecimal amount;
	protected OrderLineCode orderLineCode;
	protected String notes;

	@Override
	public TransactionCode getCode() {
		return code;
	}

	@Override
	public AccountCode getAccountCode() {
		return accountCode;
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
	public OrderLineCode getOrderLineCode() {
		return orderLineCode;
	}

	@Override
	public String getNotes() {
		return notes;
	}

}
