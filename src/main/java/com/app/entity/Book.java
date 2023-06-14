package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "books")
@ToString
public class Book  extends BaseEntity {

	private String bookName;
	private double bookPice;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "author_id")
	private Author author;

	public Book(String bookName, double bookPice) {
		super();
		this.bookName = bookName;
		this.bookPice = bookPice;
	}
	
	
}
