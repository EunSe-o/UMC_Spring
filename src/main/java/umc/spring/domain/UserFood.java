package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
/**
 * 유저-음식 관계 엔티티
 */
@Entity
@Table(name = "user_food")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userFootId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
}
