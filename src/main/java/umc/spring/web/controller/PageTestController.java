package umc.spring.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.validation.CustomPage;

@RestController
@RequestMapping("/api/test")
public class PageTestController {

    @GetMapping
    public ResponseEntity<String> testPage(@CustomPage Integer page) {
        return ResponseEntity.ok("요청한 페이지 번호는: " + page);
    }
}