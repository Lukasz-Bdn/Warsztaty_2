package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Exercise;

public class ExerciseApp {

	public static void main(String[] args) {
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
				+ "3306/warsztat_2?useSSL=false", "root", "coderslab");
		Exercise exercise = new Exercise("zadanie 6", "Napisz petle while");
//		exercise.saveToDb(conn);
//		System.out.println(exercise.getId() + " | " + exercise.getTitle());
		
		Exercise exercise2 = new Exercise();
		exercise2 = Exercise.loadById(conn, 4);
		System.out.println(exercise2.getId() + " | " + exercise2.getTitle() 
					+ " | " + exercise.getDescription());
		
		exercise2.deleteFromDb(conn);
		
		Exercise[] allExercises = Exercise.loadAll(conn);
		for (Exercise ex : allExercises) {
			System.out.println(ex.getId() + " | " + ex.getTitle() + " | " 
					+ ex.getDescription());
		}
		
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
}
