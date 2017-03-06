package no.helgeby.inventory.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A financial transaction.
 */
public class Transaction {

	public static final ToStringStyle TO_STRING_STYLE = ToStringStyle.JSON_STYLE;

	private Date date;
	private String description;
	private Date interestDate;
	private BigDecimal withdrawal;
	private BigDecimal deposit;
	private long fromAccountId;
	private long toAccountId;


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInterestDate() {
		return interestDate;
	}

	public void setInterestDate(Date interestDate) {
		this.interestDate = interestDate;
	}

	public BigDecimal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(BigDecimal withdrawal) {
		this.withdrawal = withdrawal;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public String toString() {
		return new ToStringBuilder(this, TO_STRING_STYLE)
				.append("date", getDate())
				.append("fromAccountId", getFromAccountId())
				.append("toAccountId", getToAccountId())
				.append("description", getDescription())
				.append("interestDate", getInterestDate())
				.append("withdrawal", getWithdrawal())
				.append("deposit", getDeposit())
				.toString();
	}
}
