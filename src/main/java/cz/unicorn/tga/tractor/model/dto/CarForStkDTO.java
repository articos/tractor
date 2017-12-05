package cz.unicorn.tga.tractor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarForStkDTO {

    private Date checkDate;
    private Long id;
    private String vin;
    private String type;
    private String carState;



}
