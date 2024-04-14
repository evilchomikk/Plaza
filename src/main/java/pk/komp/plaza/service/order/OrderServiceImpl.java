package pk.komp.plaza.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pk.komp.plaza.mapper.OrderMapper;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    @Override
    public List<OrderDto> getOrdersByCity(String cityName) {
        return orderRepository.findAllByidCity_cityName(cityName).stream().map(orderMapper::toDto).toList();
    }
}
