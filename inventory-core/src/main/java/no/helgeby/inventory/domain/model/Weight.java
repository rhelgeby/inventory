package no.helgeby.inventory.domain.model;

import java.math.BigDecimal;

public class Weight {

	private final BigDecimal weight;
	private final WeightUnit weightUnit;

	public Weight(BigDecimal weight, WeightUnit weightUnit) {
		if (weight == null) {
			throw new IllegalArgumentException("Weight must not be null.");
		}
		if (weightUnit == null) {
			throw new IllegalArgumentException("Weight unit must not be null.");
		}
		this.weight = weight;
		this.weightUnit = weightUnit;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public WeightUnit getWeightUnit() {
		return weightUnit;
	}

}
