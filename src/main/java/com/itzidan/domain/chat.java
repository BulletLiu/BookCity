package com.itzidan.domain;

import lombok.Data;

@Data
public class chat {
    int id;
    int  uid1;
    int uid2;
    String content;
    String chatTime;
    int bookId;
}
