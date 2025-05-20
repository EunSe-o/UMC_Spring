package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.spring.validation.ExistsMission;
import umc.spring.validation.ValidStoreInMission;

public record ReviewRequestDto(
        @NotNull(message = "미션 ID는 필수입니다.") @ValidStoreInMission @ExistsMission Integer missionId,
        @NotBlank(message = "리뷰 내용은 필수입니다.") String reviewText,
        @NotNull(message = "점수는 필수입니다.") Integer score
) {}