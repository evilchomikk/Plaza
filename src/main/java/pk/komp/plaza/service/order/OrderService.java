package pk.komp.plaza.service.order;

import pk.komp.plaza.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByCity(String cityName);
}
