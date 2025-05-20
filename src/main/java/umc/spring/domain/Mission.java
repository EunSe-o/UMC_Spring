package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
/**
 * 미션 엔티티
 */
@Entity
@Table(name = "mission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missionId;

    @Column(nullable = false, length = 50)
    private String missionName;

    @Column(columnDefinition = "TEXT")
    private String missionDes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('new','completed','progress') DEFAULT 'new'")
    private MissionStatus status = MissionStatus.new_;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissions;
}