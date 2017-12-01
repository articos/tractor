package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "car_repair")
public class Repair {


    @Id
    @SequenceGenerator(name = "CAR_REPAIR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_REPAIR_ID_GENERATOR")
    Long id;

    @ManyToOne
    @JoinColumn(name = "CAR", referencedColumnName = "Id")
    Car car;

    BigDecimal price;

    @Column(name = "repair_resolution")
    String repairResolution;


}
