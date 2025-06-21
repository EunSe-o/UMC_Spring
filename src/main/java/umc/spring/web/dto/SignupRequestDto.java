package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.spring.domain.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {
    @NotBlank
    private String uname;

    @NotBlank
    private String upassword;

    private Gender gender;
    private String address;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
}
