package model;

import java.sql.Connection;

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
	
	public void saveToDb(Connection conn) {
		
	}
	
}