package com.chintan.tax.person;

import java.math.BigDecimal;

public class ItemInfo {

	private String itemName;
	private String itemType;
	private BigDecimal itemPrice;

	public ItemInfo(String itemName, String itemType, BigDecimal itemPrice) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "ItemInfo [itemName=" + itemName + ", itemType=" + itemType + ", itemPrice=" + itemPrice + "]";
	}

	public BigDecimal totalCost(BigDecimal taxPercent) {

		return new BigDecimal(
				getItemPrice().doubleValue() * taxPercent.doubleValue() / 100 + getItemPrice().doubleValue());

	}
}
