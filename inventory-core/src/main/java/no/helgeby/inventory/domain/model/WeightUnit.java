package no.helgeby.inventory.domain.model;

import org.apache.commons.lang3.StringUtils;

public class WeightUnit {

	private final String unit;

	public WeightUnit(String unit) {
		if (StringUtils.isBlank(unit)) {
			throw new IllegalArgumentException("Unit must not be null or blank.");
		}
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

}
