package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.MissionStatus;

@Getter
@NoArgsConstructor
public class MissionRequestDto {
    private Integer storeId;
    private String title;
    private String description;
    private MissionStatus status;
}
