package com.woxueit.boot.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data //一个顶3个：相当于写setter、getter、toString
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
