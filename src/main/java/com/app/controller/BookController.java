package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.BoookRequest;
import com.app.repository.BookRepo;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	ResponseEntity<?> addBook(@RequestBody BoookRequest b)
	{
		try {
			System.out.println(b.getAuthorName());
			return new ResponseEntity<>(bookService.addBook(b),HttpStatus.OK);
		}catch(RuntimeException e)
		{
			return new ResponseEntity<>("aa",HttpStatus.OK);
		}
	}
}
