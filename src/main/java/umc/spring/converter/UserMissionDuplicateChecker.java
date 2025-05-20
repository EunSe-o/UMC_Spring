package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionRepository.UserMissionRepository;;

@Component
@RequiredArgsConstructor
public class UserMissionDuplicateChecker {

    private final UserMissionRepository userMissionRepository;

    public boolean isNotChallenged(Integer userId, Integer missionId) {
        return !userMissionRepository.existsByUser_UidAndMission_MissionId(userId, missionId);
    }
}