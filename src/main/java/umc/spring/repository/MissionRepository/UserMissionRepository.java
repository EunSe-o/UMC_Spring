package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MissionStatus;
import umc.spring.domain.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Integer> {
    boolean existsByUser_UidAndMission_MissionId(Integer uid, Integer missionId);
    Page<UserMission> findAllByUser_UidAndStatus(Long userId, MissionStatus status, Pageable pageable);
}