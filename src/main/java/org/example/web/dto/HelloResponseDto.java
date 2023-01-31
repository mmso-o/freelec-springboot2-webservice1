package org.example.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor    // final 선언된 변수로 생성자를 만든다
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
