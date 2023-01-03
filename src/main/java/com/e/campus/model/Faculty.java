package com.e.campus.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Faculty {
    private @Id
    @GeneratedValue long id;
    private String name;
    private LocalDateTime createAt;


    public Faculty(String name) {

        this.name = name;
        this.createAt = LocalDateTime.now();


    }
}
