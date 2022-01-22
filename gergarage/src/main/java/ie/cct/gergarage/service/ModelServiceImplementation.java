package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Model;
import ie.cct.gergarage.repository.ModelRepository;

@Service
public class ModelServiceImplementation implements ModelService{
	
	@Autowired
    private ModelRepository modelRepository;
	
	@Override
	public ApiResponse listAllModels() {
		List<Model> models = modelRepository.findAll();
		return new ApiResponse(200, "success", models);
	}

	@Override
	public ApiResponse listModelsByMake(int make_id) {
		List<Model> models = modelRepository.findModelsByMakeId(make_id);
		return new ApiResponse(200, "success", models);
	}

}
