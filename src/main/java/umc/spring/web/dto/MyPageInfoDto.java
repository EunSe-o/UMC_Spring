package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.domain.UserInfo;
import umc.spring.domain.Review;

import java.util.List;


@Getter
@AllArgsConstructor
public class MyPageInfoDto {
    private UserInfo user;
    private List<Review> reviews;
}
