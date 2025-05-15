package com.lcwd.hiber;

import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;
import jakarta.persistence.Id;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.rmi.StubNotFoundException;
import java.sql.SQLOutput;
import java.util.List;


public class StudentService {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;

    //save
    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Save succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //get by id
    public Student getByid(long id) {
        try (Session session = sessionFactory.openSession()) {

            return session.get(Student.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public Student updateStudent(long id, Student student) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Student oldStudent = session.get(Student.class, student.getId());

            if (oldStudent != null) {

                oldStudent.setName(student.getName());
                oldStudent.setFatherName(student.getFatherName());

                oldStudent = session.merge(oldStudent);

            }
            transaction.commit();
            System.out.println("Student updated successfully.");
            return oldStudent;

        }
    }

    //Delete
    public void deleteStudent(long id)
    {
        try(Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class,id);

            if(student != null)
            {
                session.remove(student);
                transaction.commit();
                System.out.println("Student deleted successfully.");
            }
            else
            {
                System.out.println("Student not found !!");
            }
        }
    }

    //HQl[JPA] --> native query
    //Database independent

    //get all student using HQL
    public List<Student> getAllStudentHQL()
    {
        try(Session session = sessionFactory.openSession())
        {
            String getHQL = "FROM Student";
            Query<Student> query = session.createQuery(getHQL, Student.class);
            return query.list();
        }
    }

    // get student by name
    public Student getStudentNameByHQL(String name)
    {
        try(Session session = sessionFactory.openSession())
        {
            String getNameHQL = "FROM Student WHERE name = :studentName";
            Query<Student> query = session.createQuery(getNameHQL, Student.class);
            query.setParameter("studentName", name);
            return query.uniqueResult();
        }
    }


    //Criteria API








}

