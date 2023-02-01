package org.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JPA Entity 클래스의 인터페이스, Entity 클래스와 같은 디렉토리에 존재해야한다.
    // Entity 클래스도 Repositry 없이는 역할을 할 수 없다.
    // JpaRepository<Entity 클래스, PK 타입>
}
