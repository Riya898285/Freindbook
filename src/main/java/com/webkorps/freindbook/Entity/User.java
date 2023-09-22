package com.webkorps.freindbook.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String email;
	private String password;
	private String username;
	
	@Column(name = "profile_pic")
	private String profilePic="default.jpg";

	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	private String favbook;
	private String favSong;
	private String favPlace;
	

	
	public String getFavbook() {
		return favbook;
	}
	public void setFavbook(String favbook) {
		this.favbook = favbook;
	}
	public String getFavSong() {
		return favSong;
	}
	public void setFavSong(String favSong) {
		this.favSong = favSong;
	}
	public String getFavPlace() {
		return favPlace;
	}
	public void setFavPlace(String favPlace) {
		this.favPlace = favPlace;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.username = username;
		this.favPlace="place";
		this.favSong="Song";
		this.favbook="book";
	}
	@Override
	public String toString() {
		return "User [user_id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", username=" + username + "]";
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	

}
