package com.nology.coursesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoursesService {
    @Autowired
    private CoursesRepository repo;

    public List<Course> listAll(){
        return repo.findAll();
    }

    public Course getCourse(int id) { return repo.findById(id).get(); }

    public void addCourse(Course newCourse) { repo.save(newCourse); }

    public void removeCourse(int courseId) { repo.deleteById(courseId); }


}
