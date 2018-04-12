package com.sopra.data;
public class UserData {
    private String id;
    private String email;
    private String username;
    private String bio;
    private String image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public UserData(String id, String email, String username, String bio, String image) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.bio = bio;
		this.image = image;
	}
	public UserData() {
		super();
	}
    
}