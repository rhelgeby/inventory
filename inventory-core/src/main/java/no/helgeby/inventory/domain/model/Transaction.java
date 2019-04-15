package no.helgeby.inventory.domain.model;

import java.time.Instant;
import java.util.List;

public interface Transaction {

	TransactionCode getCode();

	Instant getDate();

	List<TransactionItem> getItems();

}
