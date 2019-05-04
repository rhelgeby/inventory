package no.helgeby.inventory.persistence;

import java.time.Instant;

public class EventEntity {

	private Instant time;
	private String aggregateType;
	private int aggregateVersion;
	private String aggregateId;
	private String payload;

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public String getAggregateType() {
		return aggregateType;
	}

	public void setAggregateType(String aggregateType) {
		this.aggregateType = aggregateType;
	}

	public int getAggregateVersion() {
		return aggregateVersion;
	}

	public void setAggregateVersion(int aggregateVersion) {
		this.aggregateVersion = aggregateVersion;
	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
