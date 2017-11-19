package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGroup {
	private int id;
	private String name;
	
	public UserGroup() {
		super();
		this.id = 0;
		this.name = "";
	}
	
	public UserGroup(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void saveToDb(Connection conn) throws SQLException {
		String sql = "INSERT INTO user_group(name) VALUES(?);";
		String[] generatedKeys = {"ID"};
		PreparedStatement ps = conn.prepareStatement(sql, generatedKeys);
		ps.setString(1, this.name);
		ps.executeUpdate();
		ResultSet gk = ps.getGeneratedKeys();
		if (gk.next()) {
			this.id = gk.getInt(1);
		}
		gk.close();
		ps.close();
	}
}