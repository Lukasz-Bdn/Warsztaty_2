package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise {
	private int id;
	private String title;
	private String description;
	
	public Exercise() {
		super();
		this.id=0;
	}
	
	public Exercise(String title, String description) {
		super();
		this.id = 0;
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public void saveToDb(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO exercise(title, description) " + "VALUES(?, ?);";
			String[] generatedKeys = { "id" };
			PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
			ps.setString(1, this.title);
			ps.setString(2, this.description);
			ps.executeUpdate();
			ResultSet gk = ps.getGeneratedKeys();
			if (gk.next()) {
				this.id = gk.getInt(1);
			}
			gk.close();
			ps.close();
		} else {
			String sql = "UPDATE exercise SET title=?, description=? WHERE id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.title);
			ps.setString(2, this.description);
			ps.setInt(3, this.id);
			ps.executeUpdate();
			ps.close();
		}
		
	}
	
}