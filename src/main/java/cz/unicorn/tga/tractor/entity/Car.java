package cz.unicorn.tga.tractor.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import cz.unicorn.tga.tractor.model.enumeration.CarsType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author DZCJS9F
 */
@Entity
@Data
@ToString
public class Car {

    @Id
    @SequenceGenerator(name = "CAR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_ID_GENERATOR")
    private Long id;

    @Column(name = "cars_type")
    @Enumerated(EnumType.STRING)
    private CarsType type;

    private String vin;

    @Column(name = "state_type")
    @Enumerated(EnumType.STRING)
    private CarState carState;

    @Column(name = "date_of_acquisition")
    private Date dateOfAcquisition;

    @Column(name = "last_control")
    private Date dateOfLastTechnicalCheck;

    private BigDecimal price;

    @OneToMany(mappedBy = "car")
    private Set<Stk> stks;


}
