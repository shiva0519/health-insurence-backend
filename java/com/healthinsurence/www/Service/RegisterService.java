package com.healthinsurence.www.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurence.www.Entity.Loginpage;
import com.healthinsurence.www.Entity.Registration;
import com.healthinsurence.www.Repositary.LoginRepository;
import com.healthinsurence.www.Repositary.RegistrationReposotory;

@Service
public class RegisterService {
	
	@Autowired
	RegistrationReposotory registerRepo;
	@Autowired
	LoginRepository loginRepositary;	
	public Registration addregister(Registration register) {
		Registration reg=registerRepo.save(register);
		  Loginpage userlogin = new Loginpage();

		 userlogin.setUsername(reg.getEmail());
		 userlogin.setUserpassword(reg.getPassword());
		loginRepositary.save(userlogin);
		
		return registerRepo.save(register);
	}
	public List<Registration> getAll() {
		return registerRepo.findAll();
	}
	
	public boolean check(String username,String password) 
	{
		Registration reg=registerRepo.findByEmail(username);
		if(reg==null)
		{
			return false;
		}
		
		return reg.getPassword().equals(password);
	}
	

	public Registration getById(String email) {
		return registerRepo.findByEmail(email);
	}
	public Registration findByEmail(String email) {
		// TODO Auto-generated method stub
		return registerRepo.findByEmail(email);
	}
	public Registration update(Registration register, String email) {
		
		Registration reg=registerRepo.findByEmail(email);
		reg.setFirstname(register.getFirstname());
		reg.setAddress(register.getAddress());
		
		
		return registerRepo.save(reg);
		
		
		
		
//		return registerRepo.save(register);
	}
	public String generateOTP(int length) {
		// TODO Auto-generated method stub
		String numbers="0123456789";
		
		StringBuilder otp=new StringBuilder(length);
		
		Random random=new Random();
		for(int i=0;i<=length;i++) {
		otp.append(numbers.charAt(random.nextInt(numbers.length())));
		}
		
		return otp.toString();
	}
	public boolean checkMail(String email) {
		
		return registerRepo.existsById(email);
	}

}
