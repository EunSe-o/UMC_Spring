package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
import umc.spring.domain.UserInfo;
import umc.spring.domain.Mission;
/**
 * 리뷰 엔티티
 */
@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(columnDefinition = "TEXT")
    private String reviewText;

    @Column(nullable = false)
    private Integer score;
}
