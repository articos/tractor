package cz.unicorn.tga.tractor.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable{
    private Long id;

    private String name;

    private String address;

    private Integer ico;

    private String email;

    private String telephone;
}
