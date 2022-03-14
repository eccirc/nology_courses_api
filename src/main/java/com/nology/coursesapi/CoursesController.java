package com.nology.coursesapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class CoursesController {

    @Autowired
    private CoursesService serv;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> listCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(serv.listAll());
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> get(@PathVariable Integer id){
        try {
            Course course = serv.getCourse(id);
            return ResponseEntity.status(HttpStatus.OK).body(course);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/courses")
    public ResponseEntity<String> add(@RequestBody Course course){
        serv.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("New course " + course.getCourseName() + " added!");
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            serv.removeCourse(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Record deleted");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such record with that ID!");
        }


    }
}
