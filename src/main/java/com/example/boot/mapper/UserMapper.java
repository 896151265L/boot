package com.example.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boot.entity.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created
 * author:  lqk
 * 2019/7/30 11:43
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserList(@Param("userName") String userName);

}
