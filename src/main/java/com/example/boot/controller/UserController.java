package com.example.boot.controller;

import com.example.boot.bean.ResponseBean;
import com.example.boot.mapper.UserMapper;
import com.example.boot.entity.model.User;
import com.example.boot.service.IUserService;
import com.example.boot.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created
 * author:  lqk
 * 2019/7/30 10:01
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("saveOrUpdate")
    public ResponseBean saveUser(User user){
        ResponseBean responseBean = null;

        User user1 = new User();
        user1.setUserName("罗启坤");
        user1.setAccount("19909090");
        user1.setPassWord("123456");
        try{
            userService.saveUser(user1);
            responseBean = new ResponseBean(Constant.SUCCESS_CODE , "新增数据成功");
        }catch (Exception e){
            return new ResponseBean(Constant.FAILED_CODE , "插入数据失败");
        }
        return responseBean;
    }

    @RequestMapping("selectUser")
    public ResponseBean selectUser(){
        return  new ResponseBean(Constant.SUCCESS_CODE ,"获取数据成功",userService.selectUser());
    }


    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/get")
    public List<User> get(@RequestBody User user, HttpServletRequest req){



        return  null;

    }
}
