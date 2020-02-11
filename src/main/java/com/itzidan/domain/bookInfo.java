package com.itzidan.domain;

import lombok.Data;

@Data
public class bookInfo {
    int id;
    String bookName;
    String bookAuthor;
    String press;
    String price;
    int bookNum;
    int kind;
    String remarks;
    int userId;
    String picSrc;
    int bookStatus;
    String bookTime;
}
