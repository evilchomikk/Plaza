package pk.komp.plaza.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.*;

import java.time.Duration;
import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);

    @Mappings({
            @Mapping(target = "idCity", source = "order.idCity"),
    })
    OrderDto toDto(Order order);

    @AfterMapping
    default void calculateDuration(Order order, @MappingTarget OrderDto orderDto) {
        Instant startDate = order.getStartDateOrder();
        Instant endDate = order.getEndDateOrder();
        orderDto.setDuration(mapToDuration(startDate, endDate));
    }

    default String mapToDuration(Instant startDate, Instant endDate) {
        Duration duration = Duration.between(startDate, endDate);

        long totalHours = duration.toHours();
        long remainingMinutes = duration.minusHours(totalHours).toMinutes();

        return totalHours + " hours, " + remainingMinutes + " minutes";
    }
}