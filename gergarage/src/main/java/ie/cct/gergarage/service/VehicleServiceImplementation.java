package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Vehicle;
import ie.cct.gergarage.repository.VehicleRepository;

@Service
public class VehicleServiceImplementation implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public ApiResponse findUserVehicles(int user_id) {
		List<Vehicle> vehicles = vehicleRepository.findVehiclesByUserId(user_id);
		return new ApiResponse(200, "success", vehicles);
	}
	
	@Override
    public ApiResponse create(Vehicle newVehicle) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(newVehicle, vehicle);
        vehicleRepository.save(vehicle);
        return new ApiResponse(200, "success", vehicle);
    }
}
