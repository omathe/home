package fr.free.omathe.home.commons;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Validation class essentially used to validate the method parameters.
 * 
 * @author aba
 *
 */
public class Validate {

	/**
	 * Check value is not null otherwise throw an exception
	 * 
	 * @param value
	 * @param paramName
	 */
	public static void notNull(final Object value, final String paramName) {
		if (value == null) {
			throw new IllegalStateException(MessageFormat.format("Parameter {0} can't be null", paramName));
		}
	}

	/**
	 * Check value is not blank (null, "", "   ") otherwise throw an exception
	 * 
	 * @param value
	 * @param paramName
	 */
	public static void notBlank(final String value, final String paramName) {
		if (StringUtils.isBlank(value)) {
			throw new IllegalStateException(MessageFormat.format("Parameter {0} can't be null, or blank", paramName));
		}
	}

	/**
	 * verify if the String value is a Enumeration value.
	 * 
	 * @param value
	 * @param enumClass
	 */
	@SuppressWarnings("unchecked")
	public static void checkEnumValue(final String value, final Class enumClass) {
		notNull(value, "value");
		notNull(enumClass, "enumClass");
		try {
			EnumUtils.isValidEnum(enumClass, value);
		} catch (Exception e) {
			throw new IllegalStateException(MessageFormat.format("unknown enum instance {0}", enumClass.getName()));
		}
	}

	/**
	 * Check if the map is not null and not empty
	 * 
	 * @param collection
	 * @param paramName
	 */
	public static void mapNotEmpty(final Map<?, ?> collection, final String paramName) {
		if (collection == null) {
			throw new IllegalStateException(MessageFormat.format("collection {0} can't be null", paramName));
		}
		if (collection.size() == 0) {
			throw new IllegalStateException(MessageFormat.format("collection {0} can't be empty", paramName));
		}
	}

	/**
	 * Check if collection is not null and not empty
	 * 
	 * @param collection
	 * @param paramName
	 */
	public static void collectionNotEmpty(final Collection<?> collection, final String paramName) {
		if (collection == null) {
			throw new IllegalStateException(MessageFormat.format("collection {0} can't be null", paramName));
		}
		if (collection.size() == 0) {
			throw new IllegalStateException(MessageFormat.format("collection {0} can't be empty", paramName));
		}
	}

	/**
	 * check if a String ip address is valid
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static boolean validateIPAddress(final String ipAddress) {
		String[] tokens = ipAddress.split("\\.");
		if (tokens.length != 4) {
			return false;
		}
		for (String str : tokens) {
			int i = Integer.parseInt(str);
			if ((i < 0) || (i > 255)) {
				return false;
			}
		}
		return true;
	}
}
