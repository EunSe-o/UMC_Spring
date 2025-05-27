package umc.spring.domain;

import lombok.Builder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;

    private String address;

    private String city;
    private String district;
    private String neighborhood;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missions;
}
