package ie.cct.gergarage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Login;
import ie.cct.gergarage.model.User;
import ie.cct.gergarage.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResponse create(User newUser) {
        validateSignUp(newUser);
        User user = new User();
        BeanUtils.copyProperties(newUser, user);
        userRepository.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(Login login) {
        User user = userRepository.findByUsername(login.getUsername());
        if(user == null) {
            throw new RuntimeException("User doesn't exist.");
        }
        if(!user.getUser_password().equals(login.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", user.getUser_type()) ;

    }

    private void validateSignUp(User newUser) {
    }

	@Override
	public ApiResponse list() {
		List<User> users = userRepository.findAll();
		return new ApiResponse(200, "success", users);
	}
}
