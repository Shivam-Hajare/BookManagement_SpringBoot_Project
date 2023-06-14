package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.BoookRequest;
import com.app.entity.Author;
import com.app.entity.Book;
import com.app.repository.AuthorRepo;
import com.app.repository.BookRepo;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AuthorRepo authorRepo;
	
	@Override
	public String addBook(BoookRequest b) {
		Author a = authorRepo.findByAuthorName(b.getAuthorName()).orElseThrow(()->new ResourceNotFoundException("Invalid author name!!!!!"));
		
		Book book= mapper.map(b, Book.class);
		
		a.addBook(book);
		authorRepo.save(a);
		bookRepo.save(book);
		return null;
	}



}
