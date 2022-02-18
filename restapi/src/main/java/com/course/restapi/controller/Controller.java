package com.course.restapi.controller;

import com.course.restapi.entities.Course;
import com.course.restapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome";
    }

    //Get the Course
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //Get Course by CourseID
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //Adding New Course
    @PostMapping("/new-course")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);

    }

    @PutMapping("/update-course")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);

    }

    @DeleteMapping("/delete-course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
