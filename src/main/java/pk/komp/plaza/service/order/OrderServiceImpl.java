package pk.komp.plaza.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pk.komp.plaza.mapper.OrderMapper;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.User;
import pk.komp.plaza.repository.OrderRepository;
import pk.komp.plaza.repository.StatusRepository;
import pk.komp.plaza.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    @Override
    public List<OrderDto> getOrdersByCity(String cityName) {
        return orderRepository.findAllByidCity_cityName(cityName).stream().map(orderMapper::toDto).toList();
    }

    @Override
    public void acceptOrder(int orderId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.setIdStatuses(statusRepository.findById(1).get());
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            System.out.println(username);
            order.setIdOrdertaker(userRepository.findById(1L).get());
            userRepository.save(order.getIdOrdertaker());
            orderRepository.save(order);
        });

    }

    @Override
    public void rejectOrder(int orderId) {

        orderRepository.findById(orderId).ifPresent(order -> {
            order.setIdStatuses(statusRepository.findById(2).get());

            orderRepository.save(order);
        });
    }
}
