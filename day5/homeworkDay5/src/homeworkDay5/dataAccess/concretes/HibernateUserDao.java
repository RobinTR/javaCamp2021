package homeworkDay5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homeworkDay5.dataAccess.abstracts.UserDao;
import homeworkDay5.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	private List<User> users = new ArrayList<User>();

	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public boolean getEmail(String email) {
		for (User user : users) {
			if (user.getEmail() == email) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for (User user : users) {
			if (user.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

}
