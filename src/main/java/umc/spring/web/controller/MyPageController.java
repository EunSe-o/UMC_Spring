package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.web.dto.MyPageInfoDto;
import umc.spring.repository.MissionRepository.Query.UserInfoQueryRepository;


@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserInfoQueryRepository userInfoQueryRepository;

    @GetMapping("/{userId}")
    public MyPageInfoDto getMyPageInfo(@PathVariable Integer userId) {
        return userInfoQueryRepository.getMyPageInfo(userId);
    }
}
