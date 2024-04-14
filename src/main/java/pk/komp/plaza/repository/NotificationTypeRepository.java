package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.komp.plaza.model.entity.NotificationType;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Integer> {
}