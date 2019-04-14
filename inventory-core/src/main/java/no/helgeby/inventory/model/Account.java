package no.helgeby.inventory.model;

public class Account {

	private long id = -1;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasId() {
		return id >= 0;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Account)) {
			return false;
		}
		Account otherAccount = (Account) other;
		return getId() == otherAccount.getId();
	}

	public int hashCode() {
		return Long.hashCode(id);
	}
}
