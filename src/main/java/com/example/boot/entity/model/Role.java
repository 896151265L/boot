package com.example.boot.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created
 * author:  lqk
 * 2019/8/29 13:50
 */
@Data
@TableName("t_role")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role extends BaseEntity{

    private String roleName;
    private String userId;

}
