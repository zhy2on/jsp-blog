package com.cos.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // ORM 클래스
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스: AUTO_INCREMENT

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100) // 비밀번호 암호화를 위해 넉넉하게 잡아두기
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    private UserRole role;

    @CreationTimestamp // 시간이 자동으로 입력
    private Timestamp createDate;
}
