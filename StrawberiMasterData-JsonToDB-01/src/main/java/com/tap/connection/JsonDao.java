package com.tap.connection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.json.JSONException;

import com.tap.model.Hotels;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class JsonDao {

	public static void main(String[] args) throws Exception {

		getPackage_name();

	}

	private static void getPackage_name() throws Exception {
		FileReader reader = new FileReader("db2.properties");

		Properties p = new Properties();
		p.load(reader);

		String package_name = p.getProperty("package_name");

		StringTokenizer tokenizer = new StringTokenizer(package_name, ",");

		while (tokenizer.hasMoreTokens()) {
			// System.out.println(tokenizer.nextToken());
			String name = tokenizer.nextToken();
			System.out.println(name);
			getPackage_id(name);

		}

	}

	private static void getPackage_id(String name) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitpackagesjson", "root", "tiger");

			stmt = conn.createStatement();
			String sql = "SELECT item_code from fit_package_catalog_basic where item_name='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String package_id = rs.getString("item_code");
				System.out.println(package_id+"\n");
				dummy_array.setdata(name, package_id);
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

	}

}
