package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.komp.plaza.model.entity.OrderType;

public interface OrderTypeRepository extends JpaRepository<OrderType, Integer> {
}