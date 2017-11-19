package app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.User;

public class UserApp {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
					+ "3306/warsztat_2?useSSL=false", "root", "coderslab");
			User u = new User("Tomek", "tomek112@mail.com", "tomek");
			u.setUser_group_id(2); // normalnie bedzie obiekt user_group i z niego
//			u.saveToDb(conn);
			
			User u2 = User.loadUserById(conn, 3);
			try {
				System.out.println(u2.getId() + " | " + u2.getUsername() + " | " 
									+ u2.getEmail());
			} catch (NullPointerException e) {
				System.out.println("Zwrocono null");;
			}
			u2.setEmail("inny_janusz@janusze.pl");
//			u2.saveToDb(conn);
			User[] users = User.loadAll(conn);
			for (User user : users) {
				System.out.println(user.getUsername());
			}
//			u2.deleteFromDb(conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}