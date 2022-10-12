package homeworkDay5;

import homeworkDay5.business.concretes.UserCheckManager;
import homeworkDay5.business.concretes.UserManager;
import homeworkDay5.business.concretes.VerificationManager;
import homeworkDay5.dataAccess.concretes.HibernateUserDao;
import homeworkDay5.entities.concretes.User;

public class Main {
	public static void main(String[] args) {
		User user = new User(1,"Robin","Çen","test@gmail.com","123456");
		User user2 = new User(2,"Robin2","test2","test2@gmail.com","123456");
		User user3 = new User(3,"Robin3","test3","test3@gmail.com","123456");
		User user4 = new User(4,"Robin4","test4","test3gmailcom","123456");
		VerificationManager verificationManager = new VerificationManager();
		UserManager userManager = new UserManager(new HibernateUserDao(), new UserCheckManager(), verificationManager);
		userManager.register(user);
		userManager.register(user2);
		userManager.register(user4);
		verificationManager.verifyMail(user.getEmail());
		userManager.login(user);
		userManager.login(user2);
		userManager.login(user3);//Kayıt yapılmadığı için hatalı.
		
	}
}
