package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.komp.plaza.model.entity.Order;

import java.util.Collection;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Collection<Order> findAllByidCity_cityName(String cityName);
}