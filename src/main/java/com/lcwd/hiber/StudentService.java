package com.lcwd.hiber;

import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.sql.SQLOutput;

public class StudentService
{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;
    //save
    public void saveStudent(Student student)
    {
        try(Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Save succesfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //get by id
    public Student getByid(long id)
    {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, id);
            return student;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        //update

}

