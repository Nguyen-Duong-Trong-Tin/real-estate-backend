package com.springBootNoJwt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcUtil {
	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Value("${spring.datasource.username}")
	private String jdbcUser;
	
	@Value("${spring.datasource.password}")
	private String jdbcPassword;

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
}
