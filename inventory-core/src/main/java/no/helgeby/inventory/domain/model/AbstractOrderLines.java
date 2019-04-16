package no.helgeby.inventory.domain.model;

import java.util.Collections;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

public abstract class AbstractOrderLines<T extends OrderLine> implements OrderLines {

	protected List<T> orderLines;

	@Override
	public List<OrderLine> getOrderLines() {
		return Collections.unmodifiableList(orderLines);
	}

	@Override
	public MonetaryAmount getTotalPrice(CurrencyUnit targetCurrency) {
		MonetaryAmount total = getZero(targetCurrency);

		CurrencyConversion currencyConversion = MonetaryConversions.getConversion(targetCurrency);
		for (OrderLine line : orderLines) {
			MonetaryAmount unitPrice = line.getUnitPrice();
			if (!unitPrice.getCurrency().equals(targetCurrency)) {
				unitPrice = unitPrice.with(currencyConversion);
			}
			total = total.add(unitPrice.multiply(line.getAmount()));
		}

		return total;
	}

	public static MonetaryAmount getZero(CurrencyUnit crrency) {
		return Monetary.getDefaultAmountFactory().setCurrency(crrency).setNumber(0).create();
	}

}
