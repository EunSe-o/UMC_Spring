package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.ReviewService;
import umc.spring.web.dto.ReviewRequestDto;

import java.util.Map;



@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Map<String, Integer>> writeReview(@Valid @RequestBody ReviewRequestDto dto) {
        Integer reviewId = reviewService.writeReview(dto);
        return ResponseEntity.ok(Map.of("reviewId", reviewId));
    }
}