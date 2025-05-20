package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;

public record StoreRequestDto(
        @NotBlank(message = "가게 이름은 필수입니다.") String name,
        @NotBlank(message = "주소는 필수입니다.") String address,
        @NotBlank(message = "시 정보는 필수입니다.") String city,
        @NotBlank(message = "구 정보는 필수입니다.") String district,
        @NotBlank(message = "동 정보는 필수입니다.") String neighborhood
) {}