package pk.komp.plaza.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.service.order.OrderService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getOrdersByCity/{cityName}")
    public ResponseEntity<List<OrderDto>> getOrdersByCity(@PathVariable String cityName) {
        return ResponseEntity.ok(orderService.getOrdersByCity(cityName));
    }

    @PostMapping("/acceptOrder/{orderId}")
    public ResponseEntity<Void> acceptOrder(@PathVariable int orderId) {
        orderService.acceptOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Void> addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addOrderWithLocation")
    public ResponseEntity<Void> addOrderWithLocation(@RequestBody OrderDto orderDto) {
        orderService.addOrderWithLocation(orderDto);
        return ResponseEntity.ok().build();
    }

}
