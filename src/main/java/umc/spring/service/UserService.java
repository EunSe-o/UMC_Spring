package umc.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.domain.UDelete;
import umc.spring.domain.UserInfo;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.SignupRequestDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequestDto dto) {
        try {
            if (userRepository.findByUname(dto.getUname()).isPresent()) {
                throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
            }

            System.out.println("== 엔티티 빌드 시작 ==");

            UserInfo user = UserInfo.builder()
                    .uname(dto.getUname())
                    .upassword(passwordEncoder.encode(dto.getUpassword()))
                    .gender(dto.getGender())
                    .address(dto.getAddress())
                    .birthYear(dto.getBirthYear())
                    .birthMonth(dto.getBirthMonth())
                    .birthDay(dto.getBirthDay())
                    .udelete(UDelete.Active)
                    .build();

            System.out.println("== 저장 직전 ==");
            userRepository.save(user);
            System.out.println("== 저장 완료 ==");

        } catch (Exception e) {
            System.out.println("== 예외 발생! ==");
            e.printStackTrace();
        }
    }
}