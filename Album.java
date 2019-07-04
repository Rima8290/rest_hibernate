package com.lti.hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ALBUM")
public class Album {
	
	@Id
	@GeneratedValue
	@Column(name="ALBUM_ID")
	private int id;
	private String name;
	private String copyright;
	private int year;
	
	@OneToMany
	private Set<Songs> songs;

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

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set<Songs> getSongs() {
		return songs;
	}

	public void setSongs(Set<Songs> songs) {
		this.songs = songs;
	}
	
	

}
