package com.example.boot.controller;

import com.example.boot.bean.ResponseBean;
import com.example.boot.entity.model.User;
import com.example.boot.util.Constant;
import com.example.boot.util.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Created
 * author:  lqk
 * 2019/7/31 9:40
 */
@Slf4j
@RestController
@RequestMapping("session")
public class LoginController {


    @PostMapping("login")
    public ResponseBean login(@RequestBody User user, String token, HttpServletRequest req) {


        try {
            BufferedReader br = req.getReader();
            String str, wholeStr = "";
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
        }catch (Exception e){
            System.out.println("错误信息");
        }


        //验签
        if (!Md5Utils.validateSign(token, user)) {
            return new ResponseBean(Constant.FAILED_CODE, "签名错误");
        }
        req.getSession().setAttribute("user", user);
        return null;
    }


}
