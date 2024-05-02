package pk.komp.plaza.model.dto;

import lombok.*;
import pk.komp.plaza.model.entity.City;
import pk.komp.plaza.model.entity.Status;
import pk.komp.plaza.model.entity.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

/**
 * DTO for {@link pk.komp.plaza.model.entity.Order}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    int id;
    String cityName;
    String statusName;
    User idOrdermaker;
    User idOrdertaker;
    String orderTypeName;
    String duration;
    BigDecimal value;
    Short isActive;
}