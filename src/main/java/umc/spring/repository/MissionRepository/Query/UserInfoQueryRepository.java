package umc.spring.repository.MissionRepository.Query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.web.dto.MyPageInfoDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserInfoQueryRepository {

    private final JPAQueryFactory queryFactory;

    public MyPageInfoDto getMyPageInfo(Integer userId) {
        QUserInfo user = QUserInfo.userInfo;
        QReview review = QReview.review;

        // 유저 기본 정보
        UserInfo userInfo = queryFactory.selectFrom(user)
                .where(user.uid.eq(userId))
                .fetchOne();

        // 리뷰 목록
        List<Review> reviewList = queryFactory.selectFrom(review)
                .where(review.user.uid.eq(userId))
                .fetch();

        return new MyPageInfoDto(userInfo, reviewList);
    }
}