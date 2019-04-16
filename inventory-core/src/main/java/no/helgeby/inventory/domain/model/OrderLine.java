package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

public interface OrderLine {

	OrderLineCode getCode();

	ProductCode getProductCode();

	BigDecimal getAmount();

	MonetaryAmount getUnitPrice();

	String getNotes();

}
