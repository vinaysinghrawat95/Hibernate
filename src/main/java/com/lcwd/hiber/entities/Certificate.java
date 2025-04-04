package com.lcwd.hiber.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_certificates")
public class Certificate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateId;

    private String certificateName;

    private String link;

    private String about;

    public long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(long certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
