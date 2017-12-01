package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "car_stk")
public class Stk {


    @Id
    @SequenceGenerator(name = "STK_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STK_ID_GENERATOR")
    Long id;

    @ManyToOne
    @JoinColumn(name = "CAR", referencedColumnName = "Id")
    Car car;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_date")
    Date checkDate;

    @Column(name = "is_pass")
    boolean passed;

}
