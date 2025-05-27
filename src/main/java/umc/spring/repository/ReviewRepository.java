package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Page<Review> findAllByUser_Uid(Long userId, Pageable pageable);
}