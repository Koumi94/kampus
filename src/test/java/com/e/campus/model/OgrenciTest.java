package com.e.campus.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class OgrenciTest {

    @Test
    public void testOgrenciCreation() {
        Ogrenci ogrenci = new Ogrenci("yassine", 12345, "123-456-7890", "yassine@test.com");
        assertNotNull(ogrenci);
    }

    @Test
    public void testOgrenciIdentity() {
        Ogrenci ogrenci = new Ogrenci("yassine", 12345, "123-456-7890", "yassine@test.com");
        assertEquals(12345, ogrenci.getOgrenciIdentity(12345));
    }

    @Test
    public void testOgrenciCreateAt() {
        Ogrenci ogrenci = new Ogrenci("yassine", 12345, "123-456-7890", "yassine@test.com");
        assertEquals(LocalDateTime.now().getDayOfYear(), ogrenci.getCreateAt().getDayOfYear());
    }

    @Test
    public void testAddCourse() {
        Ogrenci ogrenci = new Ogrenci("yassine", 12345, "123-456-7890", "yassine@test.com");
        Course course = new Course("Math 101");
        ogrenci.addCourse(course);
        assertEquals(1, ogrenci.getCourses().size());
    }

    @Test
    public void testRemoveCourse() {
        Ogrenci ogrenci = new Ogrenci("yassine", 12345, "123-456-7890", "yassine@test.com");
        Course course1 = new Course("Math 101");
        Course course2 = new Course("Science 101");
        ogrenci.addCourse(course1);
        ogrenci.addCourse(course2);
        ogrenci.removeCourse(course1);
        assertEquals(1, ogrenci.getCourses().size());
    }
}

