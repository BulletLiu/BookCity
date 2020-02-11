package com.itzidan.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SMail {
    private String to;                                // 收件人
    private String subject;                            // 邮件主题
    private String content;

}