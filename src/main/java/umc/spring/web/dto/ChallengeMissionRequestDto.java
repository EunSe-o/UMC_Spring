package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import umc.spring.validation.ExistsMissionNotChallenged;


public record ChallengeMissionRequestDto(
        @NotNull(message = "미션 ID는 필수입니다.")
        @ExistsMissionNotChallenged
        Integer missionId
) {}