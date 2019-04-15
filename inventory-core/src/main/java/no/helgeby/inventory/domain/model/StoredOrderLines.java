package no.helgeby.inventory.domain.model;

import java.util.List;

public class StoredOrderLines extends AbstractOrderLines {

	public StoredOrderLines(List<StoredOrderLine> orderLines) {
		if (orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("Order lines must not be null or empty.");
		}
		this.orderLines = orderLines;
	}

}
