package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

import no.helgeby.inventory.domain.CurrencyException;

public class MonetaryAmount {

	private BigDecimal amount;
	private Currency currency;

	public MonetaryAmount(Currency currency) {
		if (currency == null) {
			throw new IllegalArgumentException("Currency must not be null.");
		}
		this.amount = BigDecimal.ZERO;
		this.currency = currency;
	}

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

	public MonetaryAmount as(Currency targetCurrency, CurrencyConverter converter)
			throws CurrencyException {
		if (isCurrencySameAs(targetCurrency)) {
			return this;
		}
		BigDecimal newAmount = converter.convert(amount, currency, targetCurrency);
		return new MonetaryAmount(newAmount, targetCurrency);
	}

	public MonetaryAmount add(BigDecimal augend) {
		BigDecimal newAmount = amount.add(augend);
		return new MonetaryAmount(newAmount, currency);
	}

	public MonetaryAmount add(MonetaryAmount augend) throws CurrencyException {
		if (!isCurrencySameAs(augend.getCurrency())) {
			throw new CurrencyException("Cannot add. Currency is not the same.");
		}
		BigDecimal newAmount = amount.add(augend.getAmount());
		return new MonetaryAmount(newAmount, currency);
	}

	public MonetaryAmount multiply(BigDecimal factor) {
		BigDecimal newAmount = amount.multiply(factor);
		return new MonetaryAmount(newAmount, currency);
	}

}
