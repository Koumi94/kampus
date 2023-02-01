package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
@Data
@AllArgsConstructor

public  class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<Bolum> bolums;



    public Faculty(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bolum> getBolums(Bolum bolum) {
        return bolums;
    }



    public Faculty() {

    }


    public void addStudent(Ogrenci ogrenci) {
    }


}
