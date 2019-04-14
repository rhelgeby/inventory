package no.helgeby.inventory.model;

import java.math.BigDecimal;

public class UnitConversion {

	private String from;
	private String to;
	private BigDecimal factor;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String toString() {
		return from + " -> " + to + ": " + factor;
	}
}
