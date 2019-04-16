package no.helgeby.inventory.domain.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.junit.Test;

public class OrderLinesTest {

	@Test
	public void shouldCalculateTotalAmount() {
		// GIVEN
		List<StoredOrderLine> orderLines = new ArrayList<>();

		MonetaryAmount unitPrice = getAmountAsNOK(50);
		OrderLineCode orderLineCode = OrderLineCode.of("OL-1");
		ProductCode productCode = ProductCode.of("PC-1");
		BigDecimal amount = BigDecimal.valueOf(10);
		StoredOrderLine orderLine1 = new StoredOrderLine(orderLineCode, productCode, amount,
				unitPrice, "Dummy note.");

		unitPrice = getAmountAsNOK(25);
		orderLineCode = OrderLineCode.of("OL-1");
		productCode = ProductCode.of("PC-1");
		amount = BigDecimal.valueOf(10);
		StoredOrderLine orderLine2 = new StoredOrderLine(orderLineCode, productCode, amount,
				unitPrice, "Dummy note.");

		orderLines.add(orderLine1);
		orderLines.add(orderLine2);

		StoredOrderLines storedOrderLines = new StoredOrderLines(orderLines);

		// WHEN
		MonetaryAmount totalPrice = storedOrderLines.getTotalPrice(Monetary.getCurrency("NOK"));

		// THEN
		assertEquals(getAmountAsNOK(750), totalPrice);
	}

	private static MonetaryAmount getAmountAsNOK(long value) {
		return Monetary.getDefaultAmountFactory().setCurrency("NOK").setNumber(value).create();
	}
}
