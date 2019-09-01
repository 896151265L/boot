package com.example.boot.service;


import com.example.boot.entity.model.User;

import java.util.List;

/**
 * Created
 * author:  lqk
 * 2019/7/30 11:44
 */
public interface IUserService {

    void saveUser(User user);
    List<User> selectUser();



    List<User> getUser();
 }
