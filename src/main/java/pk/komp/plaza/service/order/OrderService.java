package pk.komp.plaza.service.order;

import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.Order;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByCity(String cityName);
    void acceptOrder(int orderId);
    void rejectOrder(int orderId);
    void addOrder(OrderDto orderDto);
}
