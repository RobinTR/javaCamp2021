package homeworkDay5.business.concretes;

import java.util.List;

import homeworkDay5.business.abstracts.UserCheckService;
import homeworkDay5.business.abstracts.UserService;
import homeworkDay5.business.abstracts.VerificationService;
import homeworkDay5.dataAccess.abstracts.UserDao;
import homeworkDay5.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private UserCheckService userCheckService;
	private VerificationService verificationService;

	public UserManager(UserDao userDao, UserCheckService userCheckService, VerificationService verificationService) {
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.verificationService = verificationService;
	}

	@Override
	public void register(User user) {
		if(userCheckService.checkFirstName(user) && userCheckService.checkLastName(user) && userCheckService.checkEmail(user) && userCheckService.checkPassword(user)) {
			userDao.register(user);
			verificationService.sendVerifyMail(user.getEmail());
			System.out.println("Kayıt başarılı: " + user.getEmail());
		}
		
	}

	@Override
	public void login(User user) {
			if (userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword()) && verificationService.checkMailVerificated(user.getEmail())) {
				System.out.println("Giriş başarılı: " + user.getEmail());
				return;
			} else if (userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword())) {
				System.out.println("Lütfen eposta hesabınıza gönderilen mail'den hesabınızı doğrulayın.");
				return;
			}
		System.out.println("Kullanıcı adı veya şifre hatalı.");
	}

	@Override
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

}
