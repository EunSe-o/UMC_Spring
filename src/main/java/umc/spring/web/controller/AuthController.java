package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.UserService;
import umc.spring.web.dto.SignupRequestDto;

//@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignupRequestDto request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "로그인 성공!";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "로그아웃 성공!";
    }
}