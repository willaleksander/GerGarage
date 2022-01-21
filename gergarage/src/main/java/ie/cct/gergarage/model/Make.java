package ie.cct.gergarage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "make")
public class Make {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int make_id;
	private String make_name;

	
	public int getMake_id() {
		return make_id;
	}
	
	public void setMake_id(int make_id) {
		this.make_id = make_id;
	}
	
	public String getMake_name() {
		return make_name;
	}
	
	public void setMake_name(String make_name) {
		this.make_name = make_name;
	}

	public Make(String make_name) {
		super();
		this.make_name = make_name;
	}
	
	public Make() {
		
	}
}
