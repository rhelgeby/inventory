package no.helgeby.inventory.transaction;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import no.helgeby.inventory.model.Transaction;

@Entity
public class TransactionEntity extends Transaction {

	private static final int MONETARY_SCALE = 4;
	public static final int MONETARY_PRECISION = 19;

	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "date")
	public Date getDate() {
		return super.getDate();
	}

	@Column(name = "description")
	public String getDescription() {
		return super.getDescription();
	}

	@Column(name = "interestDate")
	public Date getInterestDate() {
		return super.getInterestDate();
	}

	@Column(name = "withdrawal", precision = MONETARY_PRECISION, scale = MONETARY_SCALE)
	public BigDecimal getWithdrawal() {
		return super.getWithdrawal();
	}

	@Column(name = "deposit", precision = MONETARY_PRECISION, scale = MONETARY_SCALE)
	public BigDecimal getDeposit() {
		return super.getDeposit();
	}

	@Column(name = "fromAccountId")
	public long getFromAccountId() {
		return super.getFromAccountId();
	}

	@Column(name = "toAccountId")
	public long getToAccountId() {
		return super.getToAccountId();
	}

}
