package com.e.campus.model;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name ="bolum")
@Data
@AllArgsConstructor
public class Bolum {

    private @Id
    @GeneratedValue long id;
    private String name;
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name ="faculty_id")
    private Faculty faculty;
    public Bolum(String name) {
        this.name = name;
        this.createAt = LocalDateTime.now();
    }

    public Bolum() {

    }


    public void setFaculty(Faculty faculty) {
    }


    public void addCourse(Course course) {
    }
}
