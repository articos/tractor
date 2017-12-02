package cz.unicorn.tga.tractor.model.lend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LendDetail {

    private Long id;
    private Date from;
    private Date to;
    private Long carId;
    private String vin;
    private BigDecimal price;
    private Double lattitude;
    private Double longitude;
    private String clientName;
    private Long clientId;

}
