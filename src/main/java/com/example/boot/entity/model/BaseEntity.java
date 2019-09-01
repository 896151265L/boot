package com.example.boot.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created
 * author:  lqk
 * 2019/7/30 11:28
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2227612915623424000L;

    //主键生成策略 (全局唯一ID)
    @TableId(value = "id" , type = IdType.ID_WORKER)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private LocalDateTime createTime;
}
