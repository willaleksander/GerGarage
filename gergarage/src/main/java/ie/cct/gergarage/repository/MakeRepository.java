package ie.cct.gergarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.cct.gergarage.model.Make;

public interface MakeRepository extends JpaRepository<Make, Integer> {
	
}
