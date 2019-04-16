package no.helgeby.inventory.domain.repository;

import java.util.List;

import no.helgeby.inventory.domain.EntityValidationException;
import no.helgeby.inventory.domain.model.DraftProduct;
import no.helgeby.inventory.domain.model.DraftProductType;
import no.helgeby.inventory.domain.model.ProductCode;
import no.helgeby.inventory.domain.model.ProductTypeCode;
import no.helgeby.inventory.domain.model.StoredProduct;
import no.helgeby.inventory.domain.model.StoredProductType;

public interface ProductRepository {

	StoredProduct createProduct(DraftProduct product) throws EntityValidationException;

	boolean updateProduct(ProductCode code, DraftProduct product) throws EntityValidationException;

	StoredProduct removeProduct(ProductCode code);

	List<StoredProduct> getProducts();

	StoredProductType createProductType(DraftProductType productType) throws EntityValidationException;

	StoredProductType removeProductType(ProductTypeCode code);

	List<StoredProductType> getProductTypes();

}
