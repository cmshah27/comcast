package com.chintan.tax.person;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxPersonTest {

	@DataProvider(name = "items")
	public Object[][] Items() {

		int priceofToothBrush = 100;
		int priceOfIphone = 65000;

		ItemInfo toothBrush = new ItemInfo("Pepsodent Tooth Brush", "Necessary", new BigDecimal(priceofToothBrush));
		ItemInfo iPhone = new ItemInfo("iPhone", "Luxury", new BigDecimal(priceOfIphone));

		return new Object[][] { new Object[] { toothBrush }, new Object[] { iPhone }, };
	}

	@BeforeMethod
	public void beforeMethod() {
		TaxPropertiesReader.readTaxValues();

	}

	@Test(dataProvider = "items")
	public void totalCostTest(ItemInfo item) {
		BigDecimal cost;
		String logMsg;
		switch (item.getItemType().toLowerCase()) {
		case "necessary":
			cost = item.totalCost(TaxPropertiesReader.necessary);
			logMsg = String.format("Cost:%.2f", cost);
			Reporter.log(logMsg);
			Assert.assertEquals(cost, new BigDecimal("101"));
			break;
		case "luxury":
			cost = item.totalCost(TaxPropertiesReader.luxury);
			logMsg = String.format("Cost:%.2f", cost);
			Reporter.log(logMsg);
			Assert.assertEquals(cost, new BigDecimal("70850"));
			break;
		}
	}

}
