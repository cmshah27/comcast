package com.chintan.tax.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	/** The props. */
	private Properties props = new Properties();

	/** The prop file name. */
	private String PROP_FILE_NAME;

	/**
	 * Instantiates a new property util.
	 *
	 * @param PROP_FILE
	 *            the prop file
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public PropertyUtil(final String PROP_FILE) throws FileNotFoundException, IOException {
		this.PROP_FILE_NAME = PROP_FILE;
		props.load(new FileInputStream(PROP_FILE));
	}

	/**
	 * Gets the property.
	 *
	 * @param KEY
	 *            the key
	 * @return the property
	 */
	public String getProperty(final String KEY) {
		return props.getProperty(KEY);
	}

	/**
	 * Sets the property.
	 *
	 * @param KEY
	 *            the key
	 * @param VALUE
	 *            the value
	 */
	public void setProperty(final String KEY, final String VALUE) {
		props.setProperty(KEY, VALUE);
	}

	@Override
	public String toString() {
		return "PropertyUtil [props=" + props + ", PROP_FILE_NAME=" + PROP_FILE_NAME + "]";
	}

}
