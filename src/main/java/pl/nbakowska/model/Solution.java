package pl.nbakowska.model;

import java.sql.Timestamp;

public class Solution {

	private int id;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private int exerciseId;
	private int userId;
	
	public Solution() {}
	
	public Solution(String created,String updated, String description, int exercise_id, int users_id ) {
		
		Timestamp myDate = Timestamp.valueOf(created);
    	this.created = myDate;
    	
    	Timestamp myDate2 = Timestamp.valueOf(updated);
		this.updated = myDate2;
		this.description = description;
		this.exerciseId = exercise_id;
		this.userId = users_id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

