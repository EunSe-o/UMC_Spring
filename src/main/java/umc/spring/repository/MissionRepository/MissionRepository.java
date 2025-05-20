package umc.spring.repository.MissionRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer>, MissionRepositoryCustom {
    // 기본 JPA 메서드 + 커스텀 쿼리 사용 가능
}
