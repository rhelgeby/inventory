package no.helgeby.inventory.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Simple string based identifier. Sub classes may enforce custom formats or
 * validation rules.
 */
public abstract class CodeIdentifier {

	protected final String code;

	public CodeIdentifier(String code) {
		if (StringUtils.isBlank(code)) {
			throw new IllegalArgumentException("Code must not be null or blank.");
		}
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (this.getClass().equals(other.getClass())) {
			return false;
		}
		CodeIdentifier otherIdentifier = (CodeIdentifier) other;
		return code.equals(otherIdentifier.getCode());
	}

	public abstract String describe();

	public String toString() {
		return describe();
	}
}
