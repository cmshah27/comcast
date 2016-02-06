package com.chintan.tax.person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.testng.Reporter;

import com.chintan.tax.data.PropertyUtil;

public class TaxPerson {

	private static BigDecimal necessary;
	private static BigDecimal luxury;

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

	public static void main(String[] args) {

		readTaxValues();

		int priceofToothBrush = 100;
		int priceOfIphone = 65000;

		ItemInfo toothBrush = new ItemInfo("Pepsodent Tooth Brush", "Necessary", new BigDecimal(priceofToothBrush));
		System.out.printf("toothBrush.totalCost():%.2f", toothBrush.totalCost(necessary));
		;
		System.out.println();
		// iPhone Luxury $655.00
		ItemInfo iPhone = new ItemInfo("iPhone", "Luxury", new BigDecimal(priceOfIphone));
		String logMsg = String.format("iPhone.totalCost():%.2f", iPhone.totalCost(luxury));
		Reporter.log(logMsg);

	}

}
