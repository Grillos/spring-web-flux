package com.spring.web.flux.service;

import java.time.Duration;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.flux.model.User;
import com.spring.web.flux.repository.UserRepository;
import com.spring.web.flux.request.UserRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Flux<Tuple2<Long, User>> findAll() {
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<User> users = repository.findAll();
		
		return Flux.zip(interval, users);
	}
	
	public Mono<User> findById(Long id) {
		return repository.findById(id);
	}
	
	public Mono<User> create(UserRequest request) {
		User user = new User(request);
		user.setId(new Random().nextLong());
		return repository.save(user);
	}
		

}
