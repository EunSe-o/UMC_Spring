package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.UserService;
import umc.spring.web.dto.JwtLoginRequestDto;
import umc.spring.web.dto.JwtLoginResponseDto;
import umc.spring.web.dto.SignupRequestDto;
import umc.spring.web.jwt.JwtProvider;

@RestController
@RequiredArgsConstructor
public class AuthControllerJWT {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignupRequestDto request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입 완료!");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtLoginResponseDto> login(@RequestBody JwtLoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUname(), request.getUpassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(request.getUname());
        return ResponseEntity.ok(new JwtLoginResponseDto(token));
    }
}