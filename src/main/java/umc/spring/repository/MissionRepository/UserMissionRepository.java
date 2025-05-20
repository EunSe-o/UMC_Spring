package umc.spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Integer> {
    boolean existsByUser_UidAndMission_MissionId(Integer uid, Integer missionId);
}