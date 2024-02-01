package com.cos.blog.test;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String username;
    private int password;
    private String email;
}
