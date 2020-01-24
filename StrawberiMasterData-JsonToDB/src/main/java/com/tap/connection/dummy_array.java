package com.tap.connection;

import com.fasterxml.jackson.databind.*;
import com.tap.model.Hotels;
import com.fasterxml.jackson.core.*;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

import org.json.JSONException;

public class dummy_array {

	public static void setdata(String name, String package_id) throws JSONException, Exception {
		String places[] = null;
		String hotels[] = null;
		String place=null;
		Hotels attributes = new Hotels();
		try {
			JsonFactory f = new MappingJsonFactory();
			JsonParser jp = f.createParser(
					new File("C:\\Users\\shoaib\\shoaib-works\\StrawberiMasterData-JsonToDB\\Domestic_Packages.txt"));

			JsonToken current;
			for (int i = 1; i <= 1; i++) {
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS STARTED--------------------------------------------------------\n");

				current = jp.nextToken();
				if (current != JsonToken.START_OBJECT) {
					System.out.println("Error: root should be object: quiting.");
					return;
				}

				while (jp.nextToken() != JsonToken.END_OBJECT) {

					String fieldName1 = jp.getCurrentName();
					// move from field name to field value
					current = jp.nextToken();
					;
					if (fieldName1.equals("package_name")) {
						attributes.setItem_name(jp.getText());
						System.out.println("package_name:" + attributes.getItem_name() + "\n");
					}

					String fieldName = jp.getCurrentName();
					// move from field name to field value
					// current = jp.nextToken();;
					if (fieldName.equals("costing")) {
						if (current == JsonToken.START_ARRAY) {
							// For each of the records in the array
							while (jp.nextToken() != JsonToken.END_ARRAY) {
								// read the record into a tree model,
								// this moves the parsing position to the end of it
								JsonNode node = jp.readValueAsTree();
								// And now we have random access to everything in the object
								attributes.setHotel_name(node.get("HTL_NM1").asText());
								System.out.println("hotelname: " + attributes.getHotel_name() + "\n");
								long count = count_hotels.count(attributes.getHotel_name(), ':');
								if (count == 1) {
									System.out.println("No Of Hotels:1\n");
									int length = attributes.getHotel_name().length();
									// System.out.println("length--->"+length+"\n");

									places = string_split.getplaces(attributes.getHotel_name());
									hotels = string_split.gethotels(attributes.getHotel_name());
									int l = 1;
									for (int k = 0; k < hotels.length; k++) {
										//System.out.println("Hotel Name--" + l + " is ---" + hotels[k]);

										String str1 = hotels[k];
										//System.out.println(str1);
										System.out.println("Hotel Name--" + l + " is ---" +str1.trim());

										l++;
									}
									int m = 1;
									for (int k = 0; k < places.length; k++) {
										String str1 = places[k];
										System.out.println("Place Name--" + m + " is ---" +str1.trim());
										m++;
									}
									System.out.println("Hotel Names-------" + Arrays.toString(hotels));
									System.out.println("Place Names-------" + Arrays.toString(places));
									
								} 
								
								
								else if (count > 1) {
									System.out.println("No Of Hotels:" + count + "\n");
									int length = attributes.getHotel_name().length();

									places = string_split.getplaces(attributes.getHotel_name());
									hotels = string_split.gethotels(attributes.getHotel_name());
									
									int l = 1;
									for (int k = 0; k < hotels.length; k++) {
										
										String str1 = hotels[k];
										System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
										l++;
									}
									int m = 1;
									for (int k = 0; k < places.length; k++) {
										
										String str1 = places[k];
										System.out.println("Place Name--" + m + " is ---" +str1.trim());
										m++;
									}
									System.out.println("Hotel Names-------" + Arrays.toString(hotels));
									System.out.println("Place Names-------" + Arrays.toString(places));
								} 
								
								
								else if (count == 0) {
									System.out.println("No Of Hotels:1\n");
									int length = attributes.getHotel_name().length();

									hotels= string_split.gethotelssingle(attributes.getHotel_name());
									
									
									System.out.println("Hotel Names singleee-------" + Arrays.toString(hotels));
									
									 place=HotelDao.getplaceName(package_id);
									
								}

//								String catstr = node.get("CATEGORY").asText();
//								if (catstr.equalsIgnoreCase("5 STAR")) {
//									attributes.setStar_rating("5");
//									attributes.setRoom_category("Premium");
//									attributes.setPrice_category("Premium");
//								} else if (catstr.equalsIgnoreCase("4 STAR")) {
//									attributes.setStar_rating("4");
//									attributes.setRoom_category("Delux");
//									attributes.setPrice_category("Medium");
//								} else if (catstr.equalsIgnoreCase("3 STAR")) {
//									attributes.setStar_rating("3");
//									attributes.setRoom_category("Standard");
//									attributes.setPrice_category("Budget");
//								} else if (catstr.equalsIgnoreCase("SUPERIOR")) {
//									attributes.setStar_rating("5");
//									attributes.setRoom_category("Premium");
//									attributes.setPrice_category("Premium");
//								} else if (catstr.equalsIgnoreCase("DELUXE")) {
//									attributes.setStar_rating("4");
//									attributes.setRoom_category("Delux");
//									attributes.setPrice_category("Medium");
//								} else if (catstr.equalsIgnoreCase("STANDARD")) {
//									attributes.setStar_rating("3");
//									attributes.setRoom_category("Standard");
//									attributes.setPrice_category("Budget");
//								}

//								System.out.println("Star_rating : " + attributes.getStar_rating() + "\n");
//								System.out.println("Room_category : " + attributes.getRoom_category() + "\n");
//								System.out.println("Price_category : " + attributes.getPrice_category() + "\n");

								attributes.setBasis(node.get("BASIS").asText());
								System.out.println("BASIS: " + attributes.getBasis() + "\n");
								
								
								if(count==0 || count==1)
								{
									//count=1;
									int counting=1;
									String sharemode = node.get("HT_TWIN").asText();
									if (sharemode != "-" || sharemode != "NA") {
										attributes.setSharing_mood("Twin");
										System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
										attributes.setVariant_type("Base");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
									}

									String sharemodetr = node.get("HT_TRIPLE").asText();
									if (sharemodetr != "-" || sharemodetr != "NA") {
										attributes.setSharing_mood("Triple");
										System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
										attributes.setVariant_type("Base");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
										
										
									}

									String sharemodesi = node.get("HT_SINGLE").asText();
									if (sharemodesi != "-" || sharemodesi != "NA") {
										attributes.setSharing_mood("Single");
										System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
										attributes.setVariant_type("Base");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
										
									}

									String childwbed = node.get("CH_W_BED").asText();
									if (childwbed != "-" || childwbed != "NA") {
										attributes.setChild("Child With Bed");
										System.out.println("Child: " + attributes.getChild() + "\n");
										attributes.setVariant_type("Add-on");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
										
										
									}

									String childwobed = node.get("CH_WO_BED").asText();
									if (childwobed != "-" || childwobed != "NA") {
										attributes.setChild("Child Without Bed");
										System.out.println("Child: " + attributes.getChild() + "\n");
										attributes.setVariant_type("Add-on");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
										
										
									}

									String extrabed = node.get("HT_EXTRA").asText();
									if (extrabed != "-" || extrabed != "NA") {
										attributes.setChild("Extra Bed");
										System.out.println("Extra Bed: " + attributes.getSharing_mood() + "\n");
										attributes.setVariant_type("Add-on");
										System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
										
										int l = 1;
										for (int k = 0; k < hotels.length; k++) {
											
											String str1 = hotels[k];
											attributes.setHotel_name(str1.trim()+"-001");
											attributes.setHotel_id(str1.trim()+"-001"+"-0"+counting);
											System.out.println("Hotel Name--" + l + " is ---" +str1.trim());
											l++;
											counting++;
											if(count==0)
											{
											attributes.setPlace(place);
											}
											else if(count==1)
											{
												int m = 1;
												for (int k1 = 0; k1 < places.length; k1++) {
													
													String str11 = places[k];
													attributes.setPlace(str11.trim());
													System.out.println("Place Name--" + m + " is ---" +str11.trim());
													m++;
												}
											}
										}
										
										HotelDao.setHotel_data(attributes);
									}
									
								}
								
								for(int c=1;c<=count;c++)
								{
									
								String sharemode = node.get("HT_TWIN").asText();
								if (sharemode != "-" || sharemode != "NA") {
									attributes.setSharing_mood("Twin");
									System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
									attributes.setVariant_type("Base");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
									
									HotelDao.setHotel_data(attributes);
								}

								String sharemodetr = node.get("HT_TRIPLE").asText();
								if (sharemodetr != "-" || sharemodetr != "NA") {
									attributes.setSharing_mood("Triple");
									System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
									attributes.setVariant_type("Base");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
								}

								String sharemodesi = node.get("HT_SINGLE").asText();
								if (sharemodesi != "-" || sharemodesi != "NA") {
									attributes.setSharing_mood("Single");
									System.out.println("sharing_mode: " + attributes.getSharing_mood() + "\n");
									attributes.setVariant_type("Base");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
								}

								String childwbed = node.get("CH_W_BED").asText();
								if (childwbed != "-" || childwbed != "NA") {
									attributes.setChild("Child With Bed");
									System.out.println("Child: " + attributes.getChild() + "\n");
									attributes.setVariant_type("Add-on");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
								}

								String childwobed = node.get("CH_WO_BED").asText();
								if (childwobed != "-" || childwobed != "NA") {
									attributes.setChild("Child Without Bed");
									System.out.println("Child: " + attributes.getChild() + "\n");
									attributes.setVariant_type("Add-on");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
								}

								String extrabed = node.get("HT_EXTRA").asText();
								if (extrabed != "-" || extrabed != "NA") {
									attributes.setChild("Extra Bed");
									System.out.println("Extra Bed: " + attributes.getSharing_mood() + "\n");
									attributes.setVariant_type("Add-on");
									System.out.println("variant_type: " + attributes.getVariant_type() + "\n");
								}
							}
							}
						} else {
							System.out.println("Error: records should be an array: skipping.");
							jp.skipChildren();
						}
					} else {
						// System.out.println("Unprocessed/unused property: " + fieldName);
						jp.skipChildren();
					}
				}
				System.out.println("--------------------------------------------------------PACKAGE " + i
						+ " IS ENDED--------------------------------------------------------\n");
			}
		} catch (IOException ie) {
			ie.printStackTrace();

		}

	}
}