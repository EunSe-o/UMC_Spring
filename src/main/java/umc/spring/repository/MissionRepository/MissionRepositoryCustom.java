package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;
import umc.spring.domain.MissionStatus;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(String name, String city);

    List<Mission> findMissionsByUserAndStatus(Long userId, MissionStatus status, int offset, int limit);

    List<Mission> findNewMissionsInRegion(String city, String district, String neighborhood, int offset, int limit);

    Long countCompletedMissionsInRegion(Long userId, String city, String district, String neighborhood);

    Long countTotalMissionsInRegion(String city, String district, String neighborhood);
}