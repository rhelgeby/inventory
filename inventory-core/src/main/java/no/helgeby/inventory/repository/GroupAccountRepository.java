package no.helgeby.inventory.repository;

import no.helgeby.inventory.model.Account;

public class GroupAccountRepository extends GroupRepository<AccountRepository> implements AccountRepository {

	public GroupAccountRepository(AccountRepository primaryRepository) {
		super(primaryRepository);
	}

	@Override
	public long insertAccount(Account account) throws ItemAlreadyCreatedException {
		long result = primaryRepository.insertAccount(account);
		for (AccountRepository r : shadowRepositories) {
			r.insertAccount(account);
		}
		return result;
	}

	@Override
	public Account deleteAccount(long id) {
		Account result = primaryRepository.deleteAccount(id);
		for (AccountRepository r : shadowRepositories) {
			r.deleteAccount(id);
		}
		return result;
	}

	@Override
	public Account getAccountById(long id) {
		return primaryRepository.getAccountById(id);
	}

}
