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
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicle_id;
	private String vehicle_comment;
	private String vehicle_licence;
	private Engine_Type vehicle_type;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
	private Model model;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_service_id", referencedColumnName = "booking_service_id")
	private BookingService booking_service;

	public Vehicle(String vehicle_comment, String vehicle_licence, Engine_Type vehicle_type, User user, Model model,
			BookingService booking_service) {
		super();
		this.vehicle_comment = vehicle_comment;
		this.vehicle_licence = vehicle_licence;
		this.vehicle_type = vehicle_type;
		this.user = user;
		this.model = model;
		this.booking_service = booking_service;
	}
	
	public Vehicle() {}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_comment() {
		return vehicle_comment;
	}

	public void setVehicle_comment(String vehicle_comment) {
		this.vehicle_comment = vehicle_comment;
	}

	public String getVehicle_licence() {
		return vehicle_licence;
	}

	public void setVehicle_licence(String vehicle_licence) {
		this.vehicle_licence = vehicle_licence;
	}

	public Engine_Type getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(Engine_Type vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public BookingService getBooking_service() {
		return booking_service;
	}

	public void setBooking_service(BookingService booking_service) {
		this.booking_service = booking_service;
	}
	
	
}
