package ie.cct.gergarage.service;

import ie.cct.gergarage.model.ApiResponse;

public interface ModelService {
	
	ApiResponse listAllModels();
	
	ApiResponse listModelsByMake(int make_id);
}
