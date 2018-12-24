package com.musicmanager.model;

public class Song {
	private int id;  
	private String name;  
	private String author;
	
	
	public Song() {
		super();
	}
	public Song(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}  
}
