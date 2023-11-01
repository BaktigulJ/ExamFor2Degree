package peaksoft;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.entity.Person;
import peaksoft.hibernateconfig.HibernateConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {



        Person person = new Person("Anita", 34, "Kira@mail.com","female");



        createPerson(person);
        HibernateConfig.shutDown();


    }

    public static Long createPerson(Person person) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(person);
            session.getTransaction().commit();
            System.out.println("Person with name" + person.getName() + "successfully created");
        }
        return person.getId();
    }

    public static Person PersonById(Long personById) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, personById);

            session.getTransaction().commit();
            if (personById != null) {
                System.out.println("Student with id" + personById + " successfully ");
            } else {
                System.out.println("We couldn't with id" + personById + " successfully ");
            }
            return person;
        }

    }

    public static List<Person> getAllPerson() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Person> per = session.createQuery(" select '*' from Person ").getResultList();

            session.getTransaction().commit();

            System.out.println(per.size() + " student(s) have found ");

            return per;
        }
    }

    public static void deletePersonById(Long personById) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, personById);
            System.out.println(person);
            session.delete(person);
            session.getTransaction().commit();

            System.out.println("Person with id" + personById + "successfully deleted");


        }
    }

    public static void deleteAllPerson() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select '*' from Person ");
            query.executeUpdate();
            session.getTransaction().commit();

            System.out.println("Person with all successfully deleted");

        }
    }
}
