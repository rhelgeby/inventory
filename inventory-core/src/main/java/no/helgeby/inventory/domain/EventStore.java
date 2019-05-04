package no.helgeby.inventory.domain;

import java.util.List;

import no.helgeby.inventory.domain.event.Event;

public interface EventStore {

	void store(Event event);

	List<Event> findById(String aggregateId);
}
