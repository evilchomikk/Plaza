package pk.komp.plaza.mapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.*;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderMapperTest {

    private final OrderMapper orderMapper = new OrderMapperImpl();

    @BeforeAll
    static void setUp() {

    }

    @Test
    void testToDto_withValidOrder_returnsOrderDto() {
        // Given
        Order order = new Order();
        order.setId(1);

        City city = new City();
        city.setCityName("New York");
        order.setIdCity(city);

        Status status = new Status();
        status.setStatusesName("Confirmed");
        order.setIdStatuses(status);

        User orderMaker = new User();
        orderMaker.setUsername("John Doe");
        order.setIdOrdermaker(orderMaker);

        User orderTaker = new User();
        orderTaker.setUsername("Jane Doe");
        order.setIdOrdertaker(orderTaker);

        OrderType orderType = new OrderType();
        orderType.setOrdertypeName("Delivery");
        order.setIdOrdertype(orderType);

        Instant startDate = Instant.parse("2024-05-16T08:00:00Z");
        Instant endDate = Instant.parse("2024-05-16T10:30:00Z");
        order.setStartDateOrder(startDate);
        order.setEndDateOrder(endDate);

        order.setValue(BigDecimal.valueOf(100.00));
        order.setIsActive((short) 1);

        // When
        OrderDto orderDto = orderMapper.toDto(order);  

        // Then
        assertNotNull(orderDto);
        assertEquals(1L, orderDto.getId());
        assertEquals("New York", orderDto.getCityName());
        assertEquals("Confirmed", orderDto.getStatusName());
        assertEquals("John Doe", orderDto.getIdOrdermaker().getUsername());
        assertEquals("Jane Doe", orderDto.getIdOrdertaker().getUsername());
        assertEquals("Delivery", orderDto.getOrderTypeName());
        assertEquals("2 hours, 30 minutes", orderDto.getDuration());
        assertEquals(BigDecimal.valueOf(100.00), orderDto.getValue());
        //assertEquals(orderDto.getIsActive());
    }


    @Test
    void testMapToDuration_withEndBeforeStart_returnsNegativeDuration() {
        // Given
        Instant startDate = Instant.parse("2024-05-16T10:30:00Z");
        Instant endDate = Instant.parse("2024-05-16T08:00:00Z");

        // When
        String duration = orderMapper.mapToDuration(startDate, endDate);

        // Then
        assertEquals("-2 hours, -30 minutes", duration);
    }
}