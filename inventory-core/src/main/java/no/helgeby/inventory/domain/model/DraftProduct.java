package no.helgeby.inventory.domain.model;

public class DraftProduct extends AbstractProduct {

	public void setCode(ProductCode code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public void setNetWeight(Weight netWeight) {
		this.netWeight = netWeight;
	}

}
