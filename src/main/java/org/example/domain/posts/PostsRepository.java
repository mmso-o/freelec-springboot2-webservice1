package org.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JPA Entity 클래스의 인터페이스, Entity 클래스와 같은 디렉토리에 존재해야한다.
    // Entity 클래스도 Repositry 없이는 역할을 할 수 없다.
    // JpaRepository<Entity 클래스, PK 타입>

    @Query("SELECT p FROM  Posts p ORDER BY p.id DESC") // JPA에서 제공하지 않는 메서드는 @Query를 사용할 수 있음.
    List<Posts> findAllDesc();
}
