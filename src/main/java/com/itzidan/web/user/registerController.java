package com.itzidan.web.user;

import com.itzidan.domain.User;
import com.itzidan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/register")
public class registerController {
    @Autowired
    UserService userService;
    String message;
    @PostMapping
    public String register(User user, MultipartFile picFile) {
        boolean flag = userService.addUser(user);
        System.out.println(user.getQq_mail());
        if (flag == false) {
            message = "注册失败，学号或qq邮箱已被注册";
        } else {
            message = "注册成功，请登录qq邮箱进行账号激活操作。";
        }
        return message;

    }
@GetMapping
    public String activateAccount(String uuid){
    System.out.println(uuid);
       boolean flag=userService.activateUser(uuid);
       if (flag==false){
           message="账号激活失败";
       }
       else {message="账号激活成功";}
       return message;

}

}
