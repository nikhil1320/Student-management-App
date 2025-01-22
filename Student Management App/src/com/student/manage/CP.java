package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;

	public static Connection creatC() {

		try {
			String url = "jdbc:mysql://localhost:3306/demo";
			String user = "root";
			String password = "root";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

}
