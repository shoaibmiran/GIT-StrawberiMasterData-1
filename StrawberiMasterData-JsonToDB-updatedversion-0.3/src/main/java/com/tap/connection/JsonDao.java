package com.tap.connection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

public class JsonDao {

	public static void main(String[] args) throws Exception {
		getPackage_name();

	}

	private static void getPackage_name() throws Exception {
		FileReader reader = new FileReader("db2.properties");

		Properties p = new Properties();
		p.load(reader);

		String package_name = p.getProperty("package_name");
		package_name=package_name.toUpperCase();
		
		dummy_array.setdata(package_name);

	}

}
