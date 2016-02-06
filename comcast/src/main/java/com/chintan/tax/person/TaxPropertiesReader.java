package com.chintan.tax.person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import com.chintan.tax.data.PropertyUtil;

public class TaxPropertiesReader {
	public static BigDecimal necessary;
	public static BigDecimal luxury;

	public static void readTaxValues() {
		try {
			PropertyUtil props = new PropertyUtil("src/main/resources/tax.info.properties");
			necessary = new BigDecimal(Double.parseDouble(props.getProperty("necessary")));
			luxury = new BigDecimal(Double.parseDouble(props.getProperty("luxury")));
			System.out.println("Necessary:" + necessary);
			System.out.println("luxury:" + luxury);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
