package com.tap.model;

import java.util.ArrayList;

public class Product_Bundle {
	private String new_item_code = null;
	private String introduction = null;
	private String id = null;
	private String category = null;
	private String parent_product_bundle = null;
	private String package_type = null;
	private ArrayList<Items> items; 
	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	
	private ArrayList<Bundle_Itinerary> itinerary;

	/*public Product_Bundle(String new_item_code, String description, String id, String category,
			String parent_product_bundle, String package_type, ArrayList<Bundle_Items> items,
			ArrayList<Bundle_Itinerary> itinerary) {
		this.new_item_code = new_item_code;
		this.description = description;
		this.id = id;
		this.category = category;
		this.parent_product_bundle = parent_product_bundle;
		this.package_type = package_type;
		this.items = items;
		this.itinerary = itinerary;
	}*/
	
	

	public String getNew_item_code() {
		return new_item_code;
	}

	public Product_Bundle(String new_item_code,String introduction, ArrayList<Items> items) {
		this.new_item_code = new_item_code;
		this.introduction = introduction;
		this.items = items;
	}

	public void setNew_item_code(String new_item_code) {
		this.new_item_code = new_item_code;
	}

	
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getParent_product_bundle() {
		return parent_product_bundle;
	}

	public void setParent_product_bundle(String parent_product_bundle) {
		this.parent_product_bundle = parent_product_bundle;
	}

	public String getPackage_type() {
		return package_type;
	}

	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}

	
	

	public ArrayList<Bundle_Itinerary> getBundle_itinerary() {
		return itinerary;
	}

	public void setBundle_itinerary(ArrayList<Bundle_Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public Product_Bundle() {
		super();
	}
}
