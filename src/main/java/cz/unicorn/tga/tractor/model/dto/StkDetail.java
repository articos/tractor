package cz.unicorn.tga.tractor.model.dto;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StkDetail {

    Long id;
    Long carId;
    Date checkDate;
    boolean passed;
}
