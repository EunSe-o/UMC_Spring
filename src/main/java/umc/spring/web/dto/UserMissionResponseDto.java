package umc.spring.web.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
public class UserMissionResponseDto {
    private final Integer missionId;
    private final String title;
    private final String description;
    private final String storeName;

    @Builder
    public UserMissionResponseDto(Integer missionId, String title, String description, String storeName) {
        this.missionId = missionId;
        this.title = title;
        this.description = description;
        this.storeName = storeName;
    }
}