package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name="car_client")
public class Client {

    @Id
    @SequenceGenerator(name = "CLIENT_ID_GENERATOR", sequenceName =  "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_GENERATOR")
    private Long id;

    private String name;
    private String surname;
    private String ico;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private Date registrationDate;

    private String email;

    @Column(name="ceil_phone")
    private String ceilPhone;

}
