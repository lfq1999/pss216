package com.pss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils216 {
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String DRIVER;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.pss.util.db-config");

	private DBUtils216() {
	}

	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败，请检查URL，USERNAME，PASSWORD,DRIVER是否正确？");
		}
		return conn;

	}

	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != stat) {
				stat.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(DBUtils216.getConnection());
	}

}
