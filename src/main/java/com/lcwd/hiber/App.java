package com.lcwd.hiber;

import com.lcwd.hiber.entities.Certificate;
import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 **/

public class App 
{
    public static void main( String[] args )
    {
        //create student object
        Student student = new Student();

        student.setName("Vinay Singh Rawat");
        student.setCollage("Quantum University");
        student.setFatherName("Mr.Vikram Singh Rawat");
        student.setPhone("123456789");
        student.setActiveStatus(true);
        student.setAbout("I am a student");

        Certificate certificate = new Certificate();
        certificate.setAbout("Hey this is my carrier goals");
        certificate.setCertificateName("App Developer");
        certificate.setLink("www.mycertificate.com");



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try
        {
            transaction = session.beginTransaction();
            session.persist(student);
            session.persist(certificate);
            transaction.commit();
            System.out.println("Student saved successfully");

        }catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            else
            {
                e.printStackTrace();
            }
        }finally
        {
            session.close();
        }


    }
}
