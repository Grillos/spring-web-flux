package com.spring.web.flux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.flux.model.User;
import com.spring.web.flux.request.UserRequest;
import com.spring.web.flux.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * @author robson
 *
 */
@RestController
@RequestMapping(value = "/v1")
public class UserController {
	
	@Autowired
	private UserService service;
    
    @GetMapping(value = "/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, User>> findAll() {
    	return service.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Mono<User> findById(@PathVariable Long id) {
    	return service.findById(id);
    }
    
   @PostMapping("/users")
   public Mono<User> update(@RequestBody UserRequest request) {
    	return service.create(request);
   }
}
