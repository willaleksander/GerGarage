package ie.cct.gergarage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_service")
public class BookingService {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_service_id")
	private int booking_service_id;
	private String booking_service_type;
	private double booking_service_cost;
	
	public int getBooking_service_id() {
		return booking_service_id;
	}
	
	public void setBooking_service_id(int booking_id) {
		this.booking_service_id = booking_id;
	}
	
	public String getBooking_service_type() {
		return booking_service_type;
	}
	
	public void setBooking_service_type(String booking_service_type) {
		this.booking_service_type = booking_service_type;
	}
	
	public double getBooking_service_cost() {
		return booking_service_cost;
	}
	
	public void setBooking_service_cost(double booking_service_cost) {
		this.booking_service_cost = booking_service_cost;
	}
	
	public BookingService(String booking_service_type, double booking_service_cost) {
		super();
		this.booking_service_type = booking_service_type;
		this.booking_service_cost = booking_service_cost;
	}
	
	public BookingService() {}
}
