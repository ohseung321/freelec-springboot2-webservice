package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Getter //클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor // 기본생성자 자동추가, public Posts() 와 같은 효과
@Entity//테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id //해당 테이블의 pk필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)// PK 생성규칙 스트링 부트2.0에서는 GenerationType.IDENTITY 옵션을 추가 해야만 auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언안해도해당 클래스의 필드는 모두 칼럼이 되지만.기본값 외에 추가로 변경할 경우 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //@Column 선언 안해도 @Entity 클래스 안의 필드는 모두 컬럼이 된다.
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포험된 필드만 빌더에 포함.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
