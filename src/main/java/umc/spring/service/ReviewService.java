package umc.spring.service;

import umc.spring.repository.UserRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository;

import umc.spring.domain.UserInfo;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    public Integer writeReview(Integer userId, Long missionId, int score, String text) {
        UserInfo user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션 없음"));

        Review review = Review.builder()
                .user(user)
                .mission(mission)
                .score(score)
                .reviewText(text)
                .build();

        reviewRepository.save(review);
        return review.getReviewId();
    }
}