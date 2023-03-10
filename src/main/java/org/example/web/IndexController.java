package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.config.auth.LoginUser;
import org.example.config.auth.dto.SessionUser;
import org.example.service.posts.PostsService;
import org.example.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){  // @LoginUser 어노테이션으로 어느 컨트롤러든지 세션 정보를 가져올 수 있다.
        model.addAttribute("posts", postsService.findAllDesc()); // 서버 템플릿 엔진에서 사용할 수 있는 객체를 posts로 저장하여 index.mustache 에 전달한다.

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

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

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
