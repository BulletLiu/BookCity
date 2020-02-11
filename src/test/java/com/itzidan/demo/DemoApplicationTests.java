package com.itzidan.demo;

import com.itzidan.domain.SMail;
import com.itzidan.domain.User;
import com.itzidan.mapper.UserMapper;
import com.itzidan.service.UserService;
import com.itzidan.serviceImpl.UserServiceImpl;
import com.itzidan.utils.SMTP_Mail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;


@SpringBootTest
class DemoApplicationTests {
@Autowired
UserService userService;
@Autowired
    UserMapper userMapper;
    @Test
   void tt() {
        User user=new User();
        user.setSno("202170920");
        user.setPwd("123");
        user.setNickName("liu");
        user.setGrade("1");
        user.setName("lwl");
        user.setMajor("magor");
        user.setInstitute("instit" );
        user.setQq_mail("qq");
        System.out.println(userService.addUser(user));

    }
    @Test
    public void selectByUUId(){
        System.out.println(userService.activateUser("ucuaIUU3"));

    }

}
