/**
 * 
 */
package com.spring.web.flux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author robson
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Profile {
	
	@Id
	private Long id;
	
	private String name;
}
