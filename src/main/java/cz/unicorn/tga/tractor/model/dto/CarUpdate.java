package cz.unicorn.tga.tractor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdate {

    private Long id;
    private String type;
    private String vin;
    private String carState;
    private Date dateOfAcquisition;
    private Date dateOfLastTechnicalCheck;
    private BigDecimal price;

}
