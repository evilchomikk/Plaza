package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.komp.plaza.model.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}