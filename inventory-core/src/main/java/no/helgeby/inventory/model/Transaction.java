package no.helgeby.inventory.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Transaction {

	public static final ToStringStyle TO_STRING_STYLE = ToStringStyle.JSON_STYLE;

	private long id;
	private long orderLineId;
	private long accountId;
	private Date date;
	private long productId;
	private BigDecimal amount;
	private String notes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String toString() {
		return new ToStringBuilder(this, TO_STRING_STYLE)
				.append("id", getId())
				.append("orderLineId", getOrderLineId())
				.append("accountId", getAccountId())
				.append("date", getDate())
				.append("productId", getProductId())
				.append("amount", getAmount())
				.append("notes", getNotes())
				.toString();
	}
}
