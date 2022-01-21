package ie.cct.gergarage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mechanic")
public class Mechanic {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int mechanic_id;
	private String mechanic_name;
	
	public Mechanic(String mechanic_name) {
		super();
		this.mechanic_name = mechanic_name;
	}
	
	public Mechanic() {}

	public int getMechanic_id() {
		return mechanic_id;
	}

	public void setMechanic_id(int mechanic_id) {
		this.mechanic_id = mechanic_id;
	}

	public String getMechanic_name() {
		return mechanic_name;
	}

	public void setMechanic_name(String mechanic_name) {
		this.mechanic_name = mechanic_name;
	}
	
	
}
