package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{

	Optional<Author>findByAuthorName(String authorName);
}
