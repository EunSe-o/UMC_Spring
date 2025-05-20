package umc.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionStatus;
import umc.spring.domain.UserInfo;
import umc.spring.domain.UserMission;
import umc.spring.global.exception.CustomException;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.MissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.ChallengeMissionRequestDto;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    public Integer challengeMission(ChallengeMissionRequestDto dto) {
        UserInfo user = userRepository.findById(1)
                .orElseThrow(() -> new CustomException("유저 없음"));
        Mission mission = missionRepository.findById(dto.missionId())
                .orElseThrow(() -> new CustomException("미션 없음"));

        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.progress) // 도전 중
                .build();

        userMissionRepository.save(userMission);
        return userMission.getUserMissionId();
    }
}
