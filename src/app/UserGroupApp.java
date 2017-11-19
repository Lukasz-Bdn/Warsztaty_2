package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.UserGroup;

public class UserGroupApp {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
					+ "3306/warsztat_2?useSSL=false", "root", "coderslab");
			UserGroup ug5 = new UserGroup("grupa6");
//			ug5.saveToDb(conn);
			
			UserGroup ug = new UserGroup();
			ug = UserGroup.loadById(conn, 5);
			System.out.println(ug.getId() + " | " + ug.getName());
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}