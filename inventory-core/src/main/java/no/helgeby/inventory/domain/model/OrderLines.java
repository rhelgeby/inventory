package no.helgeby.inventory.domain.model;

import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

public interface OrderLines {

	List<OrderLine> getOrderLines();

	MonetaryAmount getTotalPrice(CurrencyUnit targetCurrency);

}
