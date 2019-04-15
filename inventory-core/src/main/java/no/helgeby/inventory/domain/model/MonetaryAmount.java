package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount {

	private BigDecimal amount;
	private Currency currency;

	public MonetaryAmount(BigDecimal amount, Currency currency) {
		if (amount == null) {
			throw new IllegalArgumentException("Amount must not be null.");
		}
		if (currency == null) {
			throw new IllegalArgumentException("Currency must not be null.");
		}
		this.amount = amount;
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public boolean isCurrencySameAs(Currency currency) {
		return currency.getCurrencyCode().equals(currency.getCurrencyCode());
	}

}
