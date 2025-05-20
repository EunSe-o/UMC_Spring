package umc.spring.repository.MissionRepository.Query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;
import umc.spring.domain.QUserMission;
import umc.spring.domain.MissionStatus;

import java.util.List;

import static umc.spring.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class MissionQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Mission> findMissionsByUserAndStatus(Integer userId, MissionStatus status, int offset, int limit) {
        QUserMission userMission = QUserMission.userMission;
        QMission mission = QMission.mission;

        return queryFactory
                .select(mission)
                .from(userMission)
                .join(userMission.mission, mission)
                .where(
                        userMission.user.uid.eq(userId),
                        userMission.status.eq(status)
                )
                .orderBy(mission.missionId.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }


    // 1. 완료한 미션 개수 (특정 지역)
    public Long countCompletedMissionsInRegion(Integer userId, String city, String district, String neighborhood) {
        QUserMission userMission = QUserMission.userMission;
        QMission mission = QMission.mission;

        return queryFactory
                .select(userMission.count())
                .from(userMission)
                .join(userMission.mission, mission)
                .where(
                        userMission.user.uid.eq(userId),
                        userMission.status.eq(MissionStatus.completed),
                        store.city.eq(city),
                        store.district.eq(district),
                        store.neighborhood.eq(neighborhood)
                )
                .fetchOne();
    }

    // 2. 전체 미션 개수 (특정 지역)
    public Long countTotalMissionsInRegion(String city, String district, String neighborhood) {
        QMission mission = QMission.mission;

        return queryFactory
                .select(mission.count())
                .from(mission)
                .where(
                        store.city.eq(city),
                        store.district.eq(district),
                        store.neighborhood.eq(neighborhood)
                )
                .fetchOne();
    }

    // 3. 도전 가능한 미션 목록 (status = 'new', 페이징)
    public List<Mission> findNewMissionsInRegion(String city, String district, String neighborhood, int offset, int limit) {
        QMission mission = QMission.mission;

        return queryFactory
                .selectFrom(mission)
                .where(
                        store.city.eq(city),
                        store.district.eq(district),
                        store.neighborhood.eq(neighborhood),
                        mission.status.eq(MissionStatus.new_)
                )
                .orderBy(mission.missionId.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}