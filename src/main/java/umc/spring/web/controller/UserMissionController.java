package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.UserMissionService;
import umc.spring.web.dto.ChallengeMissionRequestDto;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @PostMapping("/challenge")
    public Integer challenge(@RequestBody @Valid ChallengeMissionRequestDto dto) {
        return userMissionService.challengeMission(dto);
    }
}