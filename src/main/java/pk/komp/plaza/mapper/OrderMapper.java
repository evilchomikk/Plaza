package pk.komp.plaza.mapper;

import org.mapstruct.*;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.City;
import pk.komp.plaza.model.entity.Order;

import java.time.Duration;
import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    default OrderDto toDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getIdCity().getCityName(),
                order.getIdStatuses().getStatusesName(),
                order.getIdOrdermaker(),
                order.getIdOrdertaker(),
                order.getIdOrdertype().getOrdertypeName(),
                mapToDuration(order.getStartDateOrder(), order.getEndDateOrder()),
                order.getValue(),
                order.getIsActive()

        );
    }

    default String mapToDuration(Instant startDate, Instant endDate) {
        Duration duration = Duration.between(startDate, endDate);
        long totalHours = duration.toHours();
        long remainingMinutes = duration.minusHours(totalHours).toMinutes();
        return totalHours + " hours, " + remainingMinutes + " minutes";
    }

}
