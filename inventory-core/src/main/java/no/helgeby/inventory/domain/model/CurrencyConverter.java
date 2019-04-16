package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

import no.helgeby.inventory.domain.CurrencyException;

public interface CurrencyConverter {

	public BigDecimal convert(BigDecimal amount, Currency from, Currency to) throws CurrencyException;

}
