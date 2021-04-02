package com.practice.redisdemo.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.redisdemo.model.User;
import com.practice.redisdemo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
/*
 *@author :parasuram
 *since   :02-04-2021
 */

@Slf4j
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * Get User By userId
     *
     * @param:userId
     */
    @Cacheable(value = "users", key = "#userId")
    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable Long userId) {
        log.info("Get User By Id", userId);
        return userRepository.findById(userId).get();
    }

    /*
     * Update an User
     *
     * @RequestBody:User
     */
    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        log.info("Update User By Id", user.getId());
        userRepository.save(user);
        return user;
    }

    /*
     * Delete an User by userId
     *
     * @Param:userId
     */
    @CacheEvict(value = "users")
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        log.info("Delete User with Id", userId);
        userRepository.deleteById(userId);
    }
}
