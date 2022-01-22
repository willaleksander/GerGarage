package ie.cct.gergarage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class Model {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int model_id;
	private String model_name; 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id", referencedColumnName = "make_id")
    private Make make;
	
	public int getModel_id() {
		return model_id;
	}
	
	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}
	
	public String getModel_name() {
		return model_name;
	}
	
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public Model(String model_name, Make make) {
		super();
		this.model_name = model_name;
		this.make = make;
	}
	
	public Model() {
		
	}
}
