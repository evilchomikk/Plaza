package pk.komp.plaza.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Projection for {@link pk.komp.plaza.model.entity.Status}
 */

@Getter
@Setter
@Builder
public class StatusDto {
    String statusesName;
}