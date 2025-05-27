package umc.spring.web.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewResponseDto {

    private final Long id;
    private final String content;
    private final String storeName;

    @Builder
    public ReviewResponseDto(Long id, String content, String storeName) {
        this.id = id;
        this.content = content;
        this.storeName = storeName;
    }
}