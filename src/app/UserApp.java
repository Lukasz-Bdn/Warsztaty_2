package app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.User;

public class UserApp {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/warsztat_2?useSSL=false", "root", "coderslab");
			User u = new User("Lukasz", "lukasz@mail.com", "rafal");
			u.setUser_group_id(1); // normalnie bedzie obiekt user_group i z niego
			u.save(conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}