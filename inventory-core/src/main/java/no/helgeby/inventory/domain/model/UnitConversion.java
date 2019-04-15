package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class UnitConversion {

	private final String fromSymbol;
	private final String toSymbol;
	private final BigDecimal factor;
	private final UnitType unitType;

	public UnitConversion(String fromSymbol, String toSymbol, BigDecimal factor, UnitType unitType) {
		if (StringUtils.isBlank(fromSymbol)) {
			throw new IllegalArgumentException("From symbol must not be null.");
		}
		if (StringUtils.isBlank(toSymbol)) {
			throw new IllegalArgumentException("To symbol must not be null.");
		}
		if (factor == null) {
			throw new IllegalArgumentException("Factor must not be null.");
		}
		if (unitType == null) {
			throw new IllegalArgumentException("Unit type must not be null.");
		}
		this.fromSymbol = fromSymbol;
		this.toSymbol = toSymbol;
		this.factor = factor;
		this.unitType = unitType;
	}

	public String getFromSymbol() {
		return fromSymbol;
	}

	public String getToSymbol() {
		return toSymbol;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public UnitType getUnitType() {
		return unitType;
	}

}
