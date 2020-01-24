package com.tap.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class Item {
	private String item_code = null;
	private String item_name = null;
	private String stock_uom = null;
	private String item_group = null;
	private HashMap itemdefault = null;
	private boolean has_variants;

	private ArrayList<Item_Defaults> item_defaults;
	private ArrayList<Item_Content> content;
	private ArrayList<Item_Attributes> attributes;

	public ArrayList<Item_Content> getContent() {
		return content;
	}

	public void setContent(ArrayList<Item_Content> content) {
		this.content = content;
	}

	public HashMap getItemdefault() {
		return itemdefault;
	}

	public void setItemdefault(HashMap itemdefault) {
		this.itemdefault = itemdefault;
	}

	public ArrayList<Item_Defaults> getItem_defaults() {
		return item_defaults;
	}

	public void setItem_defaults(ArrayList<Item_Defaults> item_defaults) {
		this.item_defaults = item_defaults;
	}

	public Item(String item_code, String item_name, String stock_uom, String item_group,
			ArrayList<Item_Defaults> item_defaults, ArrayList<Item_Content> content, boolean has_variants,
			ArrayList<Item_Attributes> attributes) {
		this.item_code = item_code;
		this.item_name = item_name;
		this.stock_uom = stock_uom;
		this.item_group = item_group;
		this.item_defaults = item_defaults;
		this.content = content;
		this.has_variants = has_variants;
		this.attributes = attributes;

	}

	public boolean isHas_variants() {
		return has_variants;
	}

	public void setHas_variants(boolean has_variants) {
		this.has_variants = has_variants;
	}

	public ArrayList<Item_Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<Item_Attributes> attributes) {
		this.attributes = attributes;
	}

	/*
	 * public Item(String item_code, String item_name, String stock_uom, String
	 * item_group, JSONObject itemdefault) { this.item_code=item_code;
	 * this.item_name=item_name; this.stock_uom=stock_uom;
	 * this.item_group=item_group; this.j=itemdefault; }
	 */
	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getStock_uom() {
		return stock_uom;
	}

	public void setStock_uom(String stock_uom) {
		this.stock_uom = stock_uom;
	}

	public String getItem_group() {
		return item_group;
	}

	public void setItem_group(String item_group) {
		this.item_group = item_group;
	}

	public Item() {
		super();
	}
}
