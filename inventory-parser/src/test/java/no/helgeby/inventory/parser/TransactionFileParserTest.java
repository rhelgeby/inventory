package no.helgeby.inventory.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import no.helgeby.inventory.model.Transaction;

public class TransactionFileParserTest {

	private List<ColumnDefinition> columns;
	private TransactionParser parser;

	@Before
	public void setUp() {
		columns = new ArrayList<>();
		columns.add(new ColumnDefinition("Date", ColumnType.DATE));
		columns.add(new ColumnDefinition("Description", ColumnType.DESCRIPTION));
		columns.add(new ColumnDefinition("Interest Date",
				ColumnType.INTEREST_DATE));
		columns.add(new ColumnDefinition("Withdrawal", ColumnType.WITHDRAWAL));
		columns.add(new ColumnDefinition("Deposit", ColumnType.DEPOSIT));

		final String dateFormat = "dd.MM.yyyy";
		parser = new TransactionParser(columns, true, dateFormat);
	}

	@Test
	public void shouldParseDate() {
		String line = "\"30.11.2016\";\"A Product\";\"01.12.2016\";\"42,71\";\"\"";
		Transaction transaction = parser.parseLine(line);
		Calendar expectedDate = new GregorianCalendar(2016, 10, 30);
		Assert.assertEquals("Date not matching.", expectedDate.getTime(),
				transaction.getDate());
	}

	@Test
	public void shouldParseDescription() {
		String line = "\"30.11.2016\";\"A Product\";\"01.12.2016\";\"42,71\";\"\"";
		Transaction transaction = parser.parseLine(line);
		Assert.assertEquals("Description not matching.", "A Product",
				transaction.getDescription());
	}

	@Test
	public void shouldParseInterestDate() {
		String line = "\"30.11.2016\";\"A Product\";\"01.12.2016\";\"42,71\";\"\"";
		Transaction transaction = parser.parseLine(line);
		Calendar expectedInterestDate = new GregorianCalendar(2016, 11, 1);
		Assert.assertEquals("Interest date not matching.",
				expectedInterestDate.getTime(), transaction.getInterestDate());
	}

	@Test
	public void shouldParseWithdrawal() {
		String line = "\"30.11.2016\";\"A Product\";\"01.12.2016\";\"42,71\";\"\"";
		Transaction transaction = parser.parseLine(line);
		BigDecimal expectedWithdrawal = new BigDecimal("42.71");
		Assert.assertEquals("Withdrawal not matching.", expectedWithdrawal,
				transaction.getWithdrawal());
	}

	@Test
	public void shouldParseDeposit() {
		String line = "\"30.11.2016\";\"A Product\";\"01.12.2016\";\"\";\"12.345,67\"";
		Transaction transaction = parser.parseLine(line);
		BigDecimal expectedWithdrawal = new BigDecimal("12345.67");
		Assert.assertEquals("Deposit not matching.", expectedWithdrawal,
				transaction.getDeposit());
	}

}
