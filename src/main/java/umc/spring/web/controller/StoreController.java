package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.MissionService;
import umc.spring.service.StoreService;
import umc.spring.validation.CustomPage;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.StoreRequestDto;

import java.util.List;
import java.util.Map;

@Tag(name = "가게 API")
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

        private final MissionService missionService;

        @Operation(summary = "특정 가게의 미션 목록 조회")
        @GetMapping("/{storeId}/missions")
        public ResponseEntity<List<MissionResponseDto>> getMissions(
                @PathVariable Integer storeId,
                @Parameter(description = "1부터 시작하는 페이지 번호") @CustomPage Integer page) {

            List<MissionResponseDto> result = missionService.getMissionsByStore(storeId, page);
            return ResponseEntity.ok(result);
        }

}
