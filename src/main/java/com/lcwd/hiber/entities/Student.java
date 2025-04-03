package com.lcwd.hiber.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
        //field
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto-increment & generate random id
        private long id;

        @Column(name = "student_name",length = 100,nullable = true)
        private String name;

        @Column(name = "student_collage",length = 200,nullable = true)
        private String collage;

        private String phone;

        private String fatherName;

        private boolean activeStatus = true;

        @Lob  //@Lob is use for large object, where we can't know how much size of the object
        private String about;





}
