package com.practice.redisdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.practice.redisdemo.model.User;
import com.practice.redisdemo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 *@author :parasuram
 *since   :02-04-2021
 */
@SpringBootApplication
@EnableCaching
@Slf4j
public class RedisDemoApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public RedisDemoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Saving Users.Current User Count  is {}", userRepository.count());
        List<User> users = Arrays.asList(new User("Shubham", 20000),
                new User("Pankaj", 29000),new User("Lewis", 5500));
        userRepository.saveAll(users);
        log.info("Done saving users. Data: {}.", userRepository.findAll());
    }
}
