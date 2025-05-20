package umc.spring.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.converter.MissionExistenceChecker;

@Component
@RequiredArgsConstructor
public class MissionExistsValidator implements ConstraintValidator<ExistsMission, Integer> {

    private final MissionExistenceChecker checker;

    @Override
    public boolean isValid(Integer missionId, ConstraintValidatorContext context) {
        return missionId != null && checker.exists(missionId);
    }
}