package umc.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Store;
import umc.spring.global.exception.CustomException;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDto;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Long createStore(StoreRequestDto dto) {
        if (storeRepository.existsByStoreNameAndAddress(dto.name(), dto.address())) {
            throw new CustomException("이미 같은 이름과 주소의 가게가 존재합니다.");
        }

        Store store = Store.builder()
                .storeName(dto.name())
                .address(dto.address())
                .city(dto.city())
                .district(dto.district())
                .neighborhood(dto.neighborhood())
                .build();

        storeRepository.save(store);
        return store.getStoreId();
    }
}