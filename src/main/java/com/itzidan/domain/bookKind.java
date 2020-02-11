package com.itzidan.domain;

import lombok.Data;

@Data
public class bookKind {
    int id;
    int parentId;
    String kindName;
}
