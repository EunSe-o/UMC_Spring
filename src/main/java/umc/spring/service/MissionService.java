package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionStatus;
import umc.spring.domain.Store;
import umc.spring.global.exception.InvalidValueException;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;

import umc.spring.repository.StoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;
    private final StoreRepository storeRepository;

    public List<MissionResponseDto> getMissionsByStore(Integer storeId, int page) {
        PageRequest pageable = PageRequest.of(page, 10);
        Page<Mission> result = missionRepository.findAllByStore_StoreId(storeId, pageable);

        return missionConverter.toDtoList(result.getContent());
    }

    public Integer createMission(MissionRequestDto dto) {
        Store store = storeRepository.findById(dto.getStoreId().longValue())
                .orElseThrow(() -> new InvalidValueException("존재하지 않는 가게입니다."));

        Mission mission = Mission.builder()
                .store(store)
                .missionName(dto.getTitle())
                .missionDes(dto.getDescription())
                .status(dto.getStatus() != null ? dto.getStatus() : MissionStatus.new_)
                .build();

        return missionRepository.save(mission).getMissionId();
    }
}