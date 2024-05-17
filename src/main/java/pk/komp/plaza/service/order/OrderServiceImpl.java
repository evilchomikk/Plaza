package pk.komp.plaza.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pk.komp.plaza.mapper.OrderMapper;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.Order;
import pk.komp.plaza.model.entity.User;
import pk.komp.plaza.repository.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;
    private final CityRepository cityRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final OrderTypeRepository orderTypeRepository;

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

    @Override
    public void addOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setIdCity(cityRepository.findByCityName(orderDto.getCityName()).getFirst());
        order.setIdOrdertype(orderTypeRepository.findByOrdertypeName(orderDto.getOrderTypeName()).getFirst());
        order.setValue(orderDto.getValue());
        order.setStartDateOrder(Instant.now()); // Use Instant.now() to get the current date and time
        // Calculate end date based on duration
        Duration duration = Duration.parse(orderDto.getDuration());
        Instant endDate = Instant.now().plus(duration);
        order.setEndDateOrder(endDate);
        order.setIdOrdertaker(null);
        order.setIdOrdermaker(userRepository.findById(1L).get());
        order.setIdStatuses(statusRepository.findById(3).get());
        order.setIsActive((short) 1);
        orderRepository.save(order);
    }

    @Override
    public void addOrderWithLocation(OrderDto orderDto, BigDecimal x, BigDecimal y) {
        Order order = new Order();
        order.setIdCity(cityRepository.findByCityName(orderDto.getCityName()).getFirst());
        order.setIdOrdertype(orderTypeRepository.findByOrdertypeName(orderDto.getOrderTypeName()).getFirst());
        order.setValue(orderDto.getValue());
        order.setStartDateOrder(Instant.now()); // Use Instant.now() to get the current date and time
        // Calculate end date based on duration
        Duration duration = Duration.parse(orderDto.getDuration());
        Instant endDate = Instant.now().plus(duration);
        order.setEndDateOrder(endDate);
        order.setIdOrdertaker(null);
        order.setIdOrdermaker(userRepository.findById(1L).get());
        order.setIdStatuses(statusRepository.findById(3).get());
        order.setIsActive((short) 1);
        order.setX(x);
        order.setY(y);
        orderRepository.save(order);
    }


}
