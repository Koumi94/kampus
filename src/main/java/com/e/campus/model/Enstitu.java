package com.e.campus.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Enstitu {

    private @Id
    @GeneratedValue long id ;
    private String name;
    private LocalDateTime createAt;

    public Enstitu(String name) {

        this.name = name;
        this.createAt = LocalDateTime.now();


    }
}
