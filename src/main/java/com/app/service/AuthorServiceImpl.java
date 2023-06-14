package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AuthorRequest;
import com.app.entity.Author;
import com.app.repository.AuthorRepo;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepo authorRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addAuthorDetails(AuthorRequest a) {
		Author newAuth=authorRepo.save(mapper.map(a, Author.class));
		return newAuth.getAuthorName()+"added succesfully!!!!";
	}

	@Override
	public String removeAuthor(Long authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
