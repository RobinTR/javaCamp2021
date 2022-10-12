package homeworkDay5.business.abstracts;

import java.util.List;

import homeworkDay5.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
	List<User> getUsers();
}
