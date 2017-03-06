package no.helgeby.inventory.transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import no.helgeby.inventory.model.Transaction;

@Component
public class JpaTransactionRepository implements TransactionRepository {

	//@PersistenceContext
	//private EntityManager entityManager;

	private List<TransactionEntity> transactions;

	@PostConstruct
	public void loadDummyTransactions() {
		transactions = new ArrayList<>();
		TransactionEntity entity = new TransactionEntity();
		entity.setId(1);
		entity.setDate(new Date());
		entity.setDeposit(new BigDecimal(500));
		entity.setDescription("Test deposit.");
		transactions.add(entity);
	}

	@Override
	public List<Transaction> findAll() {
		//List<TransactionEntity> transactions = entityManager.createQuery("SELECT t from Transaction t", TransactionEntity.class).getResultList();
		return Collections.unmodifiableList(transactions);
	}
}
