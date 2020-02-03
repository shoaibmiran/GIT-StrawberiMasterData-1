package com.tap.connection;

import com.fasterxml.jackson.databind.*;
import com.tap.model.Hotels;
import com.tap.model.Package_Product_Alternatives;
import com.tap.model.Package_Product_Alternatives_Item;
import com.tap.model.VariantPrice;
import com.fasterxml.jackson.core.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Product_Alternatives_toERP {
	private static final String PACKAGE_PRODUCT_ALTERNATIVES_URL = "http://betaerp.edawjar.in:8000/api/resource/Package Product Alternatives";
	private Client client = ClientBuilder.newClient();
	
	
	
	public static void main(String[] args) throws JSONException, Exception {
	FileReader reader = new FileReader("db2.properties");

	Properties p = new Properties();
	p.load(reader);

	String package_name = p.getProperty("package_name");
	package_name=package_name.toUpperCase();
	
	setdata(package_name);
}
	@SuppressWarnings("null")
	public static void setdata(String package_names) throws JSONException, Exception {
		String places[] = null;
		String hotels[] = null;
		Hotels[] szHotels = null;
		String hotel_name = null;
		String sharemode;
		String package_id = null;
		Hotels attributes = new Hotels();
		VariantPrice price = new VariantPrice();
		VariantPrice[] szprice = null;
		boolean present = false;
		boolean id = false;
		int nofop = 0;
		String continent = null;
		String piddd = "";
		Package_Product_Alternatives attributes2 = new Package_Product_Alternatives();
		try {
			Set<String> hashSet = new HashSet<String>(Arrays.asList(package_names.split(",")));
			System.out.println("daata" + hashSet);

			JsonFactory f = new MappingJsonFactory();
			JsonParser jp = f.createParser(new File("employees2.json"));
			//JsonParser jp = f.createParser(new File("fit-pkgs.txt"));
			JsonToken current;
			for (int i = 1; i <=2800; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");

				current = jp.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;

				}

				while (jp.nextToken() != JsonToken.END_OBJECT) {

					// move from field name to field value
					current = jp.nextToken();

					String fieldName = jp.getCurrentName();
					// move from field name to field value
					if (fieldName.equals("package_name")) {
						System.out.println("field Value:" + jp.getText());
						String casecheck = jp.getText().toUpperCase();
						id = hashSet.contains(jp.getText());
						System.out.println(id);

						if (hashSet.contains(casecheck)) {
							package_id = getPackage_id(jp.getText());
							
							present = checkPresent_in_db(package_id, piddd);
							if (i == 1) {
								piddd = piddd + package_id;
							} else if (i > 1) {
								piddd = piddd + "," + package_id;
							}
							if (package_id == null) {
								System.out.println(jp.getText() + " not found in DB, ignoring this package");
							}
						} else {
							System.out.println(jp.getText() + " not found in PROPERTIES FILe, ignoring this package");
						}
					}

					else if (fieldName.equals("costing")) {
						if (current == JsonToken.START_ARRAY) {
							// For each of the records in the array
							int no = 1;
							while (jp.nextToken() != JsonToken.END_ARRAY) {

								if (package_id == null || id == false || present == true) {
								}

								// read the record into a tree model,
								// this moves the parsing position to the end of it

								else if (package_id != null && present == false) {
									
									System.out.println("\n----------------------COSTING ARRAY " + no
											+ "  IS STARTED-----------------------------------------\n");
									// And now we have random access to everything in the object
									JsonNode node = jp.readValueAsTree();
									hotel_name = node.get("HTL_NM1").asText();
									System.out.println(hotel_name);
									long count = count_hotels.count(hotel_name, ':');
									System.out.println(count);
									if (count >= 1) {
										System.out.println("No Of Hotels:" + count + "\n");
										int length = hotel_name.length();

										places = string_split.getplaces(hotel_name);
										hotels = string_split.gethotels(hotel_name);

										// ######################seperating ,,,, in hotel name###############//
										String[] sep = null;
										String original = "";
										String htoriginal = "";
										String original1[] = null;
										for (int x = 0; x < hotels.length; x++) {

											sep = hotels[x].split("[,]");
											System.out.println(sep.length);
											for (int d1 = 0; d1 < sep.length; d1++) {
												if (x == 0 && d1 == 0) {
													original = original + sep[d1];
													htoriginal = htoriginal + places[x];
												} else if (x > 0 || (x == 0 && d1 == 1)) {
													original = original + "," + sep[d1];
													htoriginal = htoriginal + "," + places[x];
												}
												System.out.println((original));
											}

										}
										String strArray[] = original.split(",");

										System.out.println("String hotels converted to String array");

										// print elements of String array
										for (int y = 0; y < strArray.length; y++) {
											System.out.println(strArray[y]);
										}
										hotels = strArray;

										String strArray1[] = htoriginal.split(",");

										System.out.println("String places converted to String array");

										// print elements of String array
										for (int y = 0; y < strArray1.length; y++) {
											System.out.println(strArray1[y]);

										}
										places = strArray1;

										// #############################333333333333333333333/////////////

										int l = 1;
										for (int k = 0; k < hotels.length; k++) {

											String str1 = hotels[k];

//												String replace = str1.replace("@ ", "@");

											System.out.println("Hotel Name--" + l + " is ---" + str1.trim());
											l++;
										}

										int m = 1;
										for (int k = 0; k < places.length; k++) {

											String str1 = places[k];
											System.out.println("Place Name--" + m + " is ---" + str1.trim());
											m++;
										}
										System.out.println("Hotel Names-------" + Arrays.toString(hotels));
										System.out.println("Place Names-------" + Arrays.toString(places));
									}

									else if (count == 0) {
										long count11 = count_hotels.count(hotel_name, ',');
										if (count11 == 0) {
											System.out.println("No Of Hotels:1\n");
										} else if (count11 >= 1) {
											count11 = count11 + 1;
											System.out.println("No Of Hotels:" + count11 + "\n");
										}

										int length = hotel_name.length();
										System.out.println(length);

										hotels = string_split.gethotelssingle(hotel_name);

										// ######################seperating ,,,, in hotel name###############//
										String[] sep = null;
										String original = "";
										String htoriginal = "";
										for (int x = 0; x < hotels.length; x++) {

											sep = hotels[x].split("[,]");
											System.out.println(sep.length);
											for (int d1 = 0; d1 < sep.length; d1++) {
												if (x == 0 && d1 == 0) {
													original = original + sep[d1];
												} else if (x > 0 || (x == 0 && d1 == 1)) {
													original = original + "," + sep[d1];
												}
												System.out.println((original));
											}

										}
										String strArray[] = original.split(",");

										System.out.println("String hotels converted to String array");

										// print elements of String array
										for (int y = 0; y < strArray.length; y++) {
											System.out.println(strArray[y]);
										}
										hotels = strArray;

										System.out.println("Hotel Names singleee-------" + Arrays.toString(hotels));
										System.out.println(hotels.length);
										// places = new String[1];
										places = HotelDao.getplaceName(package_id);
										String p[] = places;
										if (places[0] == null) {
											places = new String[hotels.length];
											for (int u = 0; u < hotels.length; u++) {
												places[u] = "";
											}

										} else if (places[0] != null) {
											places = new String[hotels.length];
											for (int u = 0; u < hotels.length; u++) {
												places[u] = p[0];
											}

										}

									}

									szHotels = new Hotels[hotels.length];
									szprice = new VariantPrice[hotels.length];

									for (int htCount = 0; htCount < hotels.length; htCount++) {

										Package_Product_Alternatives_Item varaint = new Package_Product_Alternatives_Item();
										varaint.setCategory("Hotel");
										String str1 = hotels[htCount];
										varaint.setProduct(str1.trim());
										String str11 = places[htCount];
										varaint.setLocation(str11.trim());

										attributes2.Allproductalt(varaint);
									}
									//attributes2.setProduct_bundle(package_id);
									System.out.println("\n----------------------COSTING ARRAY " + no
											+ "  IS ENDED-----------------------------------------\n");
								}
								
							}
							
						} else {
							System.out.println("Error: records should be an array: skipping.");
							jp.skipChildren();
						}
					}
					 else {
						// System.out.println("Unprocessed/unused property: " + fieldName);
						jp.skipChildren();
					}
					
				}
				if (package_id == null || id == false || present == true) {
				}
				else if (package_id != null && present == false) {
					setAlternatives(attributes2,package_id);
					}
					attributes2=new Package_Product_Alternatives();
				
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}

	}

	private static void setAlternatives(Package_Product_Alternatives attributes2, String package_id) {
		Connection conn = null;
		Statement stmt = null;
		boolean found=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitjsontodb", "root", "tiger");

			stmt = conn.createStatement();
			String sql = "SELECT * from fit_transfer_service";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String transfer_id = rs.getString("Transfer_service_id");
				String p_list=rs.getString("package_id_list");
				String place=rs.getString("place");
				
				Set<String> hashSet = new HashSet<String>(Arrays.asList(p_list.split(", ")));
				
				if (found=hashSet.contains(package_id)) {
					Package_Product_Alternatives_Item varaint = new Package_Product_Alternatives_Item();
					varaint.setCategory("Airport Transfer");
					varaint.setProduct(transfer_id);
					varaint.setLocation(place);

					attributes2.Allproductalt(varaint);
				}
			}
			
			setAttraction(attributes2,package_id);
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}

	private static void setAttraction(Package_Product_Alternatives attributes2, String package_id) {
		Connection conn = null;
		Statement stmt = null;
		boolean found=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitjsontodb", "root", "tiger");

			stmt = conn.createStatement();
			String sql = "SELECT * from fit_attraction";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String transfer_id = rs.getString("attraction_id");
				String p_list=rs.getString("package_id_list");
				String place=rs.getString("place");
				
				Set<String> hashSet = new HashSet<String>(Arrays.asList(p_list.split(", ")));
				Set<String> hashSet2 = new HashSet<String>(Arrays.asList(p_list.split(",")));
				if (found=hashSet.contains(package_id)) {
					Package_Product_Alternatives_Item varaint = new Package_Product_Alternatives_Item();
					varaint.setCategory("Sightseeing");
					varaint.setProduct(transfer_id);
					varaint.setLocation(place);

					attributes2.Allproductalt(varaint);
				}
				if(found==false)
				{
				if (found=hashSet2.contains(package_id)) {
					Package_Product_Alternatives_Item varaint = new Package_Product_Alternatives_Item();
					varaint.setCategory("Sightseeing");
					varaint.setProduct(transfer_id);
					varaint.setLocation(place);

					attributes2.Allproductalt(varaint);
				}
				}
			}
			
			attributes2.setProduct_bundle(package_id);
			Product_Alternatives_toERP rs22=new Product_Alternatives_toERP();
			JSONObject obj = new JSONObject(attributes2);
			
			System.out.println("alternatives list---" + obj.toString());
			System.out.println("--------------------------------------------------------INSERTING PACKAGE DATA IN ERPNEXT SETUP IS STARTED--------------------------------------------------------\n");

			Response r = rs22.createPackage_product_alternatives(attributes2);

			System.out.println("Status---" + r.getStatus());
			System.out.println("Status Info---" + r.getStatusInfo());
			System.out.println("Status Info---" + r.getStringHeaders());
			System.out.println(r.readEntity(String.class));
			System.out.println("\n");
			System.out.println("--------------------------------------------------------INSERTING PACKAGE DATA IN ERPNEXT SETUP IS ENDED--------------------------------------------------------\n");
			
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	private static String getPackage_id(String name) {
		Connection conn = null;
		Statement stmt = null;
		String package_id = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitjsontodb", "root", "tiger");

			stmt = conn.createStatement();
			String sql = "SELECT item_code from fit_package_catalog_basic where item_name='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				package_id = rs.getString("item_code");
				System.out.println(package_id + "\n");
			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return package_id;

	}

	public static boolean checkPresent_in_db(String package_id, String piddd) {

		boolean pid = false;

		Set<String> hashSet = new HashSet<String>(Arrays.asList(piddd.split(",")));

		if (hashSet.contains(package_id)) {
			System.out.println("PACKAGE NAME DUPLICATE IN DATABASE \n");
			pid = true;
		} else {
			System.out.println("PACKAGE NAME NOT DUPLICATE IN DATABASE:\n");
			pid = false;
		}

		return pid;
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
	
}