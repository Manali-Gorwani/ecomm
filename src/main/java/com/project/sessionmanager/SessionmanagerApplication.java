package com.project.sessionmanager;

import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SessionmanagerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SessionmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("vipul",this.bCryptPasswordEncoder.encode("vipul"),"vipul@gmail.com", "ROLE_ADMIN");
		this.userRepository.save(user);
		User user1 = new User("manali",this.bCryptPasswordEncoder.encode("manali"),"manali@gmail.com", "ROLE_NORMAL");
		this.userRepository.save(user1);
	}
}
