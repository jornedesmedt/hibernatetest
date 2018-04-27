package com.jdesmedt.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Jorne on 27/04/2018.
 */
public class Application
{
    public static void main(String[] args)
    {
        Person link = new Person();
        link.setName("Link");
        Person zelda = new Person();
        zelda.setName("Zelda");
        Person ganon = new Person();
        ganon.setName("Ganondorf");

        link.getWeapons().add(new Weapon("Master Sword"));
        link.getWeapons().add(new Weapon("Bow"));
        link.getWeapons().add(new Weapon("Boomerang"));

        System.out.println(link);
        System.out.println();

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Weapon.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.openSession();

        session.beginTransaction();
        session.save(link);
        session.save(zelda);
        session.save(ganon);
        session.getTransaction().commit();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Person> result = session.createQuery("from Person").list();
        for (Person p:(List<Person>)result)
        {
            System.out.println(p);
        }

        session.close();
        sessionFactory.close();
    }
}
