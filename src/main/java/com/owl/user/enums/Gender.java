package com.owl.user.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

public enum Gender implements IEnum {
    MALE(0,"男"),
    FEMALE(1,"女");
    private Integer value;
    private String desc;

    Gender(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    @Override
    public Serializable getValue() {
        return this.value;
    }
    public String getDesc() {
        return desc;
    }
}
