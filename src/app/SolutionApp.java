package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Solution;

public class SolutionApp {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
					+ "3306/warsztat_2?useSSL=false", "root", "coderslab");
			Solution solution = new Solution("test 7", 8, 7);
			solution.saveToDb(conn);
			System.out.println(solution.getId() + " | " + solution.getCreated() 
			+ " | " + solution.getUpdated() + " | " + solution.getDescription()
			+ " | " + solution.getExercise_id() + " | " + solution.getUsers_id());
			
			Solution solution2 = Solution.loadById(conn, 7);
			System.out.println(solution2.getId() + " | " + solution2.getCreated() 
			+ " | " + solution2.getUpdated() + " | " + solution2.getDescription()
			+ " | " + solution2.getExercise_id() + " | " + solution2.getUsers_id());
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}