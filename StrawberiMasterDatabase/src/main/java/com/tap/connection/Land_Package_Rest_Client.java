package com.tap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.tap.model.Item2;
import com.tap.model.Item_Defaults;
import com.tap.model.Land_Package_Attributes;
import com.tap.model.Package_Attribute_Places;
import com.tap.model.Package_Attribute_Special_Event;
import com.tap.model.Product_Bundle;
import com.tap.model.Product_Bundle_Attribute;

public class Land_Package_Rest_Client {

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
	
	
	
	public Response createProduct_bundle_attribute(Product_Bundle_Attribute bundle_attribute) {
		System.out.println("Hi hellowwwwwwww----------->"+bundle_attribute);
		JSONObject obj = new JSONObject(bundle_attribute);
		System.out.println("Package_Product_att---" + obj.toString());
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
	  // System.exit(1);
		try {

			return client.target(LAND_PACKAGE_ATTRIBUTES_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(package_attribute, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}
	private static void GetCalender() {
      
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try {
        	conn = DBUtility.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fit_package_catalog_calender";
            rs  = stmt.executeQuery(sql);
            int i = 1;
            System.out.println("/**************************  Calender Start Here.  *******************************/");

            while (rs.next()) {
                
                
                System.out.println("package_id   -----> "+rs.getString("package_id"));
                System.out.println("place_name   -----> "+rs.getString("place_name"));
                System.out.println("start_date   -----> "+rs.getString("start_date"));
                System.out.println("end_date     -----> "+rs.getString("end_date"));
                System.out.println("type         -----> "+rs.getString("type"));
                System.out.println("description  -----> "+rs.getString("description"));
                System.out.println("status       -----> "+rs.getString("status"));
                System.out.println("");

               
            }

            DBUtility.closeResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeStatement(stmt);
            DBUtility.closeConnection(conn);
        }

    }
	
	private static void GetPlaces() {
	      
        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 =null;
        try {
        	conn1 = DBUtility.getConnection();
            stmt1 = conn1.createStatement();

            String sql = "select * from fit_package_catalog_places";
            rs1  = stmt1.executeQuery(sql);
            int i = 1;
            System.out.println("/**************************  Places Start Here  *******************************/");

            while (rs1.next()) {
                
                System.out.println("package_id          -----> "+rs1.getString("package_id"));
                System.out.println("place_name          -----> "+rs1.getString("place_name"));
                System.out.println("number_of_days      -----> "+rs1.getString("number_of_days"));
                System.out.println("number_of_nights    -----> "+rs1.getString("number_of_nights"));
                System.out.println("latitude            -----> "+rs1.getString("latitude"));
                System.out.println("longitude           -----> "+rs1.getString("longitude"));
                System.out.println("zipcode             -----> "+rs1.getString("zipcode"));
                System.out.println("");

               
            }

           DBUtility.closeResultSet(rs1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          DBUtility.closeStatement(stmt1);
          DBUtility.closeConnection(conn1);;

        }

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
	
	private static void setLandPackageAttributes() {
		Land_Package_Rest_Client rc = new Land_Package_Rest_Client();
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs =null;

	        try {
	        	conn = DBUtility.getConnection();
	            stmt = conn.createStatement();
    	        //Land_Package_Attributes landpkgatt=new Land_Package_Attributes();
            	JSONObject job=null;

	            String sql = "select * from fit_package_catalog_basic";
	            System.out.println("fit_package_catalog_basic----->"+sql);
	            rs  = stmt.executeQuery(sql);
	            int i = 1;

	            while (rs.next()) {
	    	        Land_Package_Attributes landpkgatt=new Land_Package_Attributes();

	    	        landpkgatt.setItem(rs.getString("item_code"));
	                System.out.println("item_code : " +landpkgatt.getItem() );
	                //System.out.println("item_name : " + rs.getString("item_name"));
	                
	            	  landpkgatt.setNumber_of_days(rs.getString("number_of_days"));
	                  System.out.println("Number Of Days : " + landpkgatt.getNumber_of_days() );
	                  
	            	  landpkgatt.setNumber_of_nights(rs.getString("number_of_nights"));
	                  System.out.println("Number Of Nights : " + landpkgatt.getNumber_of_nights());
	                  
	                  landpkgatt.setValidity_from(rs.getString("validity_from"));
	                  System.out.println("Validity From : " + landpkgatt.getValidity_from());
	                  
	                  landpkgatt.setValidity_up_to(rs.getString("validity_to"));
	                  System.out.println("Validity To : " + landpkgatt.getValidity_up_to());
	                  
	                  landpkgatt.setMinimum_price(rs.getString("minimum_price"));
	                  System.out.println("Minimum  Price : " + landpkgatt.getMinimum_price());
	                  
	                  landpkgatt.setMaximum_price(rs.getString("maximum_price"));
	                  System.out.println("Maximum  Price : " + landpkgatt.getMaximum_price());
	                  

	                  landpkgatt.setSeason(rs.getString("season"));
	                  System.out.println("Season : " + landpkgatt.getSeason());
	                  	           
	                  landpkgatt.setContinent(rs.getString("continent"));
	                  System.out.println("Continent : " + landpkgatt.getContinent());
	                  
	                  landpkgatt.setCountry(rs.getString("country"));
	                  System.out.println("Country : " + landpkgatt.getCountry());
	                  
	                  landpkgatt.setState(rs.getString("state"));
	                  System.out.println("State : " + landpkgatt.getState());
	                  
	                 
	                  landpkgatt.setTheme(rs.getString("theme"));
	                  System.out.println("Theme : " + landpkgatt.getTheme());
	                  
	                  
	                  landpkgatt.setTags(rs.getString("tags"));
	                  System.out.println("Tags : " + landpkgatt.getTags()); 
	                  System.out.println("");
	                  
	        	        /****************** Places Start ************************/

	        		    Connection conn1 = null;
	        	        Statement stmt1 = null;
	        	        ResultSet rs1 =null;

	        	        try {
	        	        	conn1 = DBUtility.getConnection();
	        	            stmt1 = conn1.createStatement();

	        	            String sql1 = "select * from fit_package_catalog_places where package_id='"+rs.getString("item_code")+"'";
	        	            System.out.println("fit_package_catalog_places Query----> "+sql1);
	        	            rs1  = stmt1.executeQuery(sql1);
	        	            System.out.println();

	        	            while (rs1.next()) {
	    	                	Package_Attribute_Places pap=new Package_Attribute_Places();
	        	                System.out.println("package_id          -----> "+rs1.getString("package_id"));
	        	                System.out.println("place_name          -----> "+rs1.getString("place_name"));
	        	                System.out.println("number_of_days      -----> "+rs1.getString("number_of_days"));
	        	                System.out.println("number_of_nights    -----> "+rs1.getString("number_of_nights"));
	        	                System.out.println("latitude            -----> "+rs1.getString("latitude"));
	        	                System.out.println("longitude           -----> "+rs1.getString("longitude"));
	        	                System.out.println("zipcode             -----> "+rs1.getString("zipcode"));
	        	                System.out.println("");
	        	                pap.setPlace(rs1.getString("place_name"));
	                            pap.setNumber_of_days(rs1.getString("number_of_days"));
	                            pap.setNumber_of_nights(rs1.getString("number_of_nights"));
	                            landpkgatt.AllPalces(pap);
	        	            }
	          	          DBUtility.closeResultSet(rs1);
	          	        } catch (Exception e) {
	          	            e.printStackTrace();
	          	        } finally {
	          	          DBUtility.closeStatement(stmt1);
	          	          DBUtility.closeConnection(conn1);

	          	        }
	        	        /****************** Places End ************************/

	        	        
	        	        /****************** Calender ************************/
	        	        
                        Connection conn11 = null;
            	        Statement stmt11 = null;
            	        ResultSet rs11 =null;
            	        try {
            	        	conn11 = DBUtility.getConnection();
            	            stmt11 = conn11.createStatement();

            	            String sql11 = "select * from fit_package_catalog_calender where package_id='"+rs.getString("item_code")+"'";
            	            System.out.println("fit_package_catalog_calender Query----> "+sql11);
            	            rs11  = stmt11.executeQuery(sql11);
            	            System.out.println();

            	            if (rs11.next() == false) {
            	                System.out.println("ResultSet in empty in Java");
                                job=new JSONObject(landpkgatt);

            	              } else {

            	                do {
    	                            Package_Attribute_Special_Event pase =new Package_Attribute_Special_Event();

            	                	    System.out.println("package_id   -----> "+rs11.getString("package_id"));
	                	                System.out.println("place_name   -----> "+rs11.getString("place_name"));
	                	                System.out.println("start_date   -----> "+rs11.getString("start_date"));
	                	                System.out.println("end_date     -----> "+rs11.getString("end_date"));
	                	                System.out.println("type         -----> "+rs11.getString("type"));
	                	                System.out.println("description  -----> "+rs11.getString("description"));
	                	                System.out.println("status       -----> "+rs11.getString("status"));
	                	                pase.setPlace_name(rs11.getString("place_name"));
                	                    pase.setStart_date(rs11.getString("start_date"));
                	                    pase.setEnd_date(rs11.getString("end_date"));
                	                    pase.setType(rs11.getString("type"));
                	                    pase.setStatus(rs11.getString("status"));
                	                    landpkgatt.AllEvents(pase);
                                        job=new JSONObject(landpkgatt);
	                                    System.out.println("");
	                	               
            	                } while (rs11.next());
            	              }
            	          DBUtility.closeResultSet(rs11);
            	        } catch (Exception e) {
            	            e.printStackTrace();
            	        } finally {
            	          DBUtility.closeStatement(stmt11);
            	          DBUtility.closeConnection(conn11);

            	        }
	        	        
	        	        /****************** Calender ************************/
            	        
        	            System.out.println("Final result of All------------>"+job);
        	            Response r = rc.createLand_package_attributes(landpkgatt);
            			System.out.println("Status---" + r.getStatus());
            			System.out.println("Status Info---" + r.getStatusInfo());
            			System.out.println("Status Info---" + r.getStringHeaders());
            			System.out.println(r.readEntity(String.class));
            			System.out.println("\n");
                        

	            }
    
	          DBUtility.closeResultSet(rs);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	          DBUtility.closeStatement(stmt);
	          DBUtility.closeConnection(conn);

	        }

	}
	
	@SuppressWarnings("null")
	private static void setProductBundleAttributes() {
		Land_Package_Rest_Client rc = new Land_Package_Rest_Client();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        Product_Bundle_Attribute pba = new Product_Bundle_Attribute();
        
        try {
        	conn = DBUtility.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fit_package_catalog_basic";
            rs  = stmt.executeQuery(sql);
            int i = 1;
            System.out.println("/**************************  setProductBundleAttributes Start Here.  *******************************/");

            while (rs.next()) {
                
            	
            	
               // System.out.println("item_code : " + rs.getString("item_code"));

                // System.out.println("item_name : " + rs.getString("item_name"));
                 pba.setProduct_bundle(rs.getString("item_code")+" PACKAGE");
                 System.out.println("Pacakege  ----------"+pba.getProduct_bundle());

                 pba.setCurrency(rs.getString("currency"));
                 System.out.println("currency : " + pba.getCurrency());
            	
                 pba.setMinimum_price(rs.getString("minimum_price"));
                 System.out.println("Minimum  Price : " + pba.getMinimum_price());
                 
                 pba.setMaximum_price(rs.getString("maximum_price"));
                 System.out.println("Maximum  Price : " + pba.getMaximum_price());

                 pba.setSeason(rs.getString("season"));
                 System.out.println("Season : " + pba.getSeason());
                 
                 pba.setContinent(rs.getString("continent"));
                 System.out.println("Continent : " + pba.getContinent());
                 
                 pba.setCountry(rs.getString("country"));
                 System.out.println("Country : " + pba.getCountry());
                 
                 pba.setState(rs.getString("state"));
                 System.out.println("State : " + pba.getState());
                 
                
                 pba.setTheme(rs.getString("theme"));
                 System.out.println("Theme : " + pba.getTheme());
                 
                 pba.setTags(rs.getString("tags"));
                 System.out.println("Tags : " + pba.getTags()); 
                 
                 pba.setTour_type(rs.getString("tour_type"));
                 System.out.println("tour_type : " + pba.getTour_type()); 
                 
                 
                 pba.setTour_category(rs.getString("tour_category"));
                 System.out.println("tour_category : " + pba.getTour_category());    
                 
                 pba.setStar_rating_(rs.getString("Star_rating"));
                 System.out.println("Star_rating : " + pba.getStar_rating_()); 
                 
                 
                 pba.setDestination(rs.getString("description"));
                 System.out.println("description : " + pba.getDestination()); 
                 
                 
             	JSONObject job=new JSONObject(pba);
         		System.out.println("jsob--> "+job);
         		
         		Response r = rc.createProduct_bundle_attribute(pba);
    			System.out.println("Status---" + r.getStatus());
    			System.out.println("Status Info---" + r.getStatusInfo());
    			System.out.println("Status Info---" + r.getStringHeaders());
    			System.out.println(r.readEntity(String.class));
    			System.out.println("\n");
                

            }

     
            DBUtility.closeResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeStatement(stmt);
            DBUtility.closeConnection(conn);
        }

    }
	public static void main(String[] args) {
		//GetCalender();
		//GetPlaces();
		setProductBundleAttributes();
		setLandPackageAttributes();
		
		
	}
}
