package ie.cct.gergarage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	@Column(name="user_username", unique=true)
	private String username;
	private String user_phone;

	private String user_password;
	
	@Enumerated(EnumType.STRING)
	private User_Type user_type;
	
	public User() {}

	public User(String user_name, String username, String user_password, String user_phone, User_Type user_type) {
		super();
		this.user_name = user_name;
		this.username = username;
		this.user_password = user_password;
		this.user_phone = user_phone;
		this.user_type = user_type;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public User_Type getUser_type() {
		return user_type;
	}

	public void setUser_type(User_Type user_type) {
		this.user_type = user_type;
	}
	
	
}
