package no.helgeby.inventory.domain.repository;

import java.util.List;

import no.helgeby.inventory.domain.EntityValidationException;
import no.helgeby.inventory.domain.model.AccountCode;
import no.helgeby.inventory.domain.model.AccountDraft;
import no.helgeby.inventory.domain.model.StoredAccount;

public interface AccountRepository {

	StoredAccount createAccount(AccountDraft account) throws EntityValidationException;

	StoredAccount removeAccount(AccountCode code);

	List<StoredAccount> getAccounts();

}
