package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.UserMission;
import umc.spring.web.dto.UserMissionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMissionConverter {

    public List<UserMissionResponseDto> toDtoList(List<UserMission> list) {
        return list.stream()
                .map(um -> UserMissionResponseDto.builder()
                        .missionId(um.getMission().getMissionId())
                        .title(um.getMission().getMissionName())
                        .description(um.getMission().getMissionDes())
                        .storeName(um.getMission().getStore().getStoreName())
                        .build())
                .collect(Collectors.toList());
    }
}