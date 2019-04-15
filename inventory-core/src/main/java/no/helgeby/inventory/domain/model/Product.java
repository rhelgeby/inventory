package no.helgeby.inventory.domain.model;

public interface Product {

	ProductCode getCode();

	String getDescription();

	ProductType getType();

	Weight getNetWeight();

}
