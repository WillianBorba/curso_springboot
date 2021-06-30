package com.borba.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.borba.course.entities.Order;
import com.borba.course.entities.User;
import com.borba.course.entities.enums.OrderStatus;
import com.borba.course.repositories.OrderRepository;
import com.borba.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepositoy;

	@Override
	public void run(String... args) throws Exception {

		User u = new User(null, "UserTeste", "emailTeste@gmail.com", "1234567859", "12345");
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o = new Order(null, Instant.parse("2020-06-19T19:53:07Z"),OrderStatus.PAID ,u); 
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT ,u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT ,u1);
		
		userRepository.saveAll(Arrays.asList(u, u1, u2));
		orderRepositoy.saveAll(Arrays.asList(o , o1, o2, o3));
	}
}
