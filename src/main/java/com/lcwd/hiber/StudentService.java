package com.lcwd.hiber;

import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

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
            System.out.println("Save succe" +
                    "sfully");
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
    //Get all student of same college
    public List<Student> getStudentsByCollegeCriteria(String college)
    {
        try(Session session = sessionFactory.openSession()) {
            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
            Root<Student> root = query.from(Student.class);
            query.select(root).where(criteriaBuilder.equal(root.get("college"),college));
            Query<Student> query2 = session.createQuery(query);
            return query2.getResultList();
        }
    }

    //Get the page number and size
    public List<Student> getStudentWithPagination(int pageNo, int pageSize)
    {
        try(Session session = sessionFactory.openSession())
        {
            String pagiQuery = "FROM Student";
            Query<Student> query = session.createQuery(pagiQuery,Student.class);
            query.setFirstResult((pageNo-1)*pageSize);
            query.setMaxResults(pageSize);
            return query.list();
        }
    }







}

