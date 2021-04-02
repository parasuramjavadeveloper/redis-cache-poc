package com.practice.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.redisdemo.model.User;

/*
 *@author :parasuram
 *since   :02-04-2021
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
