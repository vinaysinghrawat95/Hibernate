package com.lcwd.hiber.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static
    {
        try
        {
            if(sessionFactory == null)
            {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        } catch(Exception e)
        {
            System.out.println("Error in creating session factory " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}

