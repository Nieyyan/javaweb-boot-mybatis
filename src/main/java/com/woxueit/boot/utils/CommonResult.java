package com.woxueit.boot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//通用结果类型
@Data
@NoArgsConstructor //相当于无参数构造器
@AllArgsConstructor //相当于全参数构造器
public class CommonResult {
    private int code;
    private String msg;
    private Object data;

    //两个参数的构造器
    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
