package peaksoft.hibernateconfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;


public class HibernateConfig {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try { return  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            /*Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory1= configuration.buildSessionFactory();
            return sessionFactory1;*/
        }catch (Throwable ex) {
            System.out.println("Session not created" + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutDown(){
        sessionFactory.close();
    }
}
