package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.Mission;
import umc.spring.domain.MissionStatus;
import java.util.List;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.MissionRepository.Query.MissionQueryRepository;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionRepository missionRepository;
    // 진행/완료 미션 조회
    @GetMapping("/user/{userId}")
    public List<Mission> getUserMissions(
            @PathVariable Long userId,
            @RequestParam MissionStatus status,
            @RequestParam int page,
            @RequestParam int size) {
        return missionRepository.findMissionsByUserAndStatus(userId, status, page * size, size);
    }

    // 도전 가능한 미션 조회 (홈화면)
    @GetMapping("/region")
    public List<Mission> getNewMissionsInRegion(
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String neighborhood,
            @RequestParam int page,
            @RequestParam int size) {
        return missionRepository.findNewMissionsInRegion(city, district, neighborhood, page * size, size);
    }

    // 지역별 완료 미션 개수
    @GetMapping("/region/completed")
    public Long countCompletedMissions(
            @RequestParam Long userId,
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String neighborhood) {
        return missionRepository.countCompletedMissionsInRegion(userId, city, district, neighborhood);
    }

    // 지역별 전체 미션 개수
    @GetMapping("/region/total")
    public Long countTotalMissions(
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String neighborhood) {
        return missionRepository.countTotalMissionsInRegion(city, district, neighborhood);
    }
}