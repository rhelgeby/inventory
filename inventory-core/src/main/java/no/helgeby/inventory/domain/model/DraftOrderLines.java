package no.helgeby.inventory.domain.model;

import java.util.List;

public class DraftOrderLines extends AbstractOrderLines<DraftOrderLine> {

	public List<DraftOrderLine> getDraftOrderLines() {
		return this.orderLines;
	}

	public void setOrderLines(List<DraftOrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
