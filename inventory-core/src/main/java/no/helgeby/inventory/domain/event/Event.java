package no.helgeby.inventory.domain.event;

import java.time.Instant;

public abstract class Event {

	private final Instant time;

	public Event(Instant time) {
		if (time == null) {
			throw new IllegalArgumentException("Time must not be null.");
		}
		this.time = time;
	}

	public Instant getTime() {
		return time;
	}

	public abstract String getEventName();

}
