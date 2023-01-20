package com.e.campus.service;

import com.e.campus.model.Course;
import com.e.campus.model.YuksekCourse;
import com.e.campus.repository.CourseRepository;
import com.e.campus.repository.YukCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class YuksekCourseService {
    @Autowired
    private YukCourseRepository yukCourseRepository;
    public List<YuksekCourse> getAllYukCourse() {
        return yukCourseRepository.findAll();
    }

    public Optional<YuksekCourse> getYukCourseById(Long id) {
        return yukCourseRepository.findById(id);
    }

    public YuksekCourse addYukCourse(YuksekCourse yuksekCourse) {
        return yukCourseRepository.save(yuksekCourse);
    }

    public YuksekCourse updateYukCourse(Long id, YuksekCourse yuksekCourse) {
        return yukCourseRepository.save(yuksekCourse);
    }

    public void deleteYukCourse(Long id){
        yukCourseRepository.deleteById(id);
    };
}
