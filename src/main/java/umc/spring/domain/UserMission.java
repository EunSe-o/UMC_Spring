package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
/**
 * 유저-미션 진행 관계 엔티티
 */
@Entity
@Table(name = "user_mission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userMissionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('new','completed','progress') DEFAULT 'new'")
    private MissionStatus status = MissionStatus.new_;
}