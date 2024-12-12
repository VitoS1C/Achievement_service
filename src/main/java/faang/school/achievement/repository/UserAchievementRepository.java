package faang.school.achievement.repository;

import faang.school.achievement.model.entity.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {

    @Query(value = """
                    SELECT CASE WHEN COUNT(ua) > 0 THEN true ELSE false END
                    FROM UserAchievement ua
                    WHERE ua.userId = :userId AND ua.achievement.id = :achievementId
            """)
    boolean existsByUserIdAndAchievementId(long userId, long achievementId);

    List<UserAchievement> findByUserId(long userId);
}