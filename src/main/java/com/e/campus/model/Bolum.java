package com.e.campus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Bolum {

    private @Id
    @GeneratedValue long id;

    private LocalDateTime createAt;

    private String name;

    public Bolum(String name) {

        this.name = name;
        this.createAt = LocalDateTime.now();


    }
}
