package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;

import java.util.List;

import static umc.spring.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QUserMission userMission = QUserMission.userMission;

    /**
     * 동적 조건 쿼리
     */
    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(String name, String city) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null && !name.isEmpty()) {
            predicate.and(mission.missionName.containsIgnoreCase(name));
        }

        if (city != null && !city.isEmpty()) {
            predicate.and(store.city.eq(city));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }

    /**
     * 특정 유저의 진행/완료 미션 조회 (페이징)
     */
    @Override
    public List<Mission> findMissionsByUserAndStatus(Long userId, MissionStatus status, int offset, int limit) {
        return jpaQueryFactory
                .select(mission)
                .from(userMission)
                .join(userMission.mission, mission)
                .where(
                        userMission.user.uid.eq(userId.intValue()), // uid가 Integer인 경우
                        userMission.status.eq(status)
                )
                .orderBy(mission.missionId.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    /**
     * 도전 가능한 미션 목록 조회 (홈화면용, 페이징)
     */
    @Override
    public List<Mission> findNewMissionsInRegion(String city, String district, String neighborhood, int offset, int limit) {
        return jpaQueryFactory
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

    /**
     * 특정 지역에서 유저가 완료한 미션 개수
     */
    @Override
    public Long countCompletedMissionsInRegion(Long userId, String city, String district, String neighborhood) {
        return jpaQueryFactory
                .select(userMission.count())
                .from(userMission)
                .join(userMission.mission, mission)
                .where(
                        userMission.user.uid.eq(userId.intValue()),
                        userMission.status.eq(MissionStatus.completed),
                        store.city.eq(city),
                        store.district.eq(district),
                        store.neighborhood.eq(neighborhood)
                )
                .fetchOne();
    }

    /**
     * 특정 지역의 전체 미션 개수
     */
    @Override
    public Long countTotalMissionsInRegion(String city, String district, String neighborhood) {
        return jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .where(
                        store.city.eq(city),
                        store.district.eq(district),
                        store.neighborhood.eq(neighborhood)
                )
                .fetchOne();
    }
}