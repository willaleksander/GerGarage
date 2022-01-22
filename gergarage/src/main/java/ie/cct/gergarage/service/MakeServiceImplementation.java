package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Make;
import ie.cct.gergarage.repository.MakeRepository;

@Service
public class MakeServiceImplementation implements MakeService{
	
	@Autowired
    private MakeRepository makeRepository;
	
	@Override
	public ApiResponse listAllMakes() {
		List<Make> makes = makeRepository.findAll();
		return new ApiResponse(200, "success", makes);
	}
}
