package com.practice.redisdemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/*
 *@author :parasuram
 *since   :02-04-2021
 */
@Data
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long followers;

	public User(String name, long followers) {
		super();
		this.name = name;
		this.followers = followers;
	}

	public User() {
		super();
	}
}
