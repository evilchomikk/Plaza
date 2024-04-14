package pk.komp.plaza.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
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
public class OrderDto {
    CityDto idCity;
    StatusDto idStatuses;
    User idOrdermaker;
    User idOrdertaker;
    OrderTypeDto idOrdertype;
    String duration;
    BigDecimal value;
    Short isActive;
}