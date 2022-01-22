package ie.cct.gergarage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int service_id;
	private String service_name;
	private double service_cost;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id", referencedColumnName = "part_id")
	private Part part;
	
	@ManyToMany(mappedBy = "servicesBooked")
	Set<Booking> serviced;

	public Service(String service_name, double service_cost, Part part) {
		super();
		this.service_name = service_name;
		this.service_cost = service_cost;
		this.part = part;
	}
	
	public Service() {}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public double getService_cost() {
		return service_cost;
	}

	public void setService_cost(double service_cost) {
		this.service_cost = service_cost;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Set<Booking> getServiced() {
		return serviced;
	}

	public void setServiced(Set<Booking> serviced) {
		this.serviced = serviced;
	}
	
	
}
