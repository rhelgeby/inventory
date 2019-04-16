package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

import no.helgeby.inventory.domain.CurrencyException;

public class SimpleMonetaryAmount {

	private BigDecimal amount;
	private Currency currency;

	public SimpleMonetaryAmount(Currency currency) {
		if (currency == null) {
			throw new IllegalArgumentException("Currency must not be null.");
		}
		this.amount = BigDecimal.ZERO;
		this.currency = currency;
	}

	public SimpleMonetaryAmount(BigDecimal amount, Currency currency) {
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

	public SimpleMonetaryAmount as(Currency targetCurrency, CurrencyConverter converter)
			throws CurrencyException {
		if (isCurrencySameAs(targetCurrency)) {
			return this;
		}
		BigDecimal newAmount = converter.convert(amount, currency, targetCurrency);
		return new SimpleMonetaryAmount(newAmount, targetCurrency);
	}

	public SimpleMonetaryAmount add(BigDecimal augend) {
		BigDecimal newAmount = amount.add(augend);
		return new SimpleMonetaryAmount(newAmount, currency);
	}

	public SimpleMonetaryAmount add(SimpleMonetaryAmount augend) throws CurrencyException {
		if (!isCurrencySameAs(augend.getCurrency())) {
			throw new CurrencyException("Cannot add. Currency is not the same.");
		}
		BigDecimal newAmount = amount.add(augend.getAmount());
		return new SimpleMonetaryAmount(newAmount, currency);
	}

	public SimpleMonetaryAmount multiply(BigDecimal factor) {
		BigDecimal newAmount = amount.multiply(factor);
		return new SimpleMonetaryAmount(newAmount, currency);
	}

}
