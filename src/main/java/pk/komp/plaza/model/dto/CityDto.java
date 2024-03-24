package pk.komp.plaza.model.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link pk.komp.plaza.model.entity.City}
 */
@Value
public class CityDto implements Serializable {
    String cityName;
    BigDecimal latitude;
    BigDecimal longitude;
}