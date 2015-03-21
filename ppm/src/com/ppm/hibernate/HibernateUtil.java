package com.ppm.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*
 * *
 * HibernateUtil class for getting signal thread Hibernate session 
 * @author partha
 */

public class HibernateUtil
{
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    private static SessionFactory sessionFactory;// = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration().configure(HibernateConstants.DEFAUL_CONFIG);

            return cfg.buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void setTestSessionFactory()
    {
        sessionFactory = testBuildSessionFactory();
    }

    private static SessionFactory testBuildSessionFactory()
    {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration().configure(HibernateConstants.TEST_CONFIG);

            return cfg.buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void removeTestBuildSessionFactory()
    {

        sessionFactory = null;
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException
    {
        try {
            Session session = (Session) threadLocal.get();

            if (session == null || !session.isOpen()) {
                if (sessionFactory == null) {
                    sessionFactory = buildSessionFactory();
                }
                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                threadLocal.set(session);
            }

            return session;
        } catch (Exception e) {
            throw new HibernateException("");
        }
    }

    /**
     * Commit the single hibernate session instance.
     * 
     * @throws HibernateException
     */
    public static void commit() throws HibernateException
    {
        Session session = (Session) threadLocal.get();
        if (session != null) {
            session.getTransaction().commit();
            closeSession();
        }
    }

    /**
     * Rollback the single hibernate session instance.
     * 
     * @throws HibernateException
     */
    public static void rollback() throws HibernateException
    {
        Session session = (Session) threadLocal.get();
        if (session != null) {
            session.getTransaction().rollback();
            closeSession();
        }
    }

    /**
     * Close the single hibernate session instance.
     * 
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException
    {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * Close the single hibernate Begin Transaction.
     * 
     * @throws Exception
     */
    public static void beginTranscation() 
    {
        Session session = getSession();
        session.beginTransaction();
    }

   
    
}

