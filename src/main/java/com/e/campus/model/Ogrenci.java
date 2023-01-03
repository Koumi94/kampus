package com.e.campus.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer identity;

    private String tel;

    private String email;
}
