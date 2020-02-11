package com.itzidan;

import com.itzidan.utils.SMTP_Mail;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@MapperScan("com.itzidan.mapper")
public class BookCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCityApplication.class, args);
    }

}
