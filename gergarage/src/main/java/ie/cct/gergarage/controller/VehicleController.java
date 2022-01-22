package ie.cct.gergarage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.service.VehicleService;

@RestController
@CrossOrigin(origins = "*")
public class VehicleController {
	 @Autowired
	 private VehicleService vehicleService;
	 
	 @GetMapping("/get-user-vehicles")
     public ApiResponse listUsers(@RequestParam("userId")int userId){
		 return vehicleService.findUserVehicles(userId);
     }
}
