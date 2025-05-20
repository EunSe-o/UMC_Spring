package umc.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.converter.UserMissionDuplicateChecker;


@Component
@RequiredArgsConstructor
public class MissionNotChallengedValidator implements ConstraintValidator<ExistsMissionNotChallenged, Integer> {

    private final UserMissionDuplicateChecker checker;

    @Override
    public boolean isValid(Integer missionId, ConstraintValidatorContext context) {
        return checker.isNotChallenged(1, missionId);
    }
}