package homeworkDay5.core;

import java.util.ArrayList;
import java.util.List;

import homeworkDay5.business.abstracts.VerificationService;

public class googleLoginAdapter implements VerificationService {

	private List<String> verifiedMails = new ArrayList<String>();
	
	@Override
	public void sendVerifyMail(String email) {
		System.out.println(email + " mail'ine doğrulama e-postası gönderildi.");
	}

	@Override
	public boolean checkMailVerificated(String email) {
		if (verifiedMails.contains(email)) {
			return true;
		}
		return false;
	}

	@Override
	public void verifyMail(String email) {
		verifiedMails.add(email);
		System.out.println(email + " başarıyla doğrulandı.");
	}

}
