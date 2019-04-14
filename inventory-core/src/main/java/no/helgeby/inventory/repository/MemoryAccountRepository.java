package no.helgeby.inventory.repository;

import java.util.List;

import no.helgeby.inventory.model.Account;

public class MemoryAccountRepository implements AccountRepository {

	private long idSequence = -1;
	private List<Account> accounts;

	@Override
	public long insertAccount(Account account) throws ItemAlreadyCreatedException {
		if (account.hasId() && accounts.contains(account)) {
			throw new ItemAlreadyCreatedException("The account already exists.");
		}
		long id = getNewId();
		account.setId(id);
		accounts.add(account);
		return id;
	}

	@Override
	public Account deleteAccount(long id) {
		int i = 0;
		for (Account a : accounts) {
			if (a.getId() == id) {
				return accounts.remove(i);
			}
			i++;
		}
		return null;
	}

	@Override
	public Account getAccountById(long id) {
		int i = 0;
		for (Account a : accounts) {
			if (a.getId() == id) {
				return accounts.get(i);
			}
			i++;
		}
		return null;
	}

	private synchronized long getNewId() {
		idSequence++;
		return idSequence;
	}
}
