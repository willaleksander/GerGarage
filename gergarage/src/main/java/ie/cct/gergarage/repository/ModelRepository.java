package ie.cct.gergarage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.cct.gergarage.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	
	@Query(value = "SELECT * FROM model m WHERE m.make_id = :makeId", nativeQuery = true)
	List<Model> findModelsByMakeId(@Param("makeId") int makeId);
}
