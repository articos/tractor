package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Client {
    @Id
    @SequenceGenerator(name = "CUSTOMER_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_GENERATOR")
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String ico;

    private Date registrationDate;

    private String email;

    private String telephone;

}
