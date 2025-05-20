package umc.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionRepository.MissionRepository;

@Component
@RequiredArgsConstructor
public class StoreInMissionValidator implements ConstraintValidator<ValidStoreInMission, Integer> {

    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(Integer missionId, ConstraintValidatorContext context) {
        if (missionId == null) return false;

        return missionRepository.findById(missionId)
                .map(mission -> mission.getStore() != null)
                .orElse(false);
    }
}