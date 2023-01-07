package com.e.campus.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer identity;

    private String tel;

    private String email;
    private LocalDateTime createAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OgrenciIsleri_id")

    private Ogrenci ogrenci;



    public Ogrenci (String name, Integer identity,String tel, String email){
        this.name = name;
        this.identity = identity;
        this.tel = tel;
        this.email = email;
        this.createAt = LocalDateTime.now();
    }




    public Integer getOgrenciIdentity(Integer identity) {
        this.identity = identity;
        return identity;
    };


}
