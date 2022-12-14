package homeworkDay5.business.abstracts;

import homeworkDay5.entities.concretes.User;

public interface UserCheckService {
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkPassword(User user);
	boolean checkEmail(User user);
}
