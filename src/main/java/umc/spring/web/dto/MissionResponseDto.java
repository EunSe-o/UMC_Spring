package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MissionResponseDto {

    private final Integer missionId;
    private final String title;
    private final String description;

    @Builder
    public MissionResponseDto(Integer missionId, String title, String description) {
        this.missionId = missionId;
        this.title = title;
        this.description = description;
    }
}