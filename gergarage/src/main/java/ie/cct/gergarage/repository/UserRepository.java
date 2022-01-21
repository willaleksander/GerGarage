package ie.cct.gergarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.cct.gergarage.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

    User findByUsername(String user_username);

}
