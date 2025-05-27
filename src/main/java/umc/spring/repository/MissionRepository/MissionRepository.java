package umc.spring.repository.MissionRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer>, MissionRepositoryCustom {
    Page<Mission> findAllByStore_StoreId(Integer storeId, Pageable pageable);
}
