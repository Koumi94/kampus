
package com.e.campus.model;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "course")
@AllArgsConstructor
public class Course {

     @Id
    @GeneratedValue private long id;

    private String name;
    private Integer courseNum;

    @GeneratedValue private LocalDateTime createAt;

    public Course(String name, Integer courseNum ) {
        this.name = name;
        this.courseNum = courseNum;
        this.createAt = LocalDateTime.now();
    }

    public Course() {

    }
}
