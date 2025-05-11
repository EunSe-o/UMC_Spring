package umc.spring.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.ReviewService;


@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Integer writeReview(
            @RequestParam Integer userId,
            @RequestParam Long missionId,
            @RequestParam int score,
            @RequestParam String reviewText) {
        return reviewService.writeReview(userId, missionId, score, reviewText);
    }
}