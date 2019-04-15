package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

public interface CurrencyConverter {

	public BigDecimal convert(Currency from, Currency to, BigDecimal amount);

	public BigDecimal convert(MonetaryAmount amount, Currency targetCurrency);

	public BigDecimal convert(MonetaryAmount amount, Currency targetCurrency, Instant exchangeRateDate);

}
