package umc.spring.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtLoginRequestDto {
    private String uname;
    private String upassword;
}
