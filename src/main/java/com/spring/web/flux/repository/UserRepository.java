package com.spring.web.flux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.web.flux.model.User;

/**
 * @author robson
 *
 */
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

}
