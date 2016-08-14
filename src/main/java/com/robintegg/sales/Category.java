package com.robintegg.sales;

public enum Category {
	SPORTS("category.sports"), NEWS("category.news");
	private String title;

	private Category(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
