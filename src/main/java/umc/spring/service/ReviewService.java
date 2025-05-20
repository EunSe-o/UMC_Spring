package umc.spring.service;

import umc.spring.global.exception.CustomException;
import umc.spring.repository.UserRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository;

import umc.spring.domain.UserInfo;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import umc.spring.web.dto.ReviewRequestDto;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    public Integer writeReview(ReviewRequestDto dto) {

        UserInfo user = userRepository.findById(1)
                .orElseThrow(() -> new CustomException("유저 없음"));

        Mission mission = missionRepository.getReferenceById(dto.missionId());

        Review review = Review.builder()
                .user(user)
                .mission(mission)
                .score(dto.score())
                .reviewText(dto.reviewText())
                .build();

        reviewRepository.save(review);
        return review.getReviewId();
    }
}