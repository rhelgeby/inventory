package no.helgeby.inventory.domain.model;

import java.time.Instant;

public interface Order {

	Instant getDate();

	AccountCode getFromAccount();

	AccountCode getToAccount();

	String getReference();

	String getNotes();

}
