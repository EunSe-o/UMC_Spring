package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserInfo;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUname(String uname);
}