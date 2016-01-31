package fr.free.omathe.home.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import fr.free.omathe.home.commons.Validate;

/**
 * Data Transfer Object is the base class used for the REST web services responses.
 * @author oma
 *
 */
public abstract class Dto {

	/**
	 * The fields to be displayed.
	 * A field is a string representing a dto property that is mapped to a model property.
	 */
	protected final Set<String> visibleFields = new HashSet<String>(Arrays.asList("links"));

	protected Set<Link> links;

	public Dto() {
	}

	public void showFields(final Set<String> fields) {
		this.visibleFields.addAll(fields);
	}

	public Dto showField(final String field) {
		Validate.notNull(field, "field");

		this.visibleFields.add(field);
		return this;
	}

	public Dto hideField(final String field) {
		Validate.notNull(field, "field");

		this.visibleFields.remove(field);
		return this;
	}
	
	public void hideFields(final Set<String> fields) {
		this.visibleFields.removeAll(fields);
	}
	
	public boolean fieldVisible(final String field) {
		return this.visibleFields.contains(field);
	}

	public void addLink(final Link link) {
		if (links == null) {
			links = new HashSet<Link>();
		}
		links.add(link);
	}

}
