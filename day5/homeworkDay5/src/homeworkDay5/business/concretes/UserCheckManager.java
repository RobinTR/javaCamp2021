package homeworkDay5.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import homeworkDay5.business.abstracts.UserCheckService;
import homeworkDay5.entities.concretes.User;

public class UserCheckManager implements UserCheckService {
	
	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("Lütfen isim giriniz.");
			return false;
		} else if (user.getFirstName().length() < 2) {
			System.out.println("İsim en az 2 karakterden oluşmalı.");
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().isEmpty()) {
			System.out.println("Lütfen soyad giriniz.");
			return false;
		} else if (user.getLastName().length() < 2) {
			System.out.println("Soyadı en az 2 karakterden oluşmalı.");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("Lütfen şifre giriniz.");
			return false;
		} else if (user.getPassword().length() < 6) {
			System.out.println("Şifre en az 6 karakterden oluşmalıdır.");
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

		if (user.getEmail().isEmpty()) {
			System.out.println("Email boş bırakılamaz.");
			return false;
		} else if (pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("Geçersiz email formatı. Örnek: test@mymail.com");
			return false;
		}
		return true;
	}

}
