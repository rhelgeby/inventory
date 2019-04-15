package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public interface TransactionItem {

	TransactionCode getCode();

	AccountCode getAccountCode();

	ProductCode getProductCode();

	BigDecimal getAmount();

	OrderLineCode getOrderLineCode();

	String getNotes();

}
