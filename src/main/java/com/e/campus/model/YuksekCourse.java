package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class YuksekCourse {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Integer yuksekCourseNum;

    private LocalDateTime createAt;

    @ManyToMany(mappedBy = "yuksekCourses")
    private List<YukseklisansOgrenci> yukseklisansOgrencis;

    public YuksekCourse(String name, Integer yuksekCourseNum) {
        this.name = name;
        this.yuksekCourseNum = yuksekCourseNum;
        this.createAt = LocalDateTime.now();
    }

    public YuksekCourse() {

    }
}
