package com.course.restapi.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;


/*public Course(long id, String title, String description){
        super();
        this.id = id;
        this.title = title;
        this.description = description;

    }*/


}
