package com.woxueit.boot.controller;

import com.woxueit.boot.pojo.User;
import com.woxueit.boot.service.UserService;
import com.woxueit.boot.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //新增
    @PostMapping
    public CommonResult addUser(@RequestBody User user){
        int i = userService.saveUser(user);
        if(i>0){
            return new CommonResult(200, "success");
        }else {
            return new CommonResult(500, "error");
        }
    }

    //更新
    @PutMapping
    public CommonResult updateUser(@RequestBody User user){
        int i = userService.modifyUser(user);
        if(i>0){
            return new CommonResult(200, "success");
        }else {
            return new CommonResult(500, "error");
        }
    }

    //删除
    @DeleteMapping("/{id}")
    public CommonResult deleteUserById(@PathVariable("id") int id){
        int i = userService.removeUserById(id);
        if(i>0){
            return new CommonResult(200, "success");
        }else {
            return new CommonResult(500, "error");
        }
    }

    //按id查询
    @GetMapping("/{id}")
    public CommonResult getUserById(@PathVariable("id") int id){

        User user = userService.findUserById(id);
        if(user!=null){
            return new CommonResult(200, "success", user);
        }else{
            return new CommonResult(200, "找不到这个用户");
        }
    }

    //查询全部
    @GetMapping
    public CommonResult getUsers(){
        List<User> users = userService.findUsers();
        return new CommonResult(200, "success", users);
    }
}

