package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="Lending")
public class Lend {

    @Id
    @SequenceGenerator(name = "LEND_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEND_ID_GENERATOR")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date_from")
    private Date from;

    @Temporal(TemporalType.DATE)
    @Column(name="date_to")
    private Date to;

    private BigDecimal price;
    private Double lattitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "CAR", referencedColumnName = "Id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "car_client", referencedColumnName = "Id")
    private Client client;
}
