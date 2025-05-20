package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.StoreService;
import umc.spring.web.dto.StoreRequestDto;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> createStore(@Valid @RequestBody StoreRequestDto dto) {
        Long storeId = storeService.createStore(dto);
        return ResponseEntity.ok(Map.of("storeId", storeId));
    }
}
