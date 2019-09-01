package com.example.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.boot.mapper.UserMapper;
import com.example.boot.entity.model.User;
import com.example.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created
 * author:  lqk
 * 2019/7/30 11:44
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user){
        userMapper.insert(user);
    }


    @Override
    public List<User> selectUser() {
        QueryWrapper<User> eq = new QueryWrapper<User>()
                .eq("user_name", "罗启坤 ")
                .eq("pass_word", "123456");

        return userMapper.selectList(eq);
    }



    public List<User> getUser(){
        return userMapper.selectUserList("罗启坤");
    }
}
