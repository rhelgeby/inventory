package no.helgeby.inventory.transaction;

import java.util.List;

import no.helgeby.inventory.model.Transaction;

public interface TransactionRepository {

	List<Transaction> findAll();

}