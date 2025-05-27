package umc.spring.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.*;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.*;

@Component
@RequiredArgsConstructor
public class TestData {
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @PostConstruct
    public void init() {
        // 유저 더미
        if (userRepository.findById(1).isEmpty()) {
            UserInfo user = UserInfo.builder()
                    .uname("테스트유저")
                    .udelete(UDelete.Active)
                    .address("서울시 영등포구 영중동")
                    .birthYear(2000)
                    .birthMonth(5)
                    .birthDay(22)
                    .gender(Gender.여자)
                    .upassword("test1234")  // 이 값도 컬럼에 따라 추가
                    .build();
            userRepository.save(user);
        }

        // 가게 더미
        Store store = storeRepository.save(Store.builder()
                .storeName("테스트 가게")
                .address("서울시 영등포구 영중동 123")
                .city("서울시")
                .district("영등포구")
                .neighborhood("영중동")
                .build());

        System.out.println("가게 생성 완료 (ID: " + store.getStoreId() + ")");

        // 미션 더미
        if (missionRepository.findById(1).isEmpty()) {
            Mission mission = Mission.builder()
                    .missionName("첫 번째 미션")
                    .missionDes("Postman 테스트용 미션입니다")
                    .status(MissionStatus.new_)
                    .store(store)
                    .build();
            missionRepository.save(mission);
            System.out.println("하드코딩 미션 생성 완료");
        }
    }
}
