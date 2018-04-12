package com.owl.user.entity;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.owl.user.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "TB_USER")
@KeySequence(value = "SEQ_USER_ID",clazz = Integer.class)
public class User {
    @TableId(value = "ID")
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private LocalDateTime createTime;
    //不进行数据库映射字段
    @TableField(exist = false)
    private transient String genderDesc;
    public String getGenderDesc() {
        return this.gender.getDesc();
    }
}
