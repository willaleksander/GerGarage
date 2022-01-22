package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Login;
import ie.cct.gergarage.model.User;
import ie.cct.gergarage.repository.UserRepository;

// Implementation of the interface userService
// uses the userRepository to access the database for the user model
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    // create a user
    @Override
    public ApiResponse create(User newUser) {
        User user = new User();
        BeanUtils.copyProperties(newUser, user);
        userRepository.save(user);
        return new ApiResponse(200, "success", user);
    }
    
    // login to the system
    @Override
    public ApiResponse login(Login login) {
        User user = userRepository.findByUsername(login.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist");
        }
        if(!user.getUser_password().equals(login.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        // prevent someone to see user password
        user.setUser_password(null);
        return new ApiResponse(200, "Success login", user) ;

    }

	@Override
	public ApiResponse list() {
		List<User> users = userRepository.findAll();
		return new ApiResponse(200, "success", users);
	}
}
