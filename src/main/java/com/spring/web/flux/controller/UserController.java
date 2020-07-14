package com.spring.web.flux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.flux.model.User;
import com.spring.web.flux.request.UserRequest;
import com.spring.web.flux.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/v1")
@Api(tags = "User Controller")
public class UserController {
	
	@Autowired
	private UserService service;
    
    @ApiOperation(value = "Find user", notes = "Find user applying parameter", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Find user request successfully executed", response = User.class),
			@ApiResponse(code = 404, message = "The request resource was not found") })
    @GetMapping(value = "/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, User>> findAll() {
    	return service.findAll();
    }
    
    @ApiOperation(value = "Create user", notes = "Create user", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
   	@ApiResponses({
   			@ApiResponse(code = 201, message = "User create request successfully executed", response = User.class),
   			@ApiResponse(code = 404, message = "The request resource was not found") })
   @PostMapping("/users")
   public Mono<User> update(@RequestBody UserRequest request) {
    	return service.create(request);
   }
}
