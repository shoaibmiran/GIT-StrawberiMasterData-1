package com.tap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tap.model.Hotels;
import com.tap.model.Product_Bundle;

public class HotelDao {
	
	public static void main(String[] args) {
	
	}
	public static void setHotel_data(Hotels attributes) {
		
	}
	public static String getplaceName(String package_id) {
		Connection conn = null;
		Statement stmt3 = null;
		String var = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitpackages", "root", "tiger");

			stmt3 = conn.createStatement();
			String sql22 = "select distinct place_name from fit_package_catalog_places where package_id='" + package_id + "'";
			ResultSet rs22 = stmt3.executeQuery(sql22);

			while (rs22.next()) {
				var = rs22.getString("place_name");
			}
			rs22.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt3 != null)
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
		return var;
	}

}
