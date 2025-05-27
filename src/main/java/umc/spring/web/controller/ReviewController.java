package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.ReviewService;
import umc.spring.validation.CustomPage;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.util.List;
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

    @Operation(summary = "내가 작성한 리뷰 목록 조회")
    @GetMapping("/my")
    public ResponseEntity<List<ReviewResponseDto>> getMyReviews(@CustomPage Integer page) {
        List<ReviewResponseDto> result = reviewService.getMyReviews(page);
        return ResponseEntity.ok(result);
    }
}