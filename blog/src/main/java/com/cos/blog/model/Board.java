package com.cos.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // ORM 클래스
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터 large object
    @Column(columnDefinition = "longtext")
    private String content; // summernote 사용. <html>태그가 섞여서 디자인이 됨 -> 대용량

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne // Many=Board, User=One 한 명의 유저는 여러 개의 게시글을 쓸 수 있다.
    @JoinColumn(name="userId")
    private User user; // 작성자.
    // 원래 DB는 오브젝트를 저장할 수 없다. FK를 써야한다. 그런데 자바는 오브젝트를 저장할 수 있다.
    // ORM을 사용하면 오브젝트 코드를 DB로 매핑시킬 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아니에요. DB에 컬럼을 만들지 마세요)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
