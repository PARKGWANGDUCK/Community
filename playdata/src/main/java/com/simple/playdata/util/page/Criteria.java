package com.simple.playdata.util.page;

import lombok.Data;

@Data
public class Criteria {

	private int page;
	private int amount;
	
	private String type;
	private String title;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
}
