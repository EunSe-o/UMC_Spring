package umc.spring.domain;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
import umc.spring.domain.UDelete;
import umc.spring.domain.Gender;

/**
 * 유저 정보 엔티티
 */
@Entity
@Table(name = "userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false, length = 50)
    private String upassword;

    @Column(nullable = false, length = 40)
    private String uname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Active','delete') DEFAULT 'Active'")
    private UDelete udelete = UDelete.Active;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private Integer birthYear;

    @Column(nullable = false)
    private Integer birthMonth;

    @Column(nullable = false)
    private Integer birthDay;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFood> userFoods;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> missions;
}