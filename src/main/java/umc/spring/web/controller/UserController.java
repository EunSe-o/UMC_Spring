package umc.spring.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/me")
    public String me(Authentication authentication) {
        return "현재 로그인한 사용자: " + authentication.getName();
    }
}