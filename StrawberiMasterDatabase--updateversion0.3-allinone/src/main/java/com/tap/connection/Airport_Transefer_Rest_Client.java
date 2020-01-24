package com.tap.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import com.tap.model.Airport_Transfer_Item;
import com.tap.model.Airport_transfer_variants;
import com.tap.model.Item2;
import com.tap.model.Item_Defaults;
import com.tap.model.Item_Hasattributes;

public class Airport_Transefer_Rest_Client {
	private static final String REST_URI = "http://betaerp.edawjar.in:8000/api/resource/Item";
	private static final String ITEM_URL ="http://betaerp.edawjar.in:8000/api/resource/Item";
	private static final String PRODUCT_BUNDLE_URL = "http://betaerp.edawjar.in:8000/api/resource/Product Bundle";
	private static final String Hotel_ATTRIBUTES_URL = "http://betaerp.edawjar.in:8000/api/resource/Hotel Attribute";
	private static final String PRODUCT_BUNDLE_ATTRIBUTE_URL = "http://betaerp.edawjar.in:8000/api/resource/Product Bundle Attribute";
	private static final String PACKAGE_PRODUCT_ALTERNATIVES_URL = null;
	private static final String LAND_PACKAGE_ATTRIBUTES_URL = "http://betaerp.edawjar.in:8000/api/resource/Land Package Attributes";
	private static final String PRICE_LIST_URL = "http://betaerp.edawjar.in:8000/api/resource/Price List";
	private static final String SIGHT_SEEING_ATTRIBUTE_URL = null;
	private static final String ITEM_PRICE_LIST_URL = "http://betaerp.edawjar.in:8000/api/resource/Item Price";
	private static final String REST_URI1 = "http://betaerp.edawjar.in:8000/api/method/login?usr=administrator&pwd=Strawberi@123";
	
	private Client client = ClientBuilder.newClient();
	
	public static void setAirportTransfer() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Airport_Transefer_Rest_Client rc=new Airport_Transefer_Rest_Client();
		try {
			conn =DBUtility.getConnection();
			stmt=conn.createStatement();
			String sql="select Transfer_service_id from fit_transfer_service";
			//System.out.println("SQL ------>" +sql);
			
			rs=stmt.executeQuery(sql);
			JSONObject job=null;
			while (rs.next()) {

	        System.out.println("Transfer_service_id  --------> " + rs.getString("Transfer_service_id"));
	        
             Item2 airport_transfer=new Item2();
             
             if(rs.getString("Transfer_service_id") != null) {
               airport_transfer.setItem_code(rs.getString("Transfer_service_id"));
             }else 
             {
               airport_transfer.setItem_code("");
             }
             if(rs.getString("Transfer_service_id") != null) {
                 airport_transfer.setItem_name(rs.getString("Transfer_service_id"));
               }else 
               {
                 airport_transfer.setItem_name("");
               }
             
             airport_transfer.setItem_group("Transport");
             airport_transfer.setStock_uom("Nos");
             airport_transfer.setCategory("Airport Transfer");
             airport_transfer.setDescription("");
             airport_transfer.setPrice_category("Premium");
             airport_transfer.setHas_variants(true);
             airport_transfer.setVariant_based_on("Item Attribute");
             airport_transfer.setInclude_item_in_manufacturing(true);
             airport_transfer.setIs_stock_item(true);
             
             Item_Hasattributes item_hv1=new Item_Hasattributes();
             Item_Hasattributes item_hv2=new Item_Hasattributes();
             Item_Hasattributes item_hv3=new Item_Hasattributes();
             Item_Hasattributes item_hv4=new Item_Hasattributes();
             Item_Hasattributes item_hv5=new Item_Hasattributes();


             item_hv1.setAttribute("Vehicle Type");
             item_hv2.setAttribute("AC Type");
             item_hv3.setAttribute("Transfer Type");
             item_hv4.setAttribute("Group Size");
             item_hv5.setAttribute("Age Group");

             
             airport_transfer.Allattributes(item_hv1);
             airport_transfer.Allattributes(item_hv2);
             airport_transfer.Allattributes(item_hv3);
             airport_transfer.Allattributes(item_hv4);
             airport_transfer.Allattributes(item_hv5);


             Item_Defaults id=new Item_Defaults();
             id.setCompany("Strawberi");
             airport_transfer.Allcompany(id);
             
             job=new JSONObject(airport_transfer);
            
 			System.out.println("Airport Transfer Template----->"+job.toString(1));
 			
 			Response r1 = rc.createAirportTransferTemplate(airport_transfer);
			System.out.println("Status---" + r1.getStatus());
			System.out.println("Status Info---" + r1.getStatusInfo());
			System.out.println("Status Info---" + r1.getStringHeaders());
			System.out.println(r1.readEntity(String.class));
 			System.out.println();

			}
			
			DBUtility.closeResultSet(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtility.closeStatement(stmt);
			DBUtility.closeConnection(conn);
		}
		
		
	}
	
	public Response createAirportTransferTemplate(Item2 air_temp) {
		JSONObject obj = new JSONObject(air_temp);
			System.out.println("Airport transfer template to push into erpnext------> " + obj.toString());
			//System.exit(1);
		try {

			return client.target(ITEM_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(air_temp, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}
	
	public Response createAirportTransferVariants(Item2 air_temp) {
		JSONObject obj = new JSONObject(air_temp);
			System.out.println("Airport transfer variants to push into erpnext------> " + obj.toString());
			//System.exit(1);
		
		try {

			return client.target(ITEM_URL).request(MediaType.APPLICATION_JSON)
					.header("Authorization", "token a7d14051ef3941b:a738356d197551d")
					.post(Entity.entity(air_temp, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return null;

	}
	public static void setAirportTransferVariants() {
	
		Airport_Transefer_Rest_Client rc=new Airport_Transefer_Rest_Client();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn =DBUtility.getConnection();
			stmt=conn.createStatement();
			String sql="select * from fit_transfer_service";
			//System.out.println("SQL ------>" +sql);
			
			rs=stmt.executeQuery(sql);
			JSONObject job=null;
			while(rs.next()) {
             
	         System.out.println("Transfer_service_name  --------> " + rs.getString("Transfer_service_name"));
             System.out.println("no                     --------> " + rs.getString("no"));
             System.out.println("package_id_list        --------> " + rs.getString("package_id_list"));
             System.out.println("place                  --------> " + rs.getString("place"));
             System.out.println("Transfer_service_id    --------> " + rs.getString("Transfer_service_id"));
             System.out.println("description            --------> " + rs.getString("description"));
             System.out.println("variant_name           --------> " + rs.getString("variant_name"));
             System.out.println("price_category         --------> " + rs.getString("price_category"));
             System.out.println("transfer_type          --------> " + rs.getString("transfer_type"));
             System.out.println("vehicle_type           --------> " + rs.getString("vehicle_type"));
             System.out.println("group_size             --------> " + rs.getString("group_size"));
             System.out.println("supplier_1             --------> " + rs.getString("supplier_1"));
             System.out.println("country_1              --------> " + rs.getString("country_1"));
             System.out.println("currency_1             --------> " + rs.getString("currency_1"));
             System.out.println("validity_start_date_1  --------> " + rs.getString("validity_start_date_1"));
             System.out.println("validity_end_date_1    --------> " + rs.getString("validity_end_date_1"));
             System.out.println("season_1               --------> " + rs.getString("season_1"));
             System.out.println("price_1                --------> " + rs.getString("price_1"));
             System.out.println("supplier_2             --------> " + rs.getString("supplier_2"));
             System.out.println("country_2              --------> " + rs.getString("country_2"));
             System.out.println("currency_2             --------> " + rs.getString("currency_2"));
             System.out.println("validity_start_date_2  --------> " + rs.getString("validity_start_date_2"));
             System.out.println("validity_end_date_2    --------> " + rs.getString("validity_end_date_2"));
             System.out.println("season_2               --------> " + rs.getString("season_2"));
             System.out.println("price_2                --------> " + rs.getString("price_2"));
             System.out.println("supplier_3             --------> " + rs.getString("supplier_3"));
             System.out.println("country_3              --------> " + rs.getString("country_3"));
             System.out.println("currency_3             --------> " + rs.getString("currency_3"));
             System.out.println("validity_start_date_3  --------> " + rs.getString("validity_start_date_3"));
             System.out.println("validity_end_date_3    --------> " + rs.getString("validity_end_date_3"));
             System.out.println("season_3               --------> " + rs.getString("season_3"));
             System.out.println("price_3                --------> " + rs.getString("price_3"));
	        
	        
             Item2 airport_transfer=new Item2();
//             if(rs.getString("variant_name").equalsIgnoreCase("") || rs.getString("variant_name").equalsIgnoreCase("NA"))
//             {
//            	 airport_transfer.setItem_code(rs.getString("Transfer_service_id"));
//                 airport_transfer.setItem_name(rs.getString("Transfer_service_id"));
//             }
//             
//             else if(rs.getString("variant_name")!="" || rs.getString("variant_name")!="NA")
//             {
             airport_transfer.setItem_code(rs.getString("Transfer_service_id")+"-"+rs.getString("variant_name"));
             airport_transfer.setItem_name(rs.getString("Transfer_service_id")+"-"+rs.getString("variant_name"));
             
             airport_transfer.setItem_group("Transport");
             airport_transfer.setStock_uom("Nos");
             airport_transfer.setCategory("Airport Transfer");
             airport_transfer.setPrice_category("Premium");
             airport_transfer.setIs_default(false);
             airport_transfer.setHas_variants(false);
             airport_transfer.setVariant_based_on("Item Attribute");
             airport_transfer.setVariant_of(rs.getString("Transfer_service_id"));
             
             Item_Hasattributes item_hv3=new Item_Hasattributes();
             item_hv3.setVariant_of(rs.getString("Transfer_service_id"));
             item_hv3.setAttribute("Transfer Type");
             item_hv3.setAttribute_value(rs.getString("transfer_type"));
             
             
             airport_transfer.Allattributes(item_hv3);

           
             Item_Defaults id=new Item_Defaults();
             id.setCompany("Strawberi");
             airport_transfer.Allcompany(id);
             
             job=new JSONObject(airport_transfer);
            
  			System.out.println("Airport Transfer Variants----->"+job.toString(1));
 			
  			Response r1 = rc.createAirportTransferVariants(airport_transfer);
 			System.out.println("Status---" + r1.getStatus());
 			System.out.println("Status Info---" + r1.getStatusInfo());
 			System.out.println("Status Info---" + r1.getStringHeaders());
 			System.out.println(r1.readEntity(String.class));
  			System.out.println();

			}
			
			DBUtility.closeResultSet(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtility.closeStatement(stmt);
			DBUtility.closeConnection(conn);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		//setAirportTransfer();
		setAirportTransferVariants();
		
	}

}
