package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoookRequest {

	private String bookName;
	private double bookPice;

	private String authorName;
}
