package com.book.store;

import com.book.store.Models.Role;
import com.book.store.Models.User;
import com.book.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {

        SpringApplication.run(StoreApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


//        User u = new User("Gowtham", "password", "Gowtham Gurrala");
//        Role r = new Role("USER");
//        u.addRoles(r);
//        userRepository.save(u);
//
//
//        User u1 = new User("Bharath", "password", "Bharath Nemali");
//        Role r1 = new Role("USER");
//        u.addRoles(r1);
//        userRepository.save(u1);


    }
}
