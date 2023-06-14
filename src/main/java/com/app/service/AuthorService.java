package com.app.service;

import com.app.dto.AuthorRequest;

public interface AuthorService {
	String addAuthorDetails(AuthorRequest a);

	String removeAuthor(Long authorId);
}
