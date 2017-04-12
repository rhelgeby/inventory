package no.helgeby.inventory.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import no.helgeby.inventory.model.Transaction;

public class TransactionParser {

	private static final Log logger = LogFactory.getLog(TransactionParser.class);

	private static final String COLUMN_SEPARATOR = ";";
	private static final String COLUMN_QUOTE = "\"";

	private List<TransactionColumn> columnDefinitions;
	private boolean quotedColumns;
	private DateFormat dateFormat;
	private boolean skipFirstLine = false;

	public TransactionParser(List<TransactionColumn> columnDefinitions, boolean quotedColumns, String dateFormat) {
		this.columnDefinitions = columnDefinitions;
		this.quotedColumns = quotedColumns;
		this.dateFormat = new SimpleDateFormat(dateFormat);
	}

	public List<Transaction> parse(BufferedReader reader) throws IOException {
		List<Transaction> transactions = new ArrayList<>();

		if (skipFirstLine) {
			reader.readLine();
		}

		String line = reader.readLine();
		while (StringUtils.isNotBlank(line)) {
			transactions.add(parseLine(line));
			line = reader.readLine();
		}

		return transactions;
	}

	public Transaction parseLine(String line) {
		Transaction transaction = new Transaction();

		String[] columns = line.split(COLUMN_SEPARATOR);
		for (int i = 0; i < columns.length; i++) {
			String column = columns[i];
			if (quotedColumns) {
				column = StringUtils.substringBetween(columns[i], COLUMN_QUOTE);
			}
			if (StringUtils.isBlank(column)) {
				continue;
			}
			TransactionColumn definition = columnDefinitions.get(i);

			try {
				switch (definition.getType()) {
				case SKIP:
					break;
				case DATE:
					transaction.setDate(parseDate(column));
					break;
				case DESCRIPTION:
					transaction.setDescription(column);
					break;
				case INTEREST_DATE:
					transaction.setInterestDate(parseDate(column));
					break;
				case WITHDRAWAL:
					transaction.setWithdrawal(parseNumber(column));
					break;
				case DEPOSIT:
					transaction.setDeposit(parseNumber(column));
					break;
				default:
					logger.warn("Unknown type for column at index " + i + ": " + definition.getType());
				}
			} catch (ParseException ex) {
				logger.warn("Failed to parse column at index " + i + ": " + column);
			}
		}
		return transaction;
	}

	private Date parseDate(String column) throws ParseException {
		return dateFormat.parse(column);
	}

	private BigDecimal parseNumber(String value) throws ParseException {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("#,#", symbols);
		decimalFormat.setParseBigDecimal(true);

		return (BigDecimal) decimalFormat.parse(value);
	}

	public boolean isSkipFirstLine() {
		return skipFirstLine;
	}

	public void setSkipFirstLine(boolean skipFirstLine) {
		this.skipFirstLine = skipFirstLine;
	}

}
