package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Solution {
	private int id;
	private String created;
	private String updated;
	private String description;
	private int exercise_id;
	private int users_id;
	
	public Solution() {
		super();
		this.id = 0;
		this.created = "";
		this.updated = "";
		this.description = "";
		this.exercise_id = 0;
		this.users_id = 0;
	}
	
	public Solution(String description, int exercise_id, int users_id) {
		super();
		this.id = 0;
		this.created = "";
		this.updated = "";
		this.description = description;
		this.exercise_id = exercise_id;
		this.users_id = users_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public String getUpdated() {
		return updated;
	}
	
	public void saveToDb(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO " + "solution(created, updated, description, "
					+ "exercise_id, users_id) "
					+ "VALUES(NOW(), NOW(), ?, ?, ?);";
			String[] generatedKeys = { "id"};
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, this.description);
			ps.setInt(2, this.exercise_id);
			ps.setInt(3, this.users_id);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
			Solution tempSolution = Solution.loadById(conn, this.id);
			this.created = tempSolution.created;
			this.updated = tempSolution.updated;

			rs.close();
			ps.close();
		}
	}
	public static Solution loadById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM solution WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Solution solution = new Solution();
			solution.id = rs.getInt(1);
			solution.created = rs.getString(2);
			solution.updated = rs.getString(3);
			solution.description = rs.getString(4);
			solution.exercise_id = rs.getInt(5);
			solution.users_id = rs.getInt(6);
			rs.close();
			ps.close();
			return solution;
		}
		return null;		
	}
	
}
