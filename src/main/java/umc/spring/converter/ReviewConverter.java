package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewResponseDto;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewConverter {

    public List<ReviewResponseDto> toDtoList(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewResponseDto.builder()
                        .id(review.getReviewId().longValue())
                        .content(review.getReviewText())
                        .storeName(review.getMission().getStore().getStoreName())
                        .build())
                .collect(Collectors.toList());
    }
}