package umc.spring.repository;

import umc.spring.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByStoreNameAndAddress(String storeName, String address);
}