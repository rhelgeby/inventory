package no.helgeby.inventory.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * A repository that writes synchronously to multiple repositories at once.
 * 
 * @param <T> The repository type.
 */
public abstract class GroupRepository<T> {

	protected final T primaryRepository;
	protected final List<T> shadowRepositories;

	public GroupRepository(T primaryRepository) {
		if (primaryRepository == null) {
			throw new IllegalArgumentException("Primary repository must not be null");
		}
		this.primaryRepository = primaryRepository;
		this.shadowRepositories = new ArrayList<>();
	}

	public T getPrimaryRepository() {
		return primaryRepository;
	}

	/**
	 * A list of the shadow repositories. Add or remove repositories to this
	 * list as needed.
	 * 
	 * @return A mutable list of shadow repositories.
	 */
	public List<T> getShadowRepositories() {
		return shadowRepositories;
	}
}
