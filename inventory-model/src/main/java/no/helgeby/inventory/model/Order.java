package no.helgeby.inventory.model;

import java.util.Date;
import java.util.List;

/**
 * An order from a supplier.
 */
public class Order {

	private long orderId;
	private String vendorOrderId;
	private Date orderDate;
	private String vendorName;
	private long ownerId;
	private long transactionId;
	private List<OrderItem> orderItems;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getVendorOrderId() {
		return vendorOrderId;
	}

	public void setVendorOrderId(String vendorOrderId) {
		this.vendorOrderId = vendorOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
