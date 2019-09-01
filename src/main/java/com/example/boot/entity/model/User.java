package com.example.boot.entity.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Created
 * author:  lqk
 * 2019/7/30 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
@Builder(toBuilder = true)
public class User extends BaseEntity{

    private String userName;    //用户名
    private String account;     //账号
    private String passWord;    //密码


    @TableField(exist = false)
    private List<Role> role;


}
