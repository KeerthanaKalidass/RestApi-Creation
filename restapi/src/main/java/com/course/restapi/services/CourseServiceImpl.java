package com.course.restapi.services;

import com.course.restapi.dao.CourseDao;
import com.course.restapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

   /* List<Course> list;*/


    public CourseServiceImpl() {
       /* list = new ArrayList<>();
        list.add(new Course(123, "Java ", "Java Course"));
        list.add(new Course(124, "Angular ", "Angular Course"));
        list.add(new Course(125, "AWS ", "AWS Course"));*/
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        /*Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;

            }
        }*/


        return courseDao.getById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        //list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        /*boolean resourceFound=false;
        for(Course currentCourse: list) {
            if(currentCourse.getId()==course.getId()){
                resourceFound=true;
                currentCourse.setId(course.getId());
                currentCourse.setTitle(course.getTitle());
                currentCourse.setDescription(course.getDescription());
            }
        }
        if(!resourceFound) {
            list.add(course);
            return course;
        }
*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {

        /*for (Course course : list) {
            if (course.getId() == courseId) {
                list.remove(course);
                break;

            }
        }*/
        Course entity = courseDao.getById(courseId);
        courseDao.delete(entity);


    }
}



