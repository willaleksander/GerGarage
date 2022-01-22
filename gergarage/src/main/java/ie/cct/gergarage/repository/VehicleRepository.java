package ie.cct.gergarage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ie.cct.gergarage.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
	
	@Query(value = "SELECT * FROM vehicle v WHERE v.user_id = :userId", nativeQuery = true)
	List<Vehicle> findVehiclesByUserId(@Param("userId") int userId);
}
