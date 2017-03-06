package no.helgeby.inventory.model;

/**
 * Items included in a delivery.
 */
public class DeliveryItem {

	private long deliveryId;
	private long deliveryItemId;
	private long productId;
	private long qantity;
	private String notes;

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public long getDeliveryItemId() {
		return deliveryItemId;
	}

	public void setDeliveryItemId(long deliveryItemId) {
		this.deliveryItemId = deliveryItemId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQantity() {
		return qantity;
	}

	public void setQantity(long qantity) {
		this.qantity = qantity;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
