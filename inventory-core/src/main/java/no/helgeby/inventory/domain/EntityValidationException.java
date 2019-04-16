package no.helgeby.inventory.domain;

public class EntityValidationException extends Exception {

	private static final long serialVersionUID = -9014470120063505521L;

	public EntityValidationException(String message) {
		super(message);
	}

}
