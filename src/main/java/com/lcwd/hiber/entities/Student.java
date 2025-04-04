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


        /* All Getter and Setter */

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCollage() {
                return collage;
        }

        public void setCollage(String collage) {
                this.collage = collage;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getFatherName() {
                return fatherName;
        }

        public void setFatherName(String fatherName) {
                this.fatherName = fatherName;
        }

        public boolean getActiveStatus() {
                return activeStatus;
        }

        public void setActiveStatus(boolean activeStatus) {
                this.activeStatus = activeStatus;
        }

        public String getAbout() {
                return about;
        }

        public void setAbout(String about) {
                this.about = about;
        }
}
