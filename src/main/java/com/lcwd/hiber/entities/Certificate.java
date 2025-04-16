package com.lcwd.hiber.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Changed to 'id' for consistency

    @Column(nullable = false)
    private String certificateName;

    private String link;

    private String about;

    @ManyToOne
    @JoinColumn(name = "Student_Id")
    private Student student;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
