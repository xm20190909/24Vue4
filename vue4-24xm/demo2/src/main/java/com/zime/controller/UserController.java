package com.zime.controller;

import com.zime.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    public static ArrayList<User> userlist = new ArrayList<User>();

    /**判断用户名是否已存在.**/
    @RequestMapping(path="/isexist",method = RequestMethod.GET)
    public boolean IsExist(@RequestParam("username") String username){
        boolean bRet = false;
        for(int i=0;i<userlist.size();i++){
            if (userlist.get(i).getUsername().equals(username)){
                bRet = true;
                break;
            }
        }
        System.out.println("isExist");
        return bRet;
    }
    /**判断用户,密码是否正确.**/
    @RequestMapping(path="/login",method = RequestMethod.POST)
    public boolean Login(@RequestBody User user){
        boolean bRet = userlist.contains(user);
        System.out.println("Login"+userlist);
        System.out.println(user.getUsername()+"&&"+user.getPassword());
        return bRet;
    }
    /**添加用户.**/
    @RequestMapping(path="/register",method = RequestMethod.POST)
    public  boolean Register(@RequestBody User user){
        userlist.add(user);
        System.out.println("Register:"+user.getUsername()+"**"+user.getPassword());
        return true;
    }
}
