package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public interface OrderLine {

	OrderLineCode getCode();

	ProductCode getProductCode();

	BigDecimal getAmount();

	SimpleMonetaryAmount getUnitPrice();

	String getNotes();

}
