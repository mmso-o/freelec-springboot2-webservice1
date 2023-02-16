package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());

        /*
        mustache starter 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨.
        앞의 경로는 src/main/resources/templates 로, 뒤의 파일 확장자는 .mustache 가 붙음
         */
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
