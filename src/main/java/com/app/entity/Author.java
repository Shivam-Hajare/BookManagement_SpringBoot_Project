package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "authors")
@ToString
public class Author extends BaseEntity {

	@Column(unique = true, length = 20)
	private String AuthorName;
	
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book>booklist=new ArrayList<Book>();

	public Author(String authorName) {
		super();
		AuthorName = authorName;
	}
	
	public void addBook(Book b) {
		booklist.add(b);
		b.setAuthor(this);
	}
	public void removeStudent(Book b) {
		booklist.remove(b);
		b.setAuthor(null);
	}
	
}
