package com.javatechie.spring.swagger.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Item  {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @ApiModelProperty(value = "Auto-generated ID")
	    private long itemID;
	    
		@ApiModelProperty(value = "This is the item number")
	    private long itemno;
		
		@ApiModelProperty(value = "This is the name of the item")
	    private String name;
		
		@ApiModelProperty(value = "The quantity of this particular item in the stock ")
	    private int quantityInStock;
		
		@ApiModelProperty(value = "The inventory code of the item ")
	    private String inventoryCode;
		
		public Item() {
			super();
		}
	
		public Item(long itemID, long itemno, String name, int quantityInStock, String inventoryCode) {
			super();
			this.itemID = itemID;
			this.itemno = itemno;
			this.name = name;
			this.quantityInStock = quantityInStock;
			this.inventoryCode = inventoryCode;
		}

		public long getItemID() {
			return itemID;
		}

		public void setItemID(long itemID) {
			this.itemID = itemID;
		}

		public long getItemno() {
			return itemno;
		}

		public void setItemno(long itemno) {
			this.itemno = itemno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getQuantityInStock() {
			return quantityInStock;
		}

		public void setQuantityInStock(int quantityInStock) {
			this.quantityInStock = quantityInStock;
		}

		public String getInventoryCode() {
			return inventoryCode;
		}

		public void setInventoryCode(String inventoryCode) {
			this.inventoryCode = inventoryCode;
		}

		@Override
		public String toString() {
			return "Item [itemID=" + itemID + ", itemno=" + itemno + ", name=" + name + ", quantityInStock="
					+ quantityInStock + ", inventoryCode=" + inventoryCode + "]";
		}

		
	
	
	
}
