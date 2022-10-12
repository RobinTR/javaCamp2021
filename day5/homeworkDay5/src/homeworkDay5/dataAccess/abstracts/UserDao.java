package homeworkDay5.dataAccess.abstracts;

import java.util.List;

import homeworkDay5.entities.concretes.User;

public interface UserDao {
	void register(User user);
	boolean getEmail(String email);
	boolean getPassword(String password);
	List<User> getAllUsers();
}
