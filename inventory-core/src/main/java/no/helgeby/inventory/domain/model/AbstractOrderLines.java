package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

public abstract class AbstractOrderLines<T extends OrderLine> implements OrderLines {

	protected List<T> orderLines;

	@Override
	public List<OrderLine> getOrderLines() {
		return Collections.unmodifiableList(orderLines);
	}

	@Override
	public MonetaryAmount getTotalPrice(Currency targetCurrency, CurrencyConverter converter) {
		BigDecimal total = BigDecimal.ZERO;
	
		for (OrderLine line : orderLines) {
			MonetaryAmount unitPrice = line.getUnitPrice();
			BigDecimal lineTotal;
	
			if (unitPrice.isCurrencySameAs(targetCurrency)) {
				lineTotal = unitPrice.getAmount().multiply(line.getAmount());
			}
			else {
				BigDecimal convertedUnitPrice = converter.convert(unitPrice, targetCurrency);
				lineTotal = convertedUnitPrice.multiply(line.getAmount());
			}
	
			total = total.add(lineTotal);
		}
	
		return new MonetaryAmount(total, targetCurrency);
	}

}
