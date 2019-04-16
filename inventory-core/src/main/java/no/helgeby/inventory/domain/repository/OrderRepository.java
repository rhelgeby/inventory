package no.helgeby.inventory.domain.repository;

import java.util.List;

import no.helgeby.inventory.domain.EntityValidationException;
import no.helgeby.inventory.domain.model.DraftOrder;
import no.helgeby.inventory.domain.model.OrderCode;
import no.helgeby.inventory.domain.model.StoredOrder;

public interface OrderRepository {

	StoredOrder placeOrder(DraftOrder order) throws EntityValidationException;

	StoredOrder retractOrder(OrderCode code);

	List<StoredOrder> getOrders();

}
