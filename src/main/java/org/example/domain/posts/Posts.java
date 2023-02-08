package org.example.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor  // 기본 생성자 생성
@Entity     // 테이블과 링크될 클래스임을 선언
public class Posts {
    @Id     // JPA PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 500, nullable = false)     // Id 가 없는건 모두 컬럼이 되지만 컬럼 조건을 변경할 때는 @Column 선언
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private  String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
