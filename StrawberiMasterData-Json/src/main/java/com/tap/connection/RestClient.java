package com.tap.connection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.tap.model.Hotel_Attributes;
import com.tap.model.Hotel_Special_Event;
import com.tap.model.Item;
import com.tap.model.Item2;
import com.tap.model.Item_Attributes;
import com.tap.model.Item_Content;
import com.tap.model.Item_Defaults;
import com.tap.model.Items;
import com.tap.model.Land_Package_Attributes;
import com.tap.model.Package_Product_Alternatives;
import com.tap.model.Package_Product_Alternatives_Item;
import com.tap.model.Product_Bundle;
import com.tap.model.Product_Bundle_Attribute;
import com.tap.model.Sight_Seeing_Attribute;

public class RestClient {

	private static final String REST_URI = "http://13.232.237.47:8000/api/resource/Item";
	private static final String ITEM_URL = "http://13.232.237.47:8000/api/resource/Item";
	private static final String PRODUCT_BUNDLE_URL = "http://13.232.237.47:8000/api/resource/Product Bundle";
	private static final String Hotel_ATTRIBUTES_URL = "http://13.232.237.47:8000/api/resource/Hotel Attribute";
	private static final String PRODUCT_BUNDLE_ATTRIBUTE_URL = "http://13.232.237.47:8000/api/resource/Product Bundle Attribute";
	private static final String PACKAGE_PRODUCT_ALTERNATIVES_URL = null;
	private static final String LAND_PACKAGE_ATTRIBUTES_URL = "http://13.232.237.47:8000/api/resource/Land Package Attributes";
	private static final String SIGHT_SEEING_ATTRIBUTE_URL = null;
	private static final String REST_URI1 = "http://13.232.237.47:8000/api/method/login?usr=administrator&pwd=Strawberi@123";
	private Client client = ClientBuilder.newClient();

	public Response getLoginDetail() {
		try {
			return client.target(REST_URI1)

					.request(MediaType.APPLICATION_JSON)

					.get(Response.class);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;
	}

	public Response createItem(Item item) {
		JSONObject obj = new JSONObject(item);
		System.out.println("Item---" + obj.toString());
		try {

			return client.target(ITEM_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(item, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createHotel_attributes(Hotel_Attributes attributes) {
		JSONObject obj = new JSONObject(attributes);
		System.out.println("Hotel_Attributes--" + obj.toString());
		try {

			return client.target(Hotel_ATTRIBUTES_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(attributes, MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createPackage_product_alternatives(Package_Product_Alternatives product_alternatives) {
		JSONObject obj = new JSONObject(product_alternatives);
		System.out.println("Package_Product_Alternatives---" + obj.toString());
		try {

			return client.target(PACKAGE_PRODUCT_ALTERNATIVES_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(product_alternatives, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createProduct_bundle(Product_Bundle product_bundle) {
		JSONObject obj = new JSONObject(product_bundle);
		System.out.println("Product_Bundle---" + obj.toString());
		try {

			return client.target(PRODUCT_BUNDLE_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(product_bundle, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createProduct_bundle_attribute(Product_Bundle_Attribute bundle_attribute) {
		JSONObject obj = new JSONObject(bundle_attribute);
		System.out.println("Package_Product_Alternatives---" + obj.toString());
		try {

			return client.target(PRODUCT_BUNDLE_ATTRIBUTE_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(bundle_attribute, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createLand_package_attributes(Land_Package_Attributes package_attribute) {
		JSONObject obj = new JSONObject(package_attribute);
		System.out.println("Land_Package_Attributes---" + obj.toString());
		try {

			return client.target(LAND_PACKAGE_ATTRIBUTES_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(package_attribute, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createSight_seeing_attribute(Sight_Seeing_Attribute sight_attribute) {
		JSONObject obj = new JSONObject(sight_attribute);
		System.out.println("Land_Package_Attributes---" + obj.toString());
		try {

			return client.target(SIGHT_SEEING_ATTRIBUTE_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(sight_attribute, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public Response createItemjson(Item2 sample_item) {
		JSONObject obj = new JSONObject(sample_item);
		System.out.println("Item---" + obj.toString());
		try {
			return client.target(ITEM_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(sample_item, MediaType.APPLICATION_JSON));

		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}

	public static void main(String args[]) throws JSONException, Exception {
		setItem_data();
		setProduct_bundle_data();
		setProduct_bundle_attribute_data();
		setLand_package_attributes_data();
	}
		
	

	private static void setProduct_bundle_attribute_data()throws JSONException, Exception {
		RestClient rc = new RestClient();
		FileReader reader = new FileReader("db.properties");
		Properties p = new Properties();
		p.load(reader);
		String product_bundle=p.getProperty("productbundleattribute.product_bundle");
		String currency=p.getProperty("productbundleattribute.currency");
		//String country=p.getProperty("productbundleattribute_staticvalue.country");
		String continent=p.getProperty("productbundleattributestaticvalue.continent");
		String state=p.getProperty("productbundleattribute.state");
		String tour_type=p.getProperty("productbundleattribute_staticvalue.tour_type");
		String tour_category=p.getProperty("productbundleattribute_staticvalue.tour_category");
		String minimum_price=p.getProperty("productbundleattribute.minimum_price");
		String country1=p.getProperty("productbundleattribute.country");
	
		Product_Bundle_Attribute attributes=new Product_Bundle_Attribute();
		int no_of_package = 10;
		try {

			JsonFactory jsonfactory = new JsonFactory();
			File source = new File("Domestic_Packages.txt");

			JsonParser parser = jsonfactory.createJsonParser(source);
			JsonToken current;
			for (int i = 1; i <= no_of_package; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");
				current = parser.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;
				}

				while (parser.nextToken() != JsonToken.END_OBJECT) {
					String fieldName = parser.getCurrentName();
					current = parser.nextToken();

					
				/*	if(fieldName.equals(continent)) {
						attributes.setContinent(parser.getText());
						System.out.println("Continent : " + attributes.getContinent() + "\n");
					}
					else*/
					if (fieldName.equals(state)) {
						attributes.setState(parser.getText());
						System.out.println("State : " + attributes.getState() + "\n");
					}
					else if (fieldName.equals(product_bundle)) {
						attributes.setProduct_bundle(parser.getText());
						System.out.println("product_bundle : " + attributes.getProduct_bundle() + "\n");
					}
					else if (fieldName.equals(currency)) {
						attributes.setCurrency(parser.getText());
						System.out.println("Currency_code : " + attributes.getCurrency() + "\n");
					}
					else if (fieldName.equals(country1)) {
						attributes.setCountry(parser.getText());
						System.out.println("country : " + attributes.getCountry() + "\n");
					}
					else if (fieldName.equals(minimum_price)) {
						attributes.setMinimum_price(parser.getText());
						System.out.println("Cost_Amt : " + attributes.getMinimum_price() + "\n");
					}
					
					else {
						parser.skipChildren();
					}
					
				}

				//setting static values
				attributes.setContinent(continent);
				//attributes.setCountry(country);
				attributes.setTour_type(tour_type);
				attributes.setTour_category(tour_category);
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");
				
				
				Response r = rc.createProduct_bundle_attribute(new Product_Bundle_Attribute(attributes.getProduct_bundle()+" PACKAGE",attributes.getCurrency(),attributes.getMinimum_price(),attributes.getContinent(),attributes.getCountry(),attributes.getState(),attributes.getTour_type(),attributes.getTour_category()));
				System.out.println("Status---" + r.getStatus());
				System.out.println("Status Info---" + r.getStatusInfo());
				System.out.println("Status Info---" + r.getStringHeaders());
				System.out.println(r.readEntity(String.class));
				System.out.println("\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");

			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}
	}

	private static void setProduct_bundle_data()throws JSONException, Exception {
		RestClient rc = new RestClient();
		FileReader reader = new FileReader("db.properties");
		Properties p = new Properties();
		p.load(reader);
	    String new_item_code = p.getProperty("productbundel.new_item_code");
		String introduction = p.getProperty("productbundel.introduction");
		String qty = p.getProperty("productbundel_bundleitems_staticvalue.qty");
		int no_of_package = 10;
		Product_Bundle attributes=new Product_Bundle();
		try {

			JsonFactory jsonfactory = new JsonFactory();
			File source = new File("Domestic_Packages.txt");

			JsonParser parser = jsonfactory.createJsonParser(source);
			JsonToken current;
			for (int i = 1; i <= no_of_package; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");
				current = parser.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;
				}

				while (parser.nextToken() != JsonToken.END_OBJECT) {
					String fieldName = parser.getCurrentName();
					current = parser.nextToken();

					if (fieldName.equals(new_item_code)) {
						attributes.setNew_item_code(parser.getText());
						System.out.println("Parent_Item_Code : " + attributes.getNew_item_code() + "\n");
					}
					else if (fieldName.equals(introduction)) {
						attributes.setIntroduction(parser.getText());
						System.out.println("Introduction : " + attributes.getIntroduction() + "\n");
					}
					
					else {
						parser.skipChildren();
					}
				}
				
							
				//adding Bundle_Items values
				ArrayList<Items> items = new ArrayList<Items>();
				Items item = new Items();
				item.setItem_code(attributes.getNew_item_code());	
				//adding static values of Bundle_Items
				item.setQty(qty);
				items.add(item);
				System.out.println("Item_Code : " + item.getItem_code() + "\n");
				System.out.println("Qty : " + item.getQty() + "\n");
				
				
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");
				
				Response r = rc.createProduct_bundle(new Product_Bundle(attributes.getNew_item_code()+" PACKAGE",attributes.getIntroduction(),items));
				System.out.println("Status---" + r.getStatus());
				System.out.println("Status Info---" + r.getStatusInfo());
				System.out.println("Status Info---" + r.getStringHeaders());
				System.out.println(r.readEntity(String.class));
				System.out.println("\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");

			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}
		
	}

   	private static void setLand_package_attributes_data() throws JSONException, Exception{

		RestClient rc = new RestClient();
		FileReader reader = new FileReader("db.properties");
		Properties p = new Properties();
		p.load(reader);
		String item = p.getProperty("Land_Package_Attributes.item");
		String validity_from=p.getProperty("Land_Package_Attributes.validity_from");
		String validity_up_to=p.getProperty("Land_Package_Attributes.validity_up_to");
		//String country=p.getProperty("Land_Package_Attributes_staticvalue.country");
		String continent=p.getProperty("Land_Package_Attributes_staticvalue.continent");
		String number_of_days=p.getProperty("Land_Package_Attributes.number_of_days");
		String number_of_nights=p.getProperty("Land_Package_Attributes.number_of_nights");
		String state=p.getProperty("Land_Package_Attributes.state");
		String minimum_price=p.getProperty("Land_Package_Attributes.minimum_price");
		String country1=p.getProperty("Land_Package_Attributes.country");
		
		
		Land_Package_Attributes attributes=new Land_Package_Attributes();
		int no_of_package = 10;
		String date2_validity_from=null;
		String date2_validity_up_to=null;
		try {

			JsonFactory jsonfactory = new JsonFactory();
			File source = new File("Domestic_Packages.txt");

			JsonParser parser = jsonfactory.createJsonParser(source);
			JsonToken current;
			for (int i = 1; i <= no_of_package; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");
				current = parser.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;
				}

				while (parser.nextToken() != JsonToken.END_OBJECT) {
					String fieldName = parser.getCurrentName();
					current = parser.nextToken();

					
					/*if(fieldName.equals(continent)) {
						attributes.setContinent(parser.getText());
						System.out.println("Continent : " + attributes.getContinent() + "\n");
					}
					else*/
					if (fieldName.equals(state)) {
						attributes.setState(parser.getText());
						System.out.println("State : " + attributes.getState() + "\n");
					}
					else if (fieldName.equals(item)) {
						attributes.setItem(parser.getText());
						//item_value = parser.getText();
						// ParseJson.setItem_code_value(new_item);
						System.out.println("item : " + attributes.getItem() + "\n");
					}
					else if (fieldName.equals(validity_from)) {
						  date2_validity_from=parser.getText();  
						//attributes.setValidity_from(date2);
						System.out.println("validity_from : " + date2_validity_from + "\n");
					}
					else if (fieldName.equals(validity_up_to)) {
						  date2_validity_up_to=parser.getText(); 
						//attributes.setValidity_up_to(parser.getText());
						System.out.println("validity_up_to : " + date2_validity_up_to + "\n");
					}
					else if (fieldName.equals(number_of_days)) {
						attributes.setNumber_of_days(parser.getText());
						System.out.println("number_of_days : " + attributes.getNumber_of_days() + "\n");
					}
					else if (fieldName.equals(number_of_nights)) {
						attributes.setNumber_of_nights(parser.getText());
						System.out.println("number_of_nights : " + attributes.getNumber_of_nights() + "\n");
					}
					
					else if (fieldName.equals(country1)) {
						attributes.setCountry(parser.getText());
						System.out.println("country : " + attributes.getCountry() + "\n");
					}
					else if (fieldName.equals(minimum_price)) {
						attributes.setMinimum_price(parser.getText());
						System.out.println("Cost_Amt : " + attributes.getMinimum_price() + "\n");
					}
					else {
						parser.skipChildren();
					}
					
				}
				
				//setting static values
				attributes.setContinent(continent);
				//attributes.setCountry(country);

				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");
				
				String date_from=date2_validity_from.substring(0,10);
				System.out.println(date_from);
		        String date_upto=date2_validity_up_to.substring(0,10);
				System.out.println(date_upto);
				Response r = rc.createLand_package_attributes(new Land_Package_Attributes(attributes.getItem(),attributes.getNumber_of_days(),attributes.getNumber_of_nights(),date_from,date_upto,attributes.getContinent(),attributes.getCountry(),attributes.getState(),attributes.getMinimum_price()));
				System.out.println("Status---" + r.getStatus());
				System.out.println("Status Info---" + r.getStatusInfo());
				System.out.println("Status Info---" + r.getStringHeaders());
				System.out.println(r.readEntity(String.class));
				System.out.println("\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");

			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}
	}

	private static void setItem_data() throws JSONException, Exception{
		RestClient rc = new RestClient();
		FileReader reader = new FileReader("db.properties");
		Properties p = new Properties();
		p.load(reader);
		String item_code = p.getProperty("item.item_code");
		String item_group = p.getProperty("item.item_group");	
		String stock_uom = p.getProperty("item_staticvalue.stock_uom");
		String company = p.getProperty("item_itemdefault_staticvalue.company");
		String category = p.getProperty("item_staticvalue.category");
				
		int no_of_package = 10;
		Item2 attributes=new Item2();
		try {

			JsonFactory jsonfactory = new JsonFactory();
			File source = new File("Domestic_Packages.txt");

			JsonParser parser = jsonfactory.createJsonParser(source);
			JsonToken current;
			for (int i = 1; i <= no_of_package; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");
				current = parser.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;
				}

				while (parser.nextToken() != JsonToken.END_OBJECT) {
					String fieldName = parser.getCurrentName();
					current = parser.nextToken();

					if (fieldName.equals(item_code)) {
						//package_value = parser.getText();
						attributes.setItem_code(parser.getText());
						attributes.setItem_name(parser.getText());
						System.out.println("Item_Code : " + attributes.getItem_code() + "\n");
						System.out.println("Item_name : " + attributes.getItem_name() + "\n");
					}
					else if (fieldName.equals(item_group)) {
						attributes.setItem_group(parser.getText());
						System.out.println("item Group : " + attributes.getItem_group() + "\n");
					}
					// accessing nested array data
					else {
						parser.skipChildren();
					}
				}
				
				//static values setting	
				attributes.setStock_uom(stock_uom);
				System.out.println("stock_uom : " + attributes.getStock_uom() + "\n");
				attributes.setCategory(category);
				System.out.println("category : " + attributes.getCategory() + "\n");
				
				//adding item_default values
				ArrayList<Item_Defaults> item_default = new ArrayList<Item_Defaults>();
				Item_Defaults item = new Item_Defaults();
				item.setCompany(company);				
				item_default.add(item);
				System.out.println("company : " + item.getCompany() + "\n");
				
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");
				
				
				Response r = rc.createItemjson(new Item2(attributes.getItem_code(), attributes.getItem_name(), attributes.getStock_uom(),attributes.getItem_group(),attributes.getCategory(),true,true,item_default));
				System.out.println("Status---" + r.getStatus());
				System.out.println("Status Info---" + r.getStatusInfo());
				System.out.println("Status Info---" + r.getStringHeaders());
				System.out.println(r.readEntity(String.class));
				System.out.println("\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");

				
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" Parent Item DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");
				Response r1 = rc.createItemjson(new Item2(attributes.getItem_code()+" PACKAGE", attributes.getItem_name()+" PACKAGE", attributes.getStock_uom(),attributes.getItem_group(),attributes.getCategory(),false,false,item_default));
				System.out.println("Status---" + r1.getStatus());
				System.out.println("Status Info---" + r1.getStatusInfo());
				System.out.println("Status Info---" + r1.getStringHeaders());
				System.out.println(r1.readEntity(String.class));
				System.out.println("\n");
				System.out.println("--------------------------------------------------------INSERTING PACKAGE"+ i +" Parent Item DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");
			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}

		/*
		 * ArrayList<Item_Defaults> item_default = new ArrayList<Item_Defaults>();
		 * Item_Defaults item = new Item_Defaults(); item.setCompany("Strawberi");
		 * item_default.add(item);
		 * 
		 * ArrayList<Item_Content> item_content = new ArrayList<Item_Content>();
		 * Item_Content content = new Item_Content();
		 * content.setDescription("hiiitestinh"); content.setType("nill");
		 * content.setUrl(
		 * "https://www.youtube.com/watch?v=aUKXa1u0VYk&list=RDzmVz5GCdJy4&index=2");
		 * item_content.add(content);
		 * 
		 * ArrayList<Item_Attributes> item_attributes = new
		 * ArrayList<Item_Attributes>(); Item_Attributes attributes = new
		 * Item_Attributes(); attributes.setAttribute("STAR Rating"); //
		 * attid.setVariant_of("STAR Rating"); item_attributes.add(attributes);
		 * 
		 * Response r = rc .createItem(new Item("Ball-85", "Ball-85", "Nos", "Sikkim",
		 * item_default, item_content, true, item_attributes));
		 * System.out.println("Status---" + r.getStatus());
		 * System.out.println("Status Info---" + r.getStatusInfo());
		 * System.out.println("Status Info---" + r.getStringHeaders());
		 * System.out.println(r.readEntity(String.class));
		 */

		// String new_item=null;

	}

}