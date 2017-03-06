package no.helgeby.inventory.model;

import java.math.BigDecimal;

/**
 * Items included in an order.
 */
public class OrderItem {

	private long orderId;
	private long orderLineId;
	private long productId;
	private long quantity;
	private BigDecimal unitPrice;
	private String notes;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
