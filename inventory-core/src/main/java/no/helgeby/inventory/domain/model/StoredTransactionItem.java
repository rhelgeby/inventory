package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public class StoredTransactionItem extends AbstractTransactionItem {

	public StoredTransactionItem(TransactionCode code, AccountCode accountCode, ProductCode productCode,
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

}
