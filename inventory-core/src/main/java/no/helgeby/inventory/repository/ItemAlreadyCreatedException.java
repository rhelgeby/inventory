package no.helgeby.inventory.repository;

public class ItemAlreadyCreatedException extends Exception {

	private static final long serialVersionUID = 4051134753504195074L;

	public ItemAlreadyCreatedException(String message) {
		super(message);
	}

}
