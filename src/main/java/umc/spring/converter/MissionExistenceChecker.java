package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionRepository.MissionRepository;

@Component
@RequiredArgsConstructor
public class MissionExistenceChecker {

    private final MissionRepository missionRepository;

    public boolean exists(Integer missionId) {
        return missionRepository.existsById(missionId);
    }
}