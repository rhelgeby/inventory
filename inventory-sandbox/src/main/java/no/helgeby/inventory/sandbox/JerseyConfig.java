package no.helgeby.inventory.sandbox;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import no.helgeby.inventory.transaction.TransactionResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(TransactionResource.class);
	}

}
