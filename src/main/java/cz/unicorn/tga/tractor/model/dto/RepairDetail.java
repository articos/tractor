package cz.unicorn.tga.tractor.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepairDetail {

    private Long id;
    private Long carId;
    private BigDecimal price;
    private String repairResolution;
}
