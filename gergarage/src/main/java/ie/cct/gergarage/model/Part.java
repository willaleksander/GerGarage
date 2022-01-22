package ie.cct.gergarage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part")
public class Part {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int part_id;
	private String part_name;
	private double part_price;
	
	public Part(String part_name, double part_price) {
		super();
		this.part_name = part_name;
		this.part_price = part_price;
	}
	
	public Part() {}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public double getPart_price() {
		return part_price;
	}

	public void setPart_price(double part_price) {
		this.part_price = part_price;
	}
	
	
}
