package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.BookingService;
import ie.cct.gergarage.repository.BookingServiceRepository;

public class BookingServiceServiceImplementation implements BookingServiceService {
	
	@Autowired
    private BookingServiceRepository bookingServiceServiceRepository;
	
	@Override
	public ApiResponse listAllBookingServices() {
		List<BookingService> bookingServices = bookingServiceServiceRepository.findAll();
		return new ApiResponse(200, "success", bookingServices);
	}

}
