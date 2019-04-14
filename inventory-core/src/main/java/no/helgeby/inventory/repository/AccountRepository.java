package no.helgeby.inventory.repository;

import no.helgeby.inventory.model.Account;

public interface AccountRepository {

	public long insertAccount(Account account) throws ItemAlreadyCreatedException;
	public Account deleteAccount(long id);
	public Account getAccountById(long id);

}
