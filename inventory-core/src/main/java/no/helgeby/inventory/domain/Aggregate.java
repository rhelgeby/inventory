package no.helgeby.inventory.domain;

import java.util.Collections;
import java.util.List;

import no.helgeby.inventory.domain.event.Event;
import no.helgeby.inventory.domain.model.CodeIdentifier;

public abstract class Aggregate<T extends CodeIdentifier> {

	private List<Event> newEvents;
	private int baseVersion;

	public abstract T getCode();

	protected void applyEvent(Event event) {
		// TODO: Validations.
		newEvents.add(event);
	}

	public int getBaseVersion() {
		return baseVersion;
	}

	public List<Event> getNewEvents() {
		return Collections.unmodifiableList(newEvents);
	}
}
