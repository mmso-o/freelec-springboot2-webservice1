package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        /*
        mustache starter 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨.
        앞의 경로는 src/main/resources/templates 로, 뒤의 파일 확장자는 .mustache 가 붙음
         */
        return "index";
    }
}
