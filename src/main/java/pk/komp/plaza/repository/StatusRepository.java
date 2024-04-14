package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.komp.plaza.model.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}