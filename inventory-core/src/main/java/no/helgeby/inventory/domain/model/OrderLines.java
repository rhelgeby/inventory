package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

public class OrderLines {

	private final List<OrderLine> orderLines;

	public OrderLines(List<OrderLine> orderLines) {
		if (orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("Order lines must not be null or empty.");
		}
		this.orderLines = orderLines;
	}

	public List<OrderLine> getOrderLines() {
		return Collections.unmodifiableList(orderLines);
	}

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
