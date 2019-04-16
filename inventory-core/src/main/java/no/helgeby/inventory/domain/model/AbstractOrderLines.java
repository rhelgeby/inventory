package no.helgeby.inventory.domain.model;

import java.util.Collections;
import java.util.Currency;
import java.util.List;

import no.helgeby.inventory.domain.CurrencyException;

public abstract class AbstractOrderLines<T extends OrderLine> implements OrderLines {

	protected List<T> orderLines;

	@Override
	public List<OrderLine> getOrderLines() {
		return Collections.unmodifiableList(orderLines);
	}

	@Override
	public SimpleMonetaryAmount getTotalPrice(Currency targetCurrency, CurrencyConverter converter)
			throws CurrencyException {
		SimpleMonetaryAmount total = new SimpleMonetaryAmount(targetCurrency);

		for (OrderLine line : orderLines) {
			SimpleMonetaryAmount unitPrice = line.getUnitPrice().as(targetCurrency, converter);
			total = total.add(unitPrice.multiply(line.getAmount()));
		}

		return total;
	}

}
