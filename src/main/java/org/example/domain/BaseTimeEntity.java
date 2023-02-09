package org.example.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity 을 상속할 경우 필드도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate                    // Entity가 생성될 때 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
