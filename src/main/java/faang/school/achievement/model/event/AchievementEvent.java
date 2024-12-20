package faang.school.achievement.model.event;

import lombok.Builder;

@Builder
public record AchievementEvent(
        long userId,
        long achievementId,
        String title
) {
}
