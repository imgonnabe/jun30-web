package com.poseidon.db;

import java.sql.Connection;
import java.sql.DriverManager;

// 데이터베이스 접속 정보를 저장한다.
public class DBConnection {
	private static DBConnection dbConnection;
	
	private DBConnection() {}
	
	public synchronized static DBConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public Connection getConn() {
		Connection conn = null;
		final String url = "jdbc:mariadb://localhost:3306/choongang";
		final String id = "qorlwn";
		final String pw = "123456789";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
