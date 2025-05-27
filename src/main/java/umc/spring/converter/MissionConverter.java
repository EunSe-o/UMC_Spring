package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionConverter {

    public List<MissionResponseDto> toDtoList(List<Mission> missions) {
        return missions.stream()
                .map(m -> MissionResponseDto.builder()
                        .missionId(m.getMissionId())
                        .title(m.getMissionName())
                        .description(m.getMissionDes())
                        .build())
                .collect(Collectors.toList());
    }
}
