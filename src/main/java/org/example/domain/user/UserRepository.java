package org.example.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);   // Optional 을 사용하면 null 이나 값을 감싸서 NPE 의 부담을 줄인다.
                                                // Email 을 확인하여 가입되어 있는지 확인한다.
}
