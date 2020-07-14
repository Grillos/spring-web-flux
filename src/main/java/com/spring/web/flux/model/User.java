package com.spring.web.flux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spring.web.flux.request.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
	
	public User(UserRequest request) {
		this.name = request.getName();
	}
	
	@Id
	private Long id;
	
	private String name;

}
