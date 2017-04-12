package no.helgeby.inventory.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import no.helgeby.inventory.model.Transaction;
import no.helgeby.inventory.parser.TransactionColumn;
import no.helgeby.inventory.parser.TransactionColumnType;
import no.helgeby.inventory.parser.TransactionParser;

public class Sandbox {

	private static final Log logger = LogFactory.getLog(Sandbox.class);

	public static void main(String[] args) {
		InputStreamReader inputStreamReader = new InputStreamReader(
				Sandbox.class.getResourceAsStream("/transactions.csv"));
		BufferedReader reader = new BufferedReader(inputStreamReader);

		List<TransactionColumn> columns = new ArrayList<>();
		columns.add(new TransactionColumn("Date", TransactionColumnType.DATE));
		columns.add(new TransactionColumn("Description", TransactionColumnType.DESCRIPTION));
		columns.add(new TransactionColumn("Interest Date",
				TransactionColumnType.INTEREST_DATE));
		columns.add(new TransactionColumn("Withdrawal", TransactionColumnType.WITHDRAWAL));
		columns.add(new TransactionColumn("Deposit", TransactionColumnType.DEPOSIT));

		final String dateFormat = "dd.MM.yyyy";
		TransactionParser parser = new TransactionParser(columns, true, dateFormat);

		parser.setSkipFirstLine(true);
		try {
			List<Transaction> transactions = parser.parse(reader);

			printTransactions(transactions);
			sumTransactions(transactions);

			reader.close();
			inputStreamReader.close();
		} catch (IOException e) {
			logger.error("Failed to parse transactions.", e);
		}

	}

	private static void printTransactions(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}

	private static void sumTransactions(List<Transaction> transactions) {
		BigDecimal sumWithdrawal = BigDecimal.ZERO;
		BigDecimal sumDeposit = BigDecimal.ZERO;

		for (Transaction transaction : transactions) {
			BigDecimal withdrawal = transaction.getWithdrawal();
			BigDecimal deposit = transaction.getDeposit();
			if (withdrawal != null) {
				sumWithdrawal = sumWithdrawal.add(withdrawal);
			}
			if (deposit != null) {
				sumDeposit = sumDeposit.add(deposit);
			}
		}

		BigDecimal balance = sumDeposit.subtract(sumWithdrawal);

		System.out.println("Withdrawal: " + sumWithdrawal);
		System.out.println("Deposit: " + sumDeposit);
		System.out.println("Balance: " + balance);
	}

}
