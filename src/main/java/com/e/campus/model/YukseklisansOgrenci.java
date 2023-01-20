package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class YukseklisansOgrenci {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;
    private LocalDateTime dob;
    private LocalDateTime registerAt;
    private String semester;

    @ManyToMany
    @JoinTable(name = "yuksek_course_student",
            joinColumns = @JoinColumn(name = "yukseklisans_ogrenci_id"),
            inverseJoinColumns = @JoinColumn(name = "yuksek_course_id"))
    private List<YuksekCourse> yuksekCourses;

    public YukseklisansOgrenci(String name, String surname, LocalDateTime dob, LocalDateTime registerAt, String semester) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.registerAt = registerAt;
        this.semester = semester;
    }

    public YukseklisansOgrenci() {

    }

    public Object getYukOgrenciType() {

        return null;
    }
}
