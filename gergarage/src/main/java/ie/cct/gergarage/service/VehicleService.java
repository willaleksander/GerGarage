package ie.cct.gergarage.service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Vehicle;

public interface VehicleService {
	
	ApiResponse create(Vehicle vehicle);
	
	ApiResponse findUserVehicles(int user_id);
}
