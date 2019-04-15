package no.helgeby.inventory.domain.model;

import java.time.Instant;
import java.util.List;

public class DraftTransaction extends AbstractTransaction<DraftTransactionItem> {

	public List<DraftTransactionItem> getDraftItems() {
		return this.items;
	}

	public void setCode(TransactionCode code) {
		this.code = code;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public void setItems(List<DraftTransactionItem> items) {
		this.items = items;
	}

}
