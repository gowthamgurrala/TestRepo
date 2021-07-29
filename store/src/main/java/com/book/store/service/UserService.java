package com.book.store.service;

import com.book.store.Models.User;

public interface UserService {

    public User findByEmail(String email);

}