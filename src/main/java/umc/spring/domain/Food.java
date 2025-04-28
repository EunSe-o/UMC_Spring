package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

/**
 * 좋아하는 음식 엔티티
 */
@Entity
@Table(name = "food")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(nullable = false, unique = true, length = 20)
    private String foodName;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<UserFood> userFoods;
}
