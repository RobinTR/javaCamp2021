package homeworkDay5.business.abstracts;

public interface VerificationService {
	void sendVerifyMail(String email);
	void verifyMail(String email);
	boolean checkMailVerificated(String email);
}
