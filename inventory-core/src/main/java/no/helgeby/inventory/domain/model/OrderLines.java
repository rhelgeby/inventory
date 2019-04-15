package no.helgeby.inventory.domain.model;

import java.util.Currency;
import java.util.List;

public interface OrderLines {

	List<OrderLine> getOrderLines();

	MonetaryAmount getTotalPrice(Currency targetCurrency, CurrencyConverter converter);

}
