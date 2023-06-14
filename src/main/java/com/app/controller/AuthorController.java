package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthorRequest;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	ResponseEntity<?> addAuthor(@RequestBody AuthorRequest a)
	{
		try {
			System.out.println(a);
			return new ResponseEntity<>(authorService.addAuthorDetails(a),HttpStatus.OK);
		}catch(RuntimeException e)
		{
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	
}
