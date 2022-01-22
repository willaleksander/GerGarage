package ie.cct.gergarage.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date booking_date;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mechanic_id", referencedColumnName = "mechanic_id")
	private Mechanic mechanic;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToMany
	@JoinTable(
	  name = "booking_costs", 
	  joinColumns = @JoinColumn(name = "booking_id"), 
	  inverseJoinColumns = @JoinColumn(name = "service_id"))
	Set<Service> servicesBooked;

	public Booking(Date booking_date, Status status, Mechanic mechanic, Vehicle vehicle) {
		super();
		this.booking_date = booking_date;
		this.status = status;
		this.mechanic = mechanic;
		this.vehicle = vehicle;
	}
	
	public Booking() {}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Set<Service> getServicesBooked() {
		return servicesBooked;
	}

	public void setServicesBooked(Set<Service> servicesBooked) {
		this.servicesBooked = servicesBooked;
	}
	
	
}
