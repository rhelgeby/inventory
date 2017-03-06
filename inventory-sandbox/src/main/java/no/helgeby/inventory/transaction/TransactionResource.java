package no.helgeby.inventory.transaction;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.helgeby.inventory.model.Transaction;

@Component
@Path("transaction")
public class TransactionResource {

	@Autowired
	private TransactionRepository transactionRepository;

	@GET
	@Produces("application/json")
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
}
