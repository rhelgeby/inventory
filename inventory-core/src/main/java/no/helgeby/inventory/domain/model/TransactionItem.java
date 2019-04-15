package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public class TransactionItem {

	private final TransactionCode code;
	private final AccountCode accountCode;
	private final ProductCode productCode;
	private final BigDecimal amount;
	private final OrderLineCode orderLineCode;
	private final String notes;

	public TransactionItem(TransactionCode code, AccountCode accountCode, ProductCode productCode,
			BigDecimal amount, OrderLineCode orderLineCode, String notes) {
		if (code == null) {
			throw new IllegalArgumentException("Code must not be null.");
		}
		if (accountCode == null) {
			throw new IllegalArgumentException("Account code must not be null.");
		}
		if (productCode == null) {
			throw new IllegalArgumentException("Product code must not be null.");
		}
		if (amount == null) {
			throw new IllegalArgumentException("Amount must not be null.");
		}
		this.code = code;
		this.accountCode = accountCode;
		this.productCode = productCode;
		this.amount = amount;
		this.orderLineCode = orderLineCode;
		this.notes = notes;
	}

	public TransactionCode getCode() {
		return code;
	}

	public AccountCode getAccountCode() {
		return accountCode;
	}

	public ProductCode getProductCode() {
		return productCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public OrderLineCode getOrderLineCode() {
		return orderLineCode;
	}

	public String getNotes() {
		return notes;
	}

}
