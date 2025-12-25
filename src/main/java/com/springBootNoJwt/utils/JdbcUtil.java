package com.springBootNoJwt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static String jdbcUrl = "jdbc:mysql://localhost:3306/real_estate?useSSL=false&serverTimezone=UTC";
	public static String jdbcUser = "root";
	public static String jdbcPassword = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
}
