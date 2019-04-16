package no.helgeby.inventory.domain.model;

import java.time.Instant;

public interface Order {

	OrderCode getCode();

	Instant getDate();

	AccountCode getFromAccount();

	AccountCode getToAccount();

	String getReference();

	String getNotes();

}
