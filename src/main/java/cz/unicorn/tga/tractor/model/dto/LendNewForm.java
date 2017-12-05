/**
 *
 */
package cz.unicorn.tga.tractor.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.*;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LendNewForm {

    private Long id;
    private Date from;
    private Date to;
    private Long carId;
    private BigDecimal price;
    private Double lattitude;
    private Double longitude;
    private Long clientId;

}
