package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.UserMissionService;
import umc.spring.validation.CustomPage;
import umc.spring.web.dto.ChallengeMissionRequestDto;
import umc.spring.web.dto.UserMissionResponseDto;

import java.util.List;

@Tag(name = "유저 미션 API")
@RestController
@RequestMapping("/user-missions")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @PostMapping("/challenge")
    public Integer challenge(@RequestBody @Valid ChallengeMissionRequestDto dto) {
        return userMissionService.challengeMission(dto);
    }


    @Operation(summary = "내가 진행 중인 미션 목록 조회")
    @GetMapping("/progress")
    public ResponseEntity<List<UserMissionResponseDto>> getProgressMissions(
            @CustomPage @Parameter(description = "1부터 시작하는 페이지 번호") Integer page) {

        List<UserMissionResponseDto> result = userMissionService.getProgressingMissions(page);
        return ResponseEntity.ok(result);
    }
}