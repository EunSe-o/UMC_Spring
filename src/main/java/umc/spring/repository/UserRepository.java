package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
}