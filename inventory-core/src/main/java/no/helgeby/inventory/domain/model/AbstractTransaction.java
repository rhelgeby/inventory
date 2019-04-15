package no.helgeby.inventory.domain.model;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class AbstractTransaction<T extends TransactionItem> implements Transaction {

	protected TransactionCode code;
	protected Instant date;
	protected List<T> items;

	@Override
	public TransactionCode getCode() {
		return code;
	}

	@Override
	public Instant getDate() {
		return date;
	}

	@Override
	public List<TransactionItem> getItems() {
		return Collections.unmodifiableList(items);
	}

}
